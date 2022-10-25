package org.rejeev.lms.model;

import jakarta.persistence.*;

@MappedSuperclass
public class AbstractEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id", updatable = false, nullable = false)
    int id;
    @Column(name="status")
    String status;
    @Column(name="creation_time")
    long creationTime;
    @Column(name="mod_time")
    long modificationTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(long creationTime) {
        this.creationTime = creationTime;
    }

    public long getModificationTime() {
        return modificationTime;
    }

    public void setModificationTime(long modificationTime) {
        this.modificationTime = modificationTime;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", creationTime=" + creationTime +
                ", modificationTime=" + modificationTime +
                '}';
    }
}
