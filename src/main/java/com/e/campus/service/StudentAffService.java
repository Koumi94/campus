package com.e.campus.service;

import com.e.campus.model.StudentAffairs;

import java.util.List;
import java.util.Optional;

public interface StudentAffService {
    List<StudentAffairs> getAllStudentAffairs();

    Optional<StudentAffairs> getStudentAffairsById(Long id);

    StudentAffairs addStudentAffairs(StudentAffairs studentAffairs);

    StudentAffairs updateStudentAffairs(Long id, StudentAffairs studentAffairs);

    void deleteStudentAffairs(Long id);
}
