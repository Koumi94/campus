package com.e.campus.service;

import com.e.campus.model.Bolum;
import com.e.campus.repository.BolumRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BolumServiceImpl implements BolumService {
    private final BolumRepository bolumRepository;
    public BolumServiceImpl(BolumRepository bolumRepository) {
        super();
        this.bolumRepository = bolumRepository;
    }
    @Override
    public List<Bolum> getAllBolumler() {
        return bolumRepository.findAll();
    }
    @Override
    public Optional<Bolum> getBolumById(Long id) {
        return bolumRepository.findById(id);
    }
    @Override
    public Bolum addBolum(Bolum bolum) {
        return bolumRepository.save(bolum);
    }
    @Override
    public Bolum updateBolum(Long id, Bolum bolum) {
        return bolumRepository.save(bolum);
    }
    @Override
    public Bolum  deleteBolum(Long id) {
        return null;
    }


}
