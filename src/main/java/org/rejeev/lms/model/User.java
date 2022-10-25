package org.rejeev.lms.model;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User extends AbstractEntity {
    @Column(name="user_id")
    String userId;
    @Column(name="first_name")
    String firstName;
    @Column(name="last_name")
    String lastName;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "contact_id", referencedColumnName = "id")
    ContactInfo contactInfo;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

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

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    @Override
    public String toString() {
        return "{" + super.toString() +
                "userId='" + userId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", contactInfo=" + contactInfo +
                '}';
    }
}
