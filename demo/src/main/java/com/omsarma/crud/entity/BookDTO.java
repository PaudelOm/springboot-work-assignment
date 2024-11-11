package com.omsarma.crud.entity;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.UniqueElements;

public class BookDTO {


    @NotBlank(message = "Name cannot be blank")
    private String title;

    @NotBlank(message = "author name should not be blank")
    private String author;

    @Min(value = 0, message = "was this book written before the Bible")
    @Max(value = 2024, message = "I dont think this book is from future")
    private Integer publishedYear;

    @Pattern(regexp = "SCI-FI|FANTASY|BIOGRAPHY", message = "book should be a SCI-FI, FANTASY or BIOGRAPHY")
    private String genre;

    public BookDTO() {
    }

    public BookDTO(String title, String author, Integer publishedYear, String genre) {
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
        this.genre = genre;
    }

    public BookDTO(String title, String author) {
        this.title = title;
        this.author = author;
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

    public Integer getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(Integer publishedYear) {
        this.publishedYear = publishedYear;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}

