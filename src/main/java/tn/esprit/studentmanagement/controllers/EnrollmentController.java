package tn.esprit.studentmanagement.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.studentmanagement.entities.Enrollment;
import tn.esprit.studentmanagement.services.IEnrollment;

import java.util.List;

@RestController
@RequestMapping("/Enrollment")
@CrossOrigin(origins = "http://localhost:4200")
public class EnrollmentController {
    @Autowired
    private IEnrollment enrollmentService;
    @GetMapping("/getAllEnrollment")
    public List<Enrollment> getAllEnrollment() { return enrollmentService.getAllEnrollments(); }

    @GetMapping("/getEnrollment/{id}")
    public Enrollment getEnrollment(@PathVariable Long id) { return enrollmentService.getEnrollmentById(id); }

    @PostMapping("/createEnrollment")
    public Enrollment createEnrollment(@RequestBody Enrollment enrollment) { return enrollmentService.saveEnrollment(enrollment); }

    @PutMapping("/updateEnrollment")
    public Enrollment updateEnrollment(@RequestBody Enrollment enrollment) {
        return enrollmentService.saveEnrollment(enrollment);
    }

    @DeleteMapping("/deleteEnrollment/{id}")
    public void deleteEnrollment(@PathVariable Long id) {
        enrollmentService.deleteEnrollment(id); }
}
