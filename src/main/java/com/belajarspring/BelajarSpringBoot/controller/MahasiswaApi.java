package com.belajarspring.BelajarSpringBoot.controller;

import com.belajarspring.BelajarSpringBoot.entity.Mahasiswa;
import com.belajarspring.BelajarSpringBoot.service.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // untuk menandai bahwa class ini adalah class untuk rest api controller
@Validated // menandai bahwa class ini untuk mengaksesnya harus menggunakan username password
@RequestMapping("/Api") // untuk mapping url
public class MahasiswaApi {
    private MahasiswaService mahasiswaService;

    @Autowired
    public MahasiswaApi(MahasiswaService mahasiswaService) {
        this.mahasiswaService = mahasiswaService;
    }

    @GetMapping("/mahasiswa")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<Mahasiswa> findAll() {
        return mahasiswaService.listMahasiswa();
    }

    @GetMapping("/mahasiswa/{nim}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Mahasiswa findMahasiswa(@PathVariable("nim") String nim) {
        return mahasiswaService.getMahasiswa(nim);
    }

    @PostMapping(value = "/mahasiswa", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Mahasiswa addMahasiswa(@RequestBody Mahasiswa mahasiswa) {
        return mahasiswaService.insertMahasiswa(mahasiswa);
    }

    @PutMapping(value = "/mahasiswa", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Mahasiswa updateMahasiswa(@RequestBody Mahasiswa mahasiswa) {
        return mahasiswaService.updateMahasiswa(mahasiswa);
    }

    @DeleteMapping("/mahasiswa/{nim}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Mahasiswa deleteMahasiswa(@PathVariable("nim") String nim) {
        Mahasiswa mahasiswa = mahasiswaService.getMahasiswa(nim);
        mahasiswaService.deleteMahasiswa(nim);
        return mahasiswa;
    }
}
