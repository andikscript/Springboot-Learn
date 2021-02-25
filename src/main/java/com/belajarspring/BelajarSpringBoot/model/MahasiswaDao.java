package com.belajarspring.BelajarSpringBoot.model;

import com.belajarspring.BelajarSpringBoot.entity.Mahasiswa;
import com.belajarspring.BelajarSpringBoot.service.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Service
public class MahasiswaDao implements MahasiswaService {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager em;

    @Autowired // anotasi untuk menandai injeksi
    public MahasiswaDao(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
        em = entityManagerFactory.createEntityManager();
    }

    @Override
    public List<Mahasiswa> listMahasiswa() {
        return em.createQuery("from Mahasiswa", Mahasiswa.class).getResultList();
    }

    @Override
    public Mahasiswa insertMahasiswa(Mahasiswa mahasiswa) {
        em.getTransaction().begin();
        em.persist(mahasiswa);
        em.getTransaction().commit();
        return mahasiswa;
    }

    @Override
    public Mahasiswa getMahasiswa(String nim) {
        return em.find(Mahasiswa.class, nim);
    }

    @Override
    public Mahasiswa updateMahasiswa(Mahasiswa mahasiswa) {
        em.getTransaction().begin();
        em.merge(mahasiswa);
        em.getTransaction().commit();
        return mahasiswa;
    }

    @Override
    public Mahasiswa deleteMahasiswa(String nim) {
        em.getTransaction().begin();
        em.remove(em.find(Mahasiswa.class, nim));
        em.getTransaction().commit();
        return em.find(Mahasiswa.class, nim);
    }
}
