package com.e.campus.repository;

import com.e.campus.model.Bolum;
import com.e.campus.service.BolumService;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface BolumRepository extends JpaRepository<Bolum , Long > {



}
