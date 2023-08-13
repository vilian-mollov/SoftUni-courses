package softuni.exam.models.dto;

import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class BookImportDTO {

    @NotNull
    @Size(min = 3, max = 40)
    private String title;

    @NotNull
    @Size(min = 3, max = 40)
    private String author;

    @NotNull
    @Size(min = 5)
    private String description; // todo if needed add Lob ? not sure yet

    @NotNull
    private Boolean available;

    @NotNull
    @Enumerated
    private String genre;

    @NotNull
    @Positive
    private Double rating;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
