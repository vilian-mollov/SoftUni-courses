package softuni.exam.models.dto;

import softuni.exam.models.entity.Country;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ImportCityDTO {

    @NotNull
    @Size(min = 2, max = 60)
    private String cityName;

    @Size(min = 2)
    private String description;

    @NotNull
    @Min(value = 500)
    private int population;

    @NotNull
    private Long country;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public Long getCountry() {
        return country;
    }

    public void setCountry(Long country) {
        this.country = country;
    }
}
