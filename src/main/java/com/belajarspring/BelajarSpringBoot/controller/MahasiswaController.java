package com.belajarspring.BelajarSpringBoot.controller;

import com.belajarspring.BelajarSpringBoot.entity.Mahasiswa;
import com.belajarspring.BelajarSpringBoot.service.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class MahasiswaController {

    private MahasiswaService mahasiswaService;

    @Autowired
    public MahasiswaController(MahasiswaService mahasiswaService) {
        this.mahasiswaService = mahasiswaService;
    }

    @GetMapping("")
    public String home(Model model) {
        model.addAttribute("mahasiswa", mahasiswaService.listMahasiswa());
        return "home";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public String showInsert(Model model) {
        model.addAttribute("dataMahasiswa", new Mahasiswa());
        return "insert";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insertMahasiswa(Model model, Mahasiswa mahasiswa) {
        model.addAttribute("dataMahasiswa", mahasiswaService.insertMahasiswa(mahasiswa));
        return "redirect:/";
    }

    @RequestMapping(value = "/update/{nim}", method = RequestMethod.GET)
    public String showUpdate(Model model, @PathVariable String nim) {
        model.addAttribute("updateMahasiswa", mahasiswaService.getMahasiswa(nim));
        return "update";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateMahasiswa(Model model, Mahasiswa mahasiswa) {
        model.addAttribute("updateMahasiswa", mahasiswaService.updateMahasiswa(mahasiswa));
        return "redirect:/";
    }

    @RequestMapping(value = "/delete/{nim}", method = RequestMethod.GET)
    public String showDelete(Model model, @PathVariable String nim) {
        model.addAttribute("deleteMahasiswa", mahasiswaService.getMahasiswa(nim));
        return "delete";
    }

    @RequestMapping(value = "/delete")
    public String deleteMahasiswa(Model model, Mahasiswa mahasiswa) {
        model.addAttribute("deleteMahasiswa", mahasiswaService.deleteMahasiswa(mahasiswa.getNim()));
        return "redirect:/";
    }
}
