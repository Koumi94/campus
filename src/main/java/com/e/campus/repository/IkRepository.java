package com.e.campus.repository;

import com.e.campus.model.IK;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IkRepository extends JpaRepository<IK, Long > {



}
