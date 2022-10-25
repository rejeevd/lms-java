package org.rejeev.lms.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class BookAuthor {
    int authorId;
    String authorFirstName;
    String authorLastName;

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    @Override
    public String toString() {
        return "{" +
                "authorId=" + authorId +
                ", authorFirstName='" + authorFirstName + '\'' +
                ", authorLastName='" + authorLastName + '\'' +
                '}';
    }
}
