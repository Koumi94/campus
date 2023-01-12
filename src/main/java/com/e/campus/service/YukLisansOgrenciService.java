package com.e.campus.service;

import com.e.campus.model.YukseklisansOgrenci;
import com.e.campus.repository.InstituteRepository;
import com.e.campus.repository.YukLisansOgrenciRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public interface YukLisansOgrenciService {



    public List<YukseklisansOgrenci> getAllYukLisansOgrenci();


    YukseklisansOgrenci getYukLisansOgrenciById(Long id);



    YukseklisansOgrenci updateYukLisansOgrenci(Long id, YukseklisansOgrenci yukLisansOgrenci);

    void deleteYukLisansOgrenci(Long id);


    YukseklisansOgrenci addYukLisansOgrenci(YukseklisansOgrenci yukLisansOgrenci);
}
