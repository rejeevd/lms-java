package org.rejeev.lms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="book_editions")
public class BookEdition extends AbstractEntity {
    @Column(name = "book_id")
    int bookId;
    String edition;
    String volume;
    String isbn;

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "{" + super.toString() +
                "edition='" + edition + '\'' +
                ", volume='" + volume + '\'' +
                ", isbn='" + isbn + '\'' +
                ", bookId=" + bookId +
                '}';
    }
}
