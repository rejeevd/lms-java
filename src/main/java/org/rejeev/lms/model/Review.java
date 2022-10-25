package org.rejeev.lms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.rejeev.lms.hibernate.StringArrayToStringConverter;

import java.util.List;
@Entity
@Table(name="reviews")
public class Review extends AbstractEntity {
    @Column(name = "book_id")
    int bookId;
    @Column(name = "user_id")
    int userId;
    String title;
    String content;
    int rating;
    @Column(name = "shelves")
    @Convert(converter = StringArrayToStringConverter.class)
    List<String> shelves;
    @Column(name = "start_date")
    String startDate;
    @Column(name = "end_date")
    String endDate;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public List<String> getShelves() {
        return shelves;
    }

    public void setShelves(List<String> shelves) {
        this.shelves = shelves;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "{" + super.toString() +
                "bookId=" + bookId +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", rating=" + rating +
                ", shelves=" + shelves +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}
