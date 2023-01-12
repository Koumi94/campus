package com.e.campus.service;

import com.e.campus.model.Bolum;
import com.e.campus.model.Faculty;
import com.e.campus.model.IK;

import java.util.List;
import java.util.Optional;


public interface IkService {
    List<IK> getAllIk();
    Optional<IK> getIkById(Long id);
    IK addIk(IK ik);
    IK updateIk(Long id, IK ik);
    IK deleteIk(Long id);
}
