package com.e.campus.api;
import com.e.campus.model.Course;
import com.e.campus.model.Ogrenci;
import com.e.campus.service.CourseService;
import com.e.campus.service.OgrenciService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ogrenciler")
public class OgrenciController {

    private final OgrenciService ogrenciService;
    private final CourseService courseService;

    public OgrenciController(OgrenciService ogrenciService, CourseService courseService) {
        this.ogrenciService = ogrenciService;
        this.courseService = courseService;
    }


    @GetMapping
    public ResponseEntity<List<Ogrenci>> getAllOgrenci() {
        List<Ogrenci> ogrenciler = ogrenciService.getAllOgrenci();
        return new ResponseEntity<>(ogrenciler, HttpStatus.OK);
    }

    @GetMapping("/ogrenci/{ogrenci_id}")
    public ResponseEntity<Ogrenci> getOgrenciById(@PathVariable Long id) {
        Optional<Ogrenci> ogrenci = ogrenciService.getOgrenciById(id);
        if(!ogrenci.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ogrenci.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Ogrenci> addOgrenci(@RequestBody Ogrenci ogrenci ) {
          ogrenciService.addOgrenci(ogrenci);
        return new ResponseEntity<>(ogrenci, HttpStatus.CREATED);
    }

    @PutMapping("/ogrenci/{ogrenci_id}")
    public ResponseEntity<Ogrenci> updateOgrenci(@PathVariable Long id, @RequestBody Ogrenci ogrenci) {
        ogrenciService.updateOgrenci(id, ogrenci);
        return new ResponseEntity<>(ogrenci, HttpStatus.OK);
    }

    @DeleteMapping("/ogrenci/{ogrenci_id}")
    public ResponseEntity<Void> deleteOgrenci(@PathVariable Long id) {
        ogrenciService.deleteOgrenci(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/ogrenci/{ogrenci_id}/course/{course_Id}")
    public ResponseEntity<String> addCourse(@PathVariable Long ogrenci_id, @PathVariable Long course_Id) {
        Optional<Ogrenci> ogrenci = ogrenciService.getOgrenciById(ogrenci_id);
        Optional<Course> course = courseService.getCourseById(course_Id);
        if(!ogrenci.isPresent() || !course.isPresent()){
            return new ResponseEntity<>("Öğrenci veya kurs mevcut değil", HttpStatus.BAD_REQUEST);
        }
        ogrenci.get().addCourse(course.get());
        ogrenciService.updateOgrenci(ogrenci.get().getId(),ogrenci.get());
        return new ResponseEntity<>("Ders, öğrenciye başarıyla eklendi", HttpStatus.OK);
    }



}