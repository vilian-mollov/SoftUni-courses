package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ExportStarDTO;
import softuni.exam.models.dto.ImportStarDTO;
import softuni.exam.models.entity.Constellation;
import softuni.exam.models.entity.Star;
import softuni.exam.repository.ConstellationRepository;
import softuni.exam.repository.StarRepository;
import softuni.exam.service.StarService;
import softuni.exam.util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

import static softuni.exam.util.Constants.*;

@Service
public class StarServiceImpl implements StarService {

    private static String STAR_PATH = "src/main/resources/files/json/stars.json";
    private StarRepository starRepository;
    private ConstellationRepository constellationRepository;
    private Gson gson;
    private ModelMapper modelMapper;
    private ValidationUtils validationUtils;

    @Autowired
    public StarServiceImpl(StarRepository starRepository,
                           ConstellationRepository constellationRepository,
                           Gson gson,
                           ModelMapper modelMapper,
                           ValidationUtils validationUtils) {
        this.starRepository = starRepository;
        this.constellationRepository = constellationRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return starRepository.count() > 0;
    }

    @Override
    public String readStarsFileContent() throws IOException {
        return Files.readString(Path.of(STAR_PATH));
    }

    @Override
    public String importStars() throws IOException {

        StringBuilder stringBuilder = new StringBuilder();

        List<ImportStarDTO> ImportStarDTOs = Arrays.stream(this.gson.fromJson(readStarsFileContent(), ImportStarDTO[].class))
                .collect(Collectors.toList());

        for (ImportStarDTO dto : ImportStarDTOs) {
            stringBuilder.append(System.lineSeparator());

            if (!this.validationUtils.isValid(dto) || starRepository.findFirstByName(dto.getName()).isPresent()) {
                stringBuilder.append(String.format(INVALID_FORMAT, STAR));
                continue;
            }

            Constellation constellation = constellationRepository.findById(dto.getConstellation()).orElse(null);

            ExportStarDTO exportStarDTO = new ExportStarDTO();
            exportStarDTO.setConstellation(constellation);
            exportStarDTO.setDescription(dto.getDescription());
            exportStarDTO.setName(dto.getName());
            exportStarDTO.setLightYears(dto.getLightYears());
            exportStarDTO.setStarType(dto.getStarType());

            Star star = this.modelMapper.map(exportStarDTO, Star.class);
            starRepository.save(star);
                                                                        //25.34 light years
            DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
            symbols.setDecimalSeparator('.');
            DecimalFormat decimalFormat = new DecimalFormat("0.00",symbols);
            String formattedValue = decimalFormat.format(dto.getLightYears());
            stringBuilder.append(String.format(SUCCESSFUL_FORMAT, STAR, dto.getName(), formattedValue + " light years" ));

        }


        return stringBuilder.toString().trim();
    }

    @Override
    public String exportStars() {

//        return this.tasksRepository.findAllByCarCarTypeOrderByPriceDesc(CarType.coupe)
//                .stream()
//                .map(task -> this.modelMapper.map(task, TaskDto.class))
//                .map(TaskDto::toString)
//                .collect(Collectors.joining())
//                .trim();

        List<Star> redGiants = starRepository.findAllByStarTypeOrderByLightYearsAsc("RED_GIANT");

        StringBuilder stringBuilder = new StringBuilder();

        for (Star redGiant : redGiants) {
            if(redGiant.getObservers().size() == 0) {
                stringBuilder.append(redGiant);
            }

        }


        return stringBuilder.toString().trim();
    }
}
