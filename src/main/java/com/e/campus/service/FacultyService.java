package com.e.campus.service;

import com.e.campus.model.Faculty;

import java.util.List;
import java.util.Optional;

public interface FacultyService {
    List<Faculty> getAllFaculties();
    Optional<Faculty> getFacultyById(Long id);
    Faculty addFaculty(Faculty faculty);
    Faculty updateFaculty(Long id, Faculty faculty);
    Faculty deleteFaculty(Long id);
}
