package com.cybersoft.jpabai3.controller;


import com.cybersoft.jpabai3.dto.request.CreateStudentRequest;
import com.cybersoft.jpabai3.entity.CourseEntity;
import com.cybersoft.jpabai3.repository.CourseRepository;
import com.cybersoft.jpabai3.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    @Autowired
    private StudentService studentService;
    private final CourseRepository courseRepository;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(studentService.findAll());
    }

    @PostMapping
    public ResponseEntity<?> addStudent(@Valid @RequestBody CreateStudentRequest createStudentRequest) {
        return ResponseEntity.ok(studentService.addStudent(createStudentRequest));
    }

    @PostMapping("/courses")
    public ResponseEntity<CourseEntity> createCourse(@RequestBody CourseEntity course) {
        CourseEntity saved = courseRepository.save(course);
        System.out.println(course.getTitle());
        return ResponseEntity.ok(saved);
    }

    @PostMapping("/{id}/courses/{courseId}")
    public ResponseEntity<?> registerCourse(
            @PathVariable Long id,
            @PathVariable Long courseId) {

        studentService.registerCourse(id, courseId);
        return ResponseEntity.ok("Registered successfully");
    }

    @GetMapping("/{id}/courses")
    public ResponseEntity<?> getCourses(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getCourse(id));
    }


}
