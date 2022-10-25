package org.rejeev.lms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="book_inventories")
public class BookInventory extends AbstractEntity {
    @Column(name = "book_id")
    int bookId;
    @Column(name = "edition_id")
    Integer editionId;
    @Column(name = "total_count")
    int totalCount; //total = available + borrowed + suspended
    @Column(name = "avl_count")
    int availableCount;
    int borrowed;
    int suspended;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public Integer getEditionId() {
        return editionId;
    }

    public void setEditionId(Integer editionId) {
        this.editionId = editionId;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getAvailableCount() {
        return availableCount;
    }

    public void setAvailableCount(int availableCount) {
        this.availableCount = availableCount;
    }

    public int getBorrowed() {
        return borrowed;
    }

    public void setBorrowed(int borrowed) {
        this.borrowed = borrowed;
    }

    public int getSuspended() {
        return suspended;
    }

    public void setSuspended(int suspended) {
        this.suspended = suspended;
    }

    @Override
    public String toString() {
        return "{" + super.toString() +
                "bookId=" + bookId +
                ", editionId=" + editionId +
                ", totalCount=" + totalCount +
                ", availableCount=" + availableCount +
                ", borrowed=" + borrowed +
                ", suspended=" + suspended +
                '}';
    }
}
