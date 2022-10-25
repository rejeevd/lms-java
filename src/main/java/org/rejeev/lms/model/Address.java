package org.rejeev.lms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="addresses")
public class Address extends AbstractEntity {
    @Column(name = "line1")
    String line1;
    @Column(name = "line2")
    String line2;
    @Column(name = "line3")
    String line3;
    @Column(name = "line4")
    String line4;
    @Column(name = "locality")
    String locality;
    @Column(name = "region")
    String region;
    @Column(name = "country")
    String country;
    @Column(name = "post_code")
    String postCode;

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getLine3() {
        return line3;
    }

    public void setLine3(String line3) {
        this.line3 = line3;
    }

    public String getLine4() {
        return line4;
    }

    public void setLine4(String line4) {
        this.line4 = line4;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    @Override
    public String toString() {
        return "{" + super.toString() +
                "line1='" + line1 + '\'' +
                ", line2='" + line2 + '\'' +
                ", line3='" + line3 + '\'' +
                ", line4='" + line4 + '\'' +
                ", locality='" + locality + '\'' +
                ", region='" + region + '\'' +
                ", country='" + country + '\'' +
                ", postCode='" + postCode + '\'' +
                '}';
    }
}
