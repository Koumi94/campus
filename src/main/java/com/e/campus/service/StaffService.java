package com.e.campus.service;
import com.e.campus.model.Staff;
import com.e.campus.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StaffService {

        @Autowired
        private StaffRepository staffRepository;

        public List<Staff> getAllStaff() {
            return staffRepository.findAll();
        }

        public Optional<Staff> getStaffById(Long staff_Id) {
            return staffRepository.findById(staff_Id);
        }

        public Staff addStaff(Staff staff) {
            staffRepository.save(staff);
            return staff;
        }

        public Staff updateStaff(Long staff_Id, Staff staff) {
            staff.setId(staff_Id);
            staffRepository.save(staff);
            return staff;
        }

        public void deleteStaff(Long staff_Id) {
            staffRepository.deleteById(staff_Id);
        }


}
