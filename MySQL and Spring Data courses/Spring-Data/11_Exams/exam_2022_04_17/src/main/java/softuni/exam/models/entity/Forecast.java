package softuni.exam.models.entity;

import softuni.exam.models.entity.enums.DayOfWeek;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Enumerated;
import javax.persistence.GenerationType;
import javax.persistence.EnumType;
import java.sql.Time;

@Entity
@Table(name = "forecasts")
public class Forecast {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "day_of_week", nullable = false)
    private DayOfWeek dayOfWeek; //TODO This should be enum

    @Column(name = "max_temperature", nullable = false)
    private Double maxTemperature;

    @Column(name = "min_temperature", nullable = false)
    private Double minTemperature;

    @Column(name = "sunrise", nullable = false)
    private Time sunrise;

    @Column(name = "sunset", nullable = false)
    private Time sunset;

    @ManyToOne
    private City city;

    public Forecast() {
    }

    public Forecast(DayOfWeek dayOfWeek, double maxTemperature, double minTemperature, Time sunrise, Time sunset, City city) {
        this.dayOfWeek = dayOfWeek;
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public Time getSunrise() {
        return sunrise;
    }

    public void setSunrise(Time sunrise) {
        this.sunrise = sunrise;
    }

    public Time getSunset() {
        return sunset;
    }

    public void setSunset(Time sunset) {
        this.sunset = sunset;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City aCity) {
        this.city = aCity;
    }
}

