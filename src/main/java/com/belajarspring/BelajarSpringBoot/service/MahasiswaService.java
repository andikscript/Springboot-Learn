package com.belajarspring.BelajarSpringBoot.service;

import com.belajarspring.BelajarSpringBoot.entity.Mahasiswa;

import java.util.List;

public interface MahasiswaService {

    List<Mahasiswa> listMahasiswa();

    Mahasiswa insertMahasiswa(Mahasiswa mahasiswa);

    Mahasiswa getMahasiswa(String nim);

    Mahasiswa updateMahasiswa(Mahasiswa mahasiswa);

    Mahasiswa deleteMahasiswa(String nim);
}
