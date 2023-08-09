package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ForecastImportDTO;
import softuni.exam.models.dto.ForecastMergeDTO;
import softuni.exam.models.dto.ForecastWrapperDTO;
import softuni.exam.models.entity.Forecast;
import softuni.exam.models.entity.enums.DayOfWeek;
import softuni.exam.repository.CityRepository;
import softuni.exam.repository.ForecastRepository;
import softuni.exam.service.ForecastService;
import softuni.exam.util.ValidationUtils;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static softuni.exam.models.constants.Constants.*;

@Service
public class ForecastServiceImpl implements ForecastService {

    private static final String FORECAST_PATH = "src/main/resources/files/xml/forecasts.xml";
    private ForecastRepository forecastRepository;
    private CityRepository cityRepository;
    private ValidationUtils validationUtils;
    private ModelMapper modelMapper;
    private final XmlParser xmlParser;

    @Autowired
    public ForecastServiceImpl(ForecastRepository forecastRepository,
                               CityRepository cityRepository,
                               ValidationUtils validationUtils,
                               ModelMapper modelMapper,
                               XmlParser xmlParser) {
        this.forecastRepository = forecastRepository;
        this.cityRepository = cityRepository;
        this.validationUtils = validationUtils;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return forecastRepository.count() > 0;
    }

    @Override
    public String readForecastsFromFile() throws IOException {
        return Files.readString(Path.of(FORECAST_PATH));
    }

    @Override
    public String importForecasts() throws IOException, JAXBException {

        StringBuilder stringBuilder = new StringBuilder();

        List<ForecastImportDTO> forecasts =
                this.xmlParser.fromFile(Path.of(FORECAST_PATH).toFile(), ForecastWrapperDTO.class).getForecasts();

        List<ForecastMergeDTO> forecastMergeDTOS = new ArrayList<>();

        for (ForecastImportDTO forecast : forecasts) {

            ForecastMergeDTO dto = new ForecastMergeDTO();

            dto.setCity(cityRepository.findById(forecast.getCity()).orElse(null));
            dto.setDayOfWeek(forecast.getDayOfWeek());
            dto.setSunrise(forecast.getSunrise());
            dto.setSunset(forecast.getSunset());
            dto.setMaxTemperature(forecast.getMaxTemperature());
            dto.setMinTemperature(forecast.getMinTemperature());

            forecastMergeDTOS.add(dto);
        }


        for (ForecastMergeDTO forecast : forecastMergeDTOS) {

            stringBuilder.append(System.lineSeparator());

            if (!validationUtils.isValid(forecast) || forecastRepository.findFirstByDayOfWeekAndCity(forecast.getDayOfWeek(), forecast.getCity()).isPresent()) {
                stringBuilder.append(String.format(INVALID_FORMAT, FORECAST));
                continue;
            }

            Forecast forecastToAdd = modelMapper.map(forecast,Forecast.class);

            forecastRepository.save(forecastToAdd);

            DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
            symbols.setDecimalSeparator('.');
            DecimalFormat decimalFormat = new DecimalFormat("0.00",symbols);
            String formattedValue = decimalFormat.format(forecast.getMaxTemperature());

            stringBuilder.append(String.format(SUCCESS_FORMAT, FORECAST, forecast.getDayOfWeek(), formattedValue));

        }


        return stringBuilder.toString().trim();
    }

    @Override
    public String exportForecasts() {
        DayOfWeek sunday = DayOfWeek.SUNDAY;
        List<Forecast> sundays = forecastRepository.findAllByDayOfWeekOrderByMaxTemperatureDesc(sunday);

        sundays = sundays.stream().filter(f -> f.getCity().getPopulation() < 150000).collect(Collectors.toList());

        // todo sort
        sundays = sundays.stream()
                .sorted(Comparator.comparing(Forecast::getMaxTemperature).reversed()
                        .thenComparing(Forecast::getId))
                .collect(Collectors.toList());

        StringBuilder stringBuilder = new StringBuilder();

        for (Forecast day : sundays) {

            String min = getCorrectDecimalValue(day.getMinTemperature());
            String max = getCorrectDecimalValue(day.getMaxTemperature());

            stringBuilder.append(String
                    .format("City: %s\n"+
                            "-min temperature: %s\n"+
                            "--max temperature: %s\n"+
                            "---sunrise: %s\n"+
                            "----sunset: %s\n"
                    ,day.getCity().getCityName()
                    ,min,
                    max,
                    day.getSunrise()
                    ,day.getSunset()));
        }

        return stringBuilder.toString().trim();
    }

    private static String getCorrectDecimalValue(Double value) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        symbols.setDecimalSeparator('.');
        DecimalFormat decimalFormat = new DecimalFormat("0.00",symbols);
        return decimalFormat.format(value);
    }
}
