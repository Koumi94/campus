package com.e.campus.repository;

import com.e.campus.model.Institute;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;



public interface InstituteRepository extends JpaRepository<Institute, Long> {

    Institute findInstituteById(Long id);


}
