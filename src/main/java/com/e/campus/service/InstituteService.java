package com.e.campus.service;


import com.e.campus.model.Institute;


import java.util.List;


public interface InstituteService {
     List<Institute> getAllInstitute() ;

     Institute addInstitute(Institute institute) ;

     Institute findInstituteByID(Long id) ;

    Institute getInstituteById(Long id);

    Institute updateInstitute(Long id, Institute institute);

    String deleteInstitute(Long id);

}
