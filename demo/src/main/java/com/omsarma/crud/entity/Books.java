package com.omsarma.crud.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="BOOKS")
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    
    @Column(name= "TITLE", nullable = false)
    private String title;

    @Column(name="AUTHOR", nullable = false)
    private String author;
    
    @Column(name="published_year")
    private Integer publishedYear;
    
    @Column(name="genre")
    private String genre;

    // Default constructor
    public Books() {
    }

	public Books(Long id, String title, String author, Integer publishedYear, String genre) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.publishedYear = publishedYear;
		this.genre = genre;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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



	@Override
	public String toString() {
		return "Books [id=" + id + ", title=" + title + ", author=" + author + ", publishedYear=" + publishedYear
				+ ", genre=" + genre + "]";
	}

	
    
}
