package com.e.campus.api;

import com.e.campus.model.Institute;
import com.e.campus.service.InstituteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/institutes")
public class InstituteController {

    private final InstituteService instituteService;

    public InstituteController(InstituteService instituteService) {
        this.instituteService = instituteService;
    }


    @GetMapping
    public List<Institute> getAllInstitute() {
        return instituteService.getAllInstitute();
    }

    @GetMapping("/institute/{id}")
    public Institute getInstituteById(@PathVariable Long id) {
        return instituteService.getInstituteById(id);
    }

    @PostMapping("/addinstituty")
    public Institute addInstitute(@RequestBody Institute institute ) {
        return  instituteService.addInstitute(institute);
    }

    @PutMapping("/institute/{id}")
    public Institute updateInstitute(@PathVariable Long id, @RequestBody Institute institute) {
        Institute updateInstitute =instituteService.updateInstitute(id, institute);
        return updateInstitute;
    }

    @DeleteMapping("/institute/{id}")
    public String deleteInstitute(@PathVariable Long id) {
        instituteService.deleteInstitute(id);
        return "messqge suprimer";
    }

}
