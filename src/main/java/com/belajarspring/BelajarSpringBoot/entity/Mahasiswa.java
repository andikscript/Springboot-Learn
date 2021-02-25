package com.belajarspring.BelajarSpringBoot.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Mahasiswa {
    private String nim;
    private String nama;
    private String prodi;
    private Integer version;

    @Id
    @Column(name = "nim", nullable = false, length = 10)
    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    @Basic
    @Column(name = "nama", nullable = false, length = 50)
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @Basic
    @Column(name = "prodi", nullable = false, length = 5)
    public String getProdi() {
        return prodi;
    }

    public void setProdi(String prodi) {
        this.prodi = prodi;
    }

    @Version
    @Column(name = "version", columnDefinition = "Integer DEFAULT 0")
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mahasiswa mahasiswa = (Mahasiswa) o;
        return Objects.equals(nim, mahasiswa.nim) &&
                Objects.equals(nama, mahasiswa.nama) &&
                Objects.equals(prodi, mahasiswa.prodi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nim, nama, prodi);
    }
}
