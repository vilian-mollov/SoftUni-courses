package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.BorrowingRecordImportDTO;
import softuni.exam.models.dto.BorrowingRecordWrapperDTO;
import softuni.exam.models.entity.Book;
import softuni.exam.models.entity.BorrowingRecord;
import softuni.exam.models.entity.LibraryMember;
import softuni.exam.repository.BookRepository;
import softuni.exam.repository.BorrowingRecordRepository;
import softuni.exam.repository.LibraryMemberRepository;
import softuni.exam.service.BorrowingRecordsService;
import softuni.exam.util.ValidationUtils;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

import static softuni.exam.util.Constants.*;

@Service
public class BorrowingRecordsServiceImpl implements BorrowingRecordsService {

    private static String BORROWING_RECORD_FILE_PATH = "src/main/resources/files/xml/borrowing-records.xml";

    private BorrowingRecordRepository borrowingRecordRepository;
    private BookRepository bookRepository;

    private LibraryMemberRepository libraryMemberRepository;

    private XmlParser xmlParser;
    private ModelMapper modelMapper;
    private ValidationUtils validationUtils;

    @Autowired
    public BorrowingRecordsServiceImpl(BorrowingRecordRepository borrowingRecordRepository,
                                       BookRepository bookRepository,
                                       LibraryMemberRepository libraryMemberRepository,
                                       XmlParser xmlParser,
                                       ModelMapper modelMapper,
                                       ValidationUtils validationUtils) {
        this.borrowingRecordRepository = borrowingRecordRepository;
        this.bookRepository = bookRepository;
        this.libraryMemberRepository = libraryMemberRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return borrowingRecordRepository.count() > 0;
    }

    @Override
    public String readBorrowingRecordsFromFile() throws IOException {
        return Files.readString(Path.of(BORROWING_RECORD_FILE_PATH));
    }

    @Override
    public String importBorrowingRecords() throws IOException, JAXBException {

        StringBuilder stringBuilder = new StringBuilder();

        List<BorrowingRecordImportDTO> recordsDTOs = xmlParser
                .fromFile(Path.of(BORROWING_RECORD_FILE_PATH).toFile(), BorrowingRecordWrapperDTO.class)
                .getBorrowingRecords();


        for (BorrowingRecordImportDTO dto : recordsDTOs) {
            stringBuilder.append(System.lineSeparator());

            if (!validationUtils.isValid(dto) ||
                    bookRepository.findFirstByTitle(dto.getBook().getTitle()).isEmpty() ||
                        libraryMemberRepository.findFirstById(dto.getMember().getId()).isEmpty()) {
                stringBuilder.append(String.format(INVALID_FORMAT, BORROWING_RECORD));
                continue;
            }

            Optional<Book> book = bookRepository.findFirstByTitle(dto.getBook().getTitle());
            Optional<LibraryMember> member = libraryMemberRepository.findFirstById(dto.getMember().getId());

            BorrowingRecord borrowingRecord = modelMapper.map(dto, BorrowingRecord.class);
            borrowingRecord.setBook(book.get());
            borrowingRecord.setLibraryMember(member.get());

            borrowingRecordRepository.save(borrowingRecord);

            stringBuilder.append(String.format(SUCCESSFUL_FORMAT, BORROWING_RECORD,
                                                                    dto.getBook().getTitle(),
                                                                    "- " + dto.getBorrowDate()));

        }


        return stringBuilder.toString().trim();
    }

    @Override
    public String exportBorrowingRecords() {

        StringBuilder stringBuilder = new StringBuilder();

        List<Optional<BorrowingRecord>> borrowRecords = borrowingRecordRepository.findAllByBook_GenreOrderByBorrowDateDesc("SCIENCE_FICTION");


        for (Optional<BorrowingRecord> rec : borrowRecords) {

            stringBuilder.append(String.format(
                    "Book title: %s\n"+
                    "*Book author: %s\n"+
                    "**Date borrowed: %s\n"+
                    "***Borrowed by: %s %s\n",
                    rec.get().getBook().getTitle(),
                    rec.get().getBook().getAuthor(),
                    rec.get().getBorrowDate(),
                    rec.get().getLibraryMember().getFirstName(),
                    rec.get().getLibraryMember().getLastName()));

        }


        return stringBuilder.toString().trim();
    }
}
