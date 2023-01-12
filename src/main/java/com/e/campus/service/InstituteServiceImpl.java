package com.e.campus.service;

import com.e.campus.model.Institute;
import com.e.campus.repository.InstituteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstituteServiceImpl implements InstituteService{
    private final InstituteRepository instituteRepository;

    public InstituteServiceImpl(InstituteRepository instituteRepository) {
        this.instituteRepository = instituteRepository;
    }


    @Override
    public List<Institute> getAllInstitute() {

        return instituteRepository.findAll();

    };

    @Override
    public Institute addInstitute(Institute institute) {
        return  instituteRepository.save(institute);
    };


    @Override
    public Institute findInstituteByID(Long id) {
        Institute institute =instituteRepository.findInstituteById(id);
        return  institute;
    }

    @Override
    public Institute getInstituteById(Long id) {
        return instituteRepository.getById(id);
    }

    @Override
    public Institute updateInstitute(Long id, Institute institute) {
        Institute updateInstitute = instituteRepository.save(institute);
        return updateInstitute;
    }

    @Override
    public String deleteInstitute(Long id) {
        return "supprımer";
    }
}
