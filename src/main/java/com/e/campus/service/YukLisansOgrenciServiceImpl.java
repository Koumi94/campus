package com.e.campus.service;

import com.e.campus.model.YukseklisansOgrenci;
import com.e.campus.repository.YukLisansOgrenciRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public  class YukLisansOgrenciServiceImpl implements YukLisansOgrenciService{

    private YukLisansOgrenciRepository yukLisansOgrenciRepository;


    public void YuklisansOgrenciServiceImpl(YukLisansOgrenciRepository yukLisansOgrenciRepository) {

        this.yukLisansOgrenciRepository = yukLisansOgrenciRepository;
    }

    @Override
    public List<YukseklisansOgrenci> getAllYukLisansOgrenci() {
        return yukLisansOgrenciRepository.findAll();
    }

    @Override
    public YukseklisansOgrenci getYukLisansOgrenciById(Long id) {
        return null;
    }

    @Override
    public YukseklisansOgrenci updateYukLisansOgrenci(Long id, YukseklisansOgrenci yukLisansOgrenci) {
        return null;
    }

    @Override
    public void deleteYukLisansOgrenci(Long id) {

    }


    @Override
    public YukseklisansOgrenci addYukLisansOgrenci(YukseklisansOgrenci yukLisansOgrenci) {
        return null;
    }


}
