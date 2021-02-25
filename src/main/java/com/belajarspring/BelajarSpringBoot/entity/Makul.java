package com.belajarspring.BelajarSpringBoot.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Makul {
    private String id;
    private String matkul;
    private String sks;

    @Id
    @Column(name = "id", nullable = false, length = 4)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "matkul", nullable = false, length = 30)
    public String getMatkul() {
        return matkul;
    }

    public void setMatkul(String matkul) {
        this.matkul = matkul;
    }

    @Basic
    @Column(name = "sks", nullable = false, length = 1)
    public String getSks() {
        return sks;
    }

    public void setSks(String sks) {
        this.sks = sks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Makul makul = (Makul) o;
        return Objects.equals(id, makul.id) &&
                Objects.equals(matkul, makul.matkul) &&
                Objects.equals(sks, makul.sks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, matkul, sks);
    }
}
