package softuni.exam.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book extends BaseEntity{

    @Column(name = "title",nullable = false,unique = true)
    private String title;

    @Column(name = "author",nullable = false)
    private String author;

    @Column(name = "description",nullable = false,columnDefinition = "Text")
    private String description;

    @Column(name = "available",nullable = false)
    private Boolean available;

    @Column(name = "genre",nullable = false)
    private String genre; // todo ENUM

    @Column(name = "rating",nullable = false)
    private Double rating;

    public Book() {
    }

    public Book(String title, String author, String description, Boolean available, String genre, Double rating) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.available = available;
        this.genre = genre;
        this.rating = rating;
    }

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

