package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.LibraryMemberImportDTO;
import softuni.exam.models.entity.LibraryMember;
import softuni.exam.repository.LibraryMemberRepository;
import softuni.exam.service.LibraryMemberService;
import softuni.exam.util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static softuni.exam.util.Constants.*;

@Service
public class LibraryMemberServiceImpl implements LibraryMemberService {

    private static String LIBRARY_MEMBERS = "src/main/resources/files/json/library-members.json";

    private LibraryMemberRepository libraryMemberRepository;

    private Gson gson;
    private ModelMapper modelMapper;
    private ValidationUtils validationUtils;

    @Autowired
    public LibraryMemberServiceImpl(LibraryMemberRepository libraryMemberRepository,
                                    Gson gson,
                                    ModelMapper modelMapper,
                                    ValidationUtils validationUtils) {
        this.libraryMemberRepository = libraryMemberRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return libraryMemberRepository.count() > 0;
    }

    @Override
    public String readLibraryMembersFileContent() throws IOException {
        return Files.readString(Path.of(LIBRARY_MEMBERS));
    }

    @Override
    public String importLibraryMembers() throws IOException {

        StringBuilder sb = new StringBuilder();

        List<LibraryMemberImportDTO> libMembersDTOs = Arrays.stream(gson.fromJson(readLibraryMembersFileContent(),
                            LibraryMemberImportDTO[].class))
                .collect(Collectors.toList());

        for (LibraryMemberImportDTO dto : libMembersDTOs) {
            sb.append(System.lineSeparator());
            if (!validationUtils.isValid(dto) ||
                    libraryMemberRepository.findFirstByPhoneNumber(dto.getPhoneNumber()).isPresent()) {

                sb.append(String.format(INVALID_FORMAT, LIBRARY_MEMBER));
                continue;
            }

            LibraryMember member = modelMapper.map(dto, LibraryMember.class);
            libraryMemberRepository.save(member);

            sb.append(String.format(SUCCESSFUL_FORMAT, LIBRARY_MEMBER, dto.getFirstName(),"- "+dto.getLastName()));

        }


        return sb.toString().trim();
    }
}
