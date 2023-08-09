package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ImportConstellationDTO;
import softuni.exam.models.entity.Constellation;
import softuni.exam.repository.ConstellationRepository;
import softuni.exam.service.ConstellationService;
import softuni.exam.util.ValidationUtils;
import softuni.exam.util.ValidationUtilsImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static softuni.exam.util.Constants.*;

@Service
public class ConstellationServiceImpl implements ConstellationService {

    private static String CONSTELLATION_PATH = "src/main/resources/files/json/constellations.json";
    private ConstellationRepository constellationRepository;
    private Gson gson;
    private ModelMapper modelMapper;
    private ValidationUtils validationUtils;

    @Autowired
    public ConstellationServiceImpl(ConstellationRepository constellationRepository,
                                    Gson gson,
                                    ModelMapper modelMapper,
                                    ValidationUtilsImpl validationUtils) {
        this.constellationRepository = constellationRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return constellationRepository.count() > 0;
    }

    @Override
    public String readConstellationsFromFile() throws IOException {
        return Files.readString(Path.of(CONSTELLATION_PATH));
    }

    @Override
    public String importConstellations() throws IOException {

        StringBuilder stringBuilder = new StringBuilder();

        List<ImportConstellationDTO> importConstellationDTOS =
                Arrays.stream(this.gson.fromJson(readConstellationsFromFile(), ImportConstellationDTO[].class))
                        .collect(Collectors.toList());

        for (ImportConstellationDTO dto : importConstellationDTOS) {
            stringBuilder.append(System.lineSeparator());

            if (!this.validationUtils.isValid(dto) || constellationRepository.findFirstByName(dto.getName()).isPresent()) {
                stringBuilder.append(String.format(INVALID_FORMAT, CONSTELLATION));
                continue;
            }

            Constellation constellation = this.modelMapper.map(dto, Constellation.class);
            constellationRepository.save(constellation);
            stringBuilder.append(String.format(SUCCESSFUL_FORMAT, CONSTELLATION, dto.getName(), dto.getDescription()));
        }


        return stringBuilder.toString().trim();
    }
}
