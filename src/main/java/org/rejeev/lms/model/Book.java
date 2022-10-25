package org.rejeev.lms.model;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name="books")
public class Book extends AbstractEntity {
    String title;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "book_authors", joinColumns = @JoinColumn(name = "book_id"))
    @AttributeOverrides({
            @AttributeOverride(name = "authorId", column = @Column(name = "author_id")),
            @AttributeOverride(name = "authorFirstName", column = @Column(name = "author_first_name")),
            @AttributeOverride(name = "authorLastName", column = @Column(name = "author_last_name"))
    })
    List<BookAuthor> authors;
    String description;
    @Column(name = "image_url")
    String imageUrl;
    String isbn;
    String language;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<BookAuthor> getAuthors() {
        return authors;
    }

    public void setAuthors(List<BookAuthor> authors) {
        this.authors = authors;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "{" + super.toString() +
                "title='" + title + '\'' +
                ", authors=" + authors +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", isbn='" + isbn + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
