package softuni.exam.models.dto;

import softuni.exam.models.entity.City;
import softuni.exam.models.entity.enums.DayOfWeek;

import javax.persistence.Enumerated;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Date;

@XmlRootElement(name = "forecast")
@XmlAccessorType(XmlAccessType.FIELD)
public class ForecastImportDTO {
    @NotNull
    @Enumerated
    @XmlElement(name = "day_of_week")
    private DayOfWeek dayOfWeek;

    @NotNull
    @DecimalMin(value = "-20.00")
    @DecimalMax(value = "60.00")
    @XmlElement(name = "max_temperature")
    private Double maxTemperature;

    @NotNull
    @XmlElement(name = "min_temperature")
    @DecimalMin(value = "-50.00")
    @DecimalMax(value = "40.00")
    private Double minTemperature;

    @NotNull
    @XmlElement(name = "sunrise")
    private String sunrise;

    @NotNull
    @XmlElement(name = "sunset")
    private String sunset;

    @NotNull
    @XmlElement(name = "city")
    private Long city;

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(Double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public Double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(Double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public Long getCity() {
        return city;
    }

    public void setCity(Long city) {
        this.city = city;
    }
}
