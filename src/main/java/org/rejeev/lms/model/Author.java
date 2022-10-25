package org.rejeev.lms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="authors")
public class Author extends AbstractEntity {
    @Column(name = "first_name")
    String firstName;
    @Column(name = "last_name")
    String lastName;
    @Column(name = "about_text", columnDefinition = "TEXT")
    String aboutText;
    @Column(name = "photo_url")
    String photoUrl;
    String website;
    String dob;
    String country;
    String education;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAboutText() {
        return aboutText;
    }

    public void setAboutText(String aboutText) {
        this.aboutText = aboutText;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public String toString() {
        return "{" + super.toString() +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", aboutText='" + aboutText + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                ", website='" + website + '\'' +
                ", dob='" + dob + '\'' +
                ", country='" + country + '\'' +
                ", education='" + education + '\'' +
                '}';
    }
}
