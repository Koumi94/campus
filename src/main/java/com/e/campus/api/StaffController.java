package com.e.campus.api;

import com.e.campus.model.Staff;

import com.e.campus.service.IkService;
import com.e.campus.service.StaffService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/staff")
public class StaffController {

    private final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping
    public List<Staff> getAllStaff() {
        return staffService.getAllStaff();
    }

    @GetMapping("/staff/{id}")
    public Optional<Staff> getStaffById(@PathVariable Long id) {
        return staffService.getStaffById(id);
    }

    @PostMapping("/addstaff")
    public Staff addOgrenci(@RequestBody Staff staff ) {
        return  staffService.addStaff(staff);
    }

    @PutMapping("/staff/{id}")
    public Staff updateStaff(@PathVariable Long id, @RequestBody Staff staff) {
        return staffService.updateStaff(id, staff);
    }

    @DeleteMapping("/staff/{id}")
    public void deleteStaff(@PathVariable Long id) {
        staffService.deleteStaff(id);
    }
}
