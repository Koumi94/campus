package com.e.campus.service;

import com.e.campus.model.Contract;
import com.e.campus.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractService {
    @Autowired
    private ContractRepository contractRepository;

    public void createContract(Contract contract) {
        contractRepository.save(contract);
    }

    public void deleteContract(Long id) {
        contractRepository.deleteById(id);
    }
}
