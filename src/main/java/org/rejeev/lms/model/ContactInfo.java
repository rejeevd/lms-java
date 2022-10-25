package org.rejeev.lms.model;

import jakarta.persistence.*;

@Entity
@Table(name="contact_infos")
public class ContactInfo extends AbstractEntity {
    @Column(name="email")
    String email;
    @Column(name="phone")
    String phone;
    @Column(name="mobile_phone")
    String mobilePhone;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    Address address;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "{" + super.toString() +
                "email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", address=" + address +
                '}';
    }
}
