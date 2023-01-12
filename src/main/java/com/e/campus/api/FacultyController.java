package com.e.campus.api;

import com.e.campus.model.Bolum;
import com.e.campus.model.Course;
import com.e.campus.model.Faculty;
import com.e.campus.model.Ogrenci;
import com.e.campus.service.BolumService;
import com.e.campus.service.CourseService;
import com.e.campus.service.FacultyService;

import com.e.campus.service.OgrenciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/faculties")
public class FacultyController {
    @Autowired
    private FacultyService facultyService;
    @Autowired
    private BolumService bolumService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private OgrenciService ogrenciService;

    @GetMapping("/faculty")
    public ResponseEntity<List<Faculty>> getAllFaculties() {
        List<Faculty> faculties = facultyService.getAllFaculties();
        return new ResponseEntity<>(faculties, HttpStatus.OK);
    }

    @GetMapping("/faculty/{faculty_Id}")
    public ResponseEntity<Faculty> getFacultyById(@PathVariable Long facultyId) {
        Optional<Faculty> faculty = facultyService.getFacultyById(facultyId);
        if (!faculty.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(faculty.get(), HttpStatus.OK);
    }

    @PostMapping("/faculty")
    public ResponseEntity<Faculty> addFaculty(@RequestBody Faculty faculty) {
        facultyService.addFaculty(faculty);
        return new ResponseEntity<>(faculty, HttpStatus.CREATED);
    }

    @PutMapping("/faculty/{faculty_Id}")
    public ResponseEntity<Faculty> updateFaculty(@PathVariable Long facultyId, @RequestBody Faculty faculty) {
        facultyService.updateFaculty(facultyId, faculty);
        return new ResponseEntity<>(faculty, HttpStatus.OK);
    }

    @DeleteMapping("/faculty/{faculty_Id}")
    public ResponseEntity<Void> deleteFaculty(@PathVariable Long facultyId) {
        facultyService.deleteFaculty(facultyId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/faculty/{faculty_Id}/bolum")
    public ResponseEntity<Bolum> addBolumToFaculty(@PathVariable Long facultyId, @RequestBody Bolum bolum) {
        Optional<Faculty> faculty = facultyService.getFacultyById(facultyId);
        if (!faculty.isPresent()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        bolum.setFaculty(faculty.get());
        bolumService.addBolum(bolum);
        return new ResponseEntity<>(bolum, HttpStatus.CREATED);
    }

    @DeleteMapping("/faculty/{faculty_Id}/bolum/{bolum_id}")
    public ResponseEntity<Void> removeBolumFromFaculty(@PathVariable Long facultyId, @PathVariable Long bolum_id) {
        Optional<Faculty> faculty = facultyService.getFacultyById(facultyId);
        if (!faculty.isPresent()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        bolumService.deleteBolum(bolum_id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PostMapping("/faculty/{faculty_Id}/course")
    public ResponseEntity<Course> addCourseToFaculty(@PathVariable Long facultyId, @RequestBody Course course) {
        Optional<Faculty> faculty = facultyService.getFacultyById(facultyId);
        if(!faculty.isPresent()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        course.setFaculty(faculty.get());
        courseService.addCourse(course);
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }

    @DeleteMapping("/faculty/{faculty_Id}/course/{course_Id}")
    public ResponseEntity<Void> removeCourseFromFaculty(@PathVariable Long facultyId, @PathVariable Long courseId) {
        Optional<Faculty> faculty = facultyService.getFacultyById(facultyId);
        if(!faculty.isPresent()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        courseService.deleteCourse(courseId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/faculties/{facultyId}/course/{course_Id}/ogrenci/{ogrenci_id}")
    public ResponseEntity<String> assignCourseToOgrenci(@PathVariable Long facultyId, @PathVariable Long courseId, @PathVariable Long studentId) {
        Optional<Faculty> faculty = facultyService.getFacultyById(facultyId);
        Optional<Course> course = courseService.getCourseById(courseId);
        Optional<Ogrenci> student = ogrenciService.getOgrenciById(studentId);
        if(!faculty.isPresent() || !course.isPresent() || !student.isPresent()){
            return new ResponseEntity<>("Fakülte, kurs veya öğrenci bulunamadı", HttpStatus.BAD_REQUEST);
        }
        student.get().addCourse(course.get());
        ogrenciService.updateOgrenci(student.get().getId(), student.get());
        return new ResponseEntity<>("Ders başarıyla öğrenciye atandı", HttpStatus.OK);
    }

}

