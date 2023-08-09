package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ImportCityDTO;
import softuni.exam.models.dto.MergeCityDTO;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CityRepository;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CityService;
import softuni.exam.util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static softuni.exam.models.constants.Constants.*;

@Service
public class CityServiceImpl implements CityService {

    private static final String CITY_PATH = "src/main/resources/files/json/cities.json";
    private CityRepository cityRepository;
    private CountryRepository countryRepository;
    private ValidationUtils validationUtils;
    private Gson gson;
    private ModelMapper modelMapper;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository,
                           CountryRepository countryRepository, ValidationUtils validationUtils,
                           Gson gson,
                           ModelMapper modelMapper) {
        this.cityRepository = cityRepository;
        this.countryRepository = countryRepository;
        this.validationUtils = validationUtils;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return cityRepository.count() > 0;
    }

    @Override
    public String readCitiesFileContent() throws IOException {
        return Files.readString(Path.of(CITY_PATH));
    }

    @Override
    public String importCities() throws IOException {

        StringBuilder stringBuilder = new StringBuilder();

        List<MergeCityDTO> citiesDTO = getMergedCityDTO();

        for (MergeCityDTO dto : citiesDTO) {
            stringBuilder.append(System.lineSeparator());

            if (cityRepository.findFirstByCityName(dto.getCityName()).isPresent() || !validationUtils.isValid(dto)) {
                stringBuilder.append(String.format(INVALID_FORMAT, CITY));
                continue;
            }

            City city = this.modelMapper.map(dto, City.class);
            cityRepository.save(city);

            stringBuilder.append(String.format(SUCCESS_FORMAT, CITY, dto.getCityName(), dto.getPopulation()));
        }


        return stringBuilder.toString().trim();
    }

    private List<MergeCityDTO> getMergedCityDTO() throws IOException {

        List<MergeCityDTO> citiesDTO = new ArrayList<>();

        List<ImportCityDTO> importCitiesDTO =
                Arrays.stream(this.gson.fromJson(readCitiesFileContent(), ImportCityDTO[].class)).toList();


        for (ImportCityDTO importDTO : importCitiesDTO) {
            MergeCityDTO dto = new MergeCityDTO();
            dto.setCityName(importDTO.getCityName());
            dto.setDescription(importDTO.getDescription());
            dto.setPopulation(importDTO.getPopulation());

            Optional<Country> optionalCountry = countryRepository.findById(importDTO.getCountry());
            Country country = optionalCountry.orElse(null);

            if (country != null) {
                dto.setCountry(country);
            }

            citiesDTO.add(dto);

        }
        return citiesDTO;
    }
}
