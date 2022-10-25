package org.rejeev.lms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.rejeev.lms.hibernate.LongArrayToStringConverter;

import java.util.List;
@Entity
@Table(name="leases")
public class Lease extends AbstractEntity {
    @Column(name = "inventory_id")
    int inventoryId;
    String state;
    @Column(name = "user_id")
    int userId;
    @Column(name = "lease_time")
    long leaseTime;
    @Column(name = "return_time")
    long returnTime;
    @Column(name = "expiry_date")
    String expiryDate;
    @Column(name = "renewals")
    @Convert(converter = LongArrayToStringConverter.class)
    List<Long> renewals;

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public long getLeaseTime() {
        return leaseTime;
    }

    public void setLeaseTime(long leaseTime) {
        this.leaseTime = leaseTime;
    }

    public long getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(long returnTime) {
        this.returnTime = returnTime;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public List<Long> getRenewals() {
        return renewals;
    }

    public void setRenewals(List<Long> previousRenewals) {
        this.renewals = previousRenewals;
    }

    @Override
    public String toString() {
        return "{" + super.toString() +
                "inventoryId=" + inventoryId +
                ", state='" + state + '\'' +
                ", userId=" + userId +
                ", leaseTime=" + leaseTime +
                ", returnTime=" + returnTime +
                ", expiryDate='" + expiryDate + '\'' +
                ", renewals=" + renewals +
                '}';
    }
}
