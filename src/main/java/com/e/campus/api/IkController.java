package com.e.campus.api;


import com.e.campus.model.Contract;
import com.e.campus.model.IK;
import com.e.campus.model.Staff;
import com.e.campus.service.ContractService;
import com.e.campus.service.IkService;
import com.e.campus.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/iks")
public class IkController {

    @Autowired
    private StaffService staffService;

    @Autowired
    private ContractService contractService;

    @GetMapping("/staffs")
    public ResponseEntity<List<Staff>> getAllStaff() {
        List<Staff> staffs = staffService.getAllStaff();
        return new ResponseEntity<>(staffs, HttpStatus.OK);
    }

    @GetMapping("/staffs/{staff_id}")
    public ResponseEntity<Staff> getStaffById(@PathVariable Long staff_id) {
        Optional<Staff> staff = staffService.getStaffById(staff_id);
        if(!staff.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(staff.get(), HttpStatus.OK);
    }

    @PostMapping("/staffs")
    public ResponseEntity<Staff> addStaff(@RequestBody Staff staff) {
        staffService.addStaff(staff);
        return new ResponseEntity<>(staff, HttpStatus.CREATED);
    }

    @PutMapping("/staffs/{staff_id}")
    public ResponseEntity<Staff> updateStaff(@PathVariable Long staff_id, @RequestBody Staff staff) {
        staffService.updateStaff(staff_id, staff);
        return new ResponseEntity<>(staff, HttpStatus.OK);
    }

    @DeleteMapping("/staffs/{staff_id}")
    public ResponseEntity<Void> deleteStaff(@PathVariable Long staff_id) {
        staffService.deleteStaff(staff_id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/contracts")
    public ResponseEntity<Contract> createContract(@RequestBody Contract contract) {
        contractService.createContract(contract);
        return new ResponseEntity<>(contract, HttpStatus.CREATED);
    }

    @DeleteMapping("/contracts/{contract_Id}")
    public ResponseEntity<Void> deleteContract(@PathVariable Long contractId) {
        contractService.deleteContract(contractId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
