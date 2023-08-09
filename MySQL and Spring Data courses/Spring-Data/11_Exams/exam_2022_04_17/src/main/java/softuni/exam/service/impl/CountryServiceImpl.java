package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ImportCountryDTO;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CountryService;
import softuni.exam.util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static softuni.exam.models.constants.Constants.*;

@Service
public class CountryServiceImpl implements CountryService {
    private static final String COUNTRIES_PATH = "src/main/resources/files/json/countries.json";

    private CountryRepository countryRepository;
    private ValidationUtils validationUtils;
    private ModelMapper modelMapper;
    private Gson gson;

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository,
                              ValidationUtils validationUtils,
                              Gson gson,
                              ModelMapper modelMapper) {
        this.countryRepository = countryRepository;
        this.validationUtils = validationUtils;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.countryRepository.count() > 0;
    }

    @Override
    public String readCountriesFromFile() throws IOException {
        return Files.readString(Path.of(COUNTRIES_PATH));
    }

    @Override
    public String importCountries() throws IOException {

        final StringBuilder stringBuilder = new StringBuilder();

        List<ImportCountryDTO> countriesDTO =
                Arrays.stream(this.gson.fromJson(readCountriesFromFile(), ImportCountryDTO[].class))
                        .toList();

        for (ImportCountryDTO dto : countriesDTO) {

            stringBuilder.append(System.lineSeparator());

//              Invalid country
            if (countryRepository.findFirstByCountryName(dto.getCountryName()).isPresent() || !this.validationUtils.isValid(dto)) {
                stringBuilder.append(String.format(INVALID_FORMAT, COUNTRY));
                continue;
            }

            Country country = this.modelMapper.map(dto, Country.class);
            countryRepository.save(country);

//          Successfully imported country Name - currency
            stringBuilder.append(String.format(SUCCESS_FORMAT, COUNTRY, dto.getCountryName(), dto.getCurrency()));

        }


        return stringBuilder.toString().trim();
    }
}
