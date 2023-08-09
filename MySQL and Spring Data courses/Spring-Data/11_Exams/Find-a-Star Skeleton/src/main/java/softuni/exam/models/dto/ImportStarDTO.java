package softuni.exam.models.dto;

import org.springframework.format.annotation.NumberFormat;

import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class ImportStarDTO {

    @Size(min = 6)
    @NotNull
    private String description;

    @Positive
    @NotNull
    @NumberFormat(pattern = "#.##")
    private Double lightYears;

    @Size(min = 2, max = 30)
    @NotNull
    private String name;

    @Enumerated
    @NotNull
    private String starType;

    @NotNull
    private Long constellation;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getLightYears() {
        return lightYears;
    }

    public void setLightYears(Double lightYears) {
        this.lightYears = lightYears;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStarType() {
        return starType;
    }

    public void setStarType(String starType) {
        this.starType = starType;
    }

    public Long getConstellation() {
        return constellation;
    }

    public void setConstellation(Long constellation) {
        this.constellation = constellation;
    }
}
