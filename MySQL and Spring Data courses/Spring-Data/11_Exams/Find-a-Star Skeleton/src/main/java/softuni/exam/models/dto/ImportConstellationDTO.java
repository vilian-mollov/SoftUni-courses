package softuni.exam.models.dto;

import javax.validation.constraints.Size;

public class ImportConstellationDTO {
    @Size(min = 3, max = 20)
    private String name;
    @Size(min = 5)
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
