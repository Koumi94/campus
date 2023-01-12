package com.e.campus.service;

import com.e.campus.model.Bolum;

import java.util.List;
import java.util.Optional;

public interface BolumService {
    List<Bolum> getAllBolumler();
    Optional<Bolum> getBolumById(Long id);
    Bolum addBolum(Bolum bolum);
    Bolum updateBolum(Long id, Bolum bolum);
    Bolum deleteBolum(Long id);
}