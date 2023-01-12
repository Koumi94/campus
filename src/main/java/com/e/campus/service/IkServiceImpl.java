package com.e.campus.service;

import com.e.campus.model.IK;
import com.e.campus.repository.IkRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IkServiceImpl implements IkService{

    private  final IkRepository ikRepository;



    public IkServiceImpl(IkRepository ikRepository) {
        this.ikRepository = ikRepository;
    }

    @Override
    public IK addIk(IK ik) {
        return ikRepository.save(ik);
    }

    @Override
    public IK updateIk(Long id, IK ik) {
        return ikRepository.save(ik);
    }

    @Override
    public IK deleteIk(Long id) {
       return null;
    }

    @Override
    public List<IK> getAllIk() {
        return ikRepository.findAll();
    }

    @Override
    public Optional<IK> getIkById(Long id) {
        return Optional.empty();
    }
}
