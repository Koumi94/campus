package com.e.campus.repository;

import com.e.campus.model.Institute;
import com.e.campus.model.YukseklisansOgrenci;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YukLisansOgrenciRepository extends JpaRepository<YukseklisansOgrenci, Long> {




}
