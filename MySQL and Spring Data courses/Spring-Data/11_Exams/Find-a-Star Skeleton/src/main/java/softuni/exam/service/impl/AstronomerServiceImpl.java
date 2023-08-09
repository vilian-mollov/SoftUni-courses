package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.AstronomerExportDTO;
import softuni.exam.models.dto.AstronomerImportDTO;
import softuni.exam.models.dto.AstronomerWrapperDTO;
import softuni.exam.models.entity.Astronomer;
import softuni.exam.models.entity.Star;
import softuni.exam.repository.AstronomerRepository;
import softuni.exam.repository.StarRepository;
import softuni.exam.service.AstronomerService;
import softuni.exam.util.ValidationUtils;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;

import static softuni.exam.util.Constants.*;

@Service
public class AstronomerServiceImpl implements AstronomerService {

    private static String ASTRONOMER_PATH = "src/main/resources/files/xml/astronomers.xml";
    private AstronomerRepository astronomerRepository;
    private StarRepository starRepository;
    private XmlParser xmlParser;
    private ModelMapper modelMapper;
    private ValidationUtils validationUtils;

    @Autowired
    public AstronomerServiceImpl(AstronomerRepository astronomerRepository,
                                 StarRepository starRepository,
                                 XmlParser xmlParser,
                                 ModelMapper modelMapper,
                                 ValidationUtils validationUtils) {
        this.astronomerRepository = astronomerRepository;
        this.starRepository = starRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return astronomerRepository.count() > 0;
    }

    @Override
    public String readAstronomersFromFile() throws IOException {
        return Files.readString(Path.of(ASTRONOMER_PATH));
    }

    @Override
    public String importAstronomers() throws IOException, JAXBException {

        StringBuilder stringBuilder = new StringBuilder();

        List<AstronomerImportDTO> importDTOS =
                xmlParser.fromFile(Path.of(ASTRONOMER_PATH).toFile(), AstronomerWrapperDTO.class).getAstronomers();

        for (AstronomerImportDTO dto : importDTOS) {
            stringBuilder.append(System.lineSeparator());

            boolean valid = validationUtils.isValid(dto);
            boolean present = astronomerRepository.findByFirstNameAndLastName(dto.getFirstName(), dto.getLastName()).isPresent();
            boolean empty = starRepository.findById(dto.getStar()).isEmpty();

            if (!validationUtils.isValid(dto) ||
                    astronomerRepository.findByFirstNameAndLastName(dto.getFirstName(), dto.getLastName()).isPresent() ||
                    starRepository.findById(dto.getStar()).isEmpty()) {
                stringBuilder.append(String.format(INVALID_FORMAT, ASTRONOMER));
                continue;
            }

            Star star = starRepository.findById(dto.getStar()).orElse(null);

            AstronomerExportDTO exportDTO = new AstronomerExportDTO();
            exportDTO.setStar(star);
            exportDTO.setBirthday(Date.valueOf(dto.getBirthday()));
            exportDTO.setSalary(dto.getSalary());
            exportDTO.setFirstName(dto.getFirstName());
            exportDTO.setLastName(dto.getLastName());
            exportDTO.setAverageObservationHours(dto.getAverageObservationHours());

            Astronomer astronomer = modelMapper.map(exportDTO, Astronomer.class);
            astronomerRepository.save(astronomer);


            DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
            symbols.setDecimalSeparator('.');
            DecimalFormat decimalFormat = new DecimalFormat("0.00",symbols);
            String formattedValue = decimalFormat.format(dto.getAverageObservationHours());
            stringBuilder.append(String.format(SUCCESSFUL_FORMAT,ASTRONOMER,dto.getFirstName() + " " + dto.getLastName(), formattedValue));

        }

        return stringBuilder.toString().trim();
    }
}
