package com.e.campus.api;


import com.e.campus.model.StudentAffairs;
import com.e.campus.service.StudentAffService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students-affairs")
public class StudentAffairsController {
    private final StudentAffService studentAffService;

    public StudentAffairsController(StudentAffService studentAffService) {
        this.studentAffService = studentAffService;
    }

    @GetMapping
    public List<StudentAffairs> getAllStudentAffairs() {
        return studentAffService.getAllStudentAffairs();
    }

    @GetMapping("/students-affairs/{id}")
    public Optional<StudentAffairs> getStudentAffairsById(@PathVariable Long id) {
        return studentAffService.getStudentAffairsById(id);
    }

    @PostMapping("/addstudents-affairs")
    public StudentAffairs addStudentAffairs(@RequestBody StudentAffairs studentAffairs ) {
        return  studentAffService.addStudentAffairs(studentAffairs);
    }

    @PutMapping("/students-affairs/{id}")
    public StudentAffairs updateStaff(@PathVariable Long id, @RequestBody StudentAffairs studentAffairs) {
        return studentAffService.updateStudentAffairs(id, studentAffairs);
    }

    @DeleteMapping("/students-affairs/{id}")
    public void deleteStudentAffairs(@PathVariable Long id) {
        studentAffService.deleteStudentAffairs(id);
    }
}
