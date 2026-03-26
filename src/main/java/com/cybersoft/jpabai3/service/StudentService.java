package com.cybersoft.jpabai3.service;


import com.cybersoft.jpabai3.dto.request.CreateStudentRequest;
import com.cybersoft.jpabai3.dto.response.StudentResponse;
import com.cybersoft.jpabai3.entity.CourseEntity;
import com.cybersoft.jpabai3.entity.StudentEntity;
import com.cybersoft.jpabai3.repository.CourseRepository;
import com.cybersoft.jpabai3.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    private final CourseRepository courseRepository;

    public List<StudentResponse> findAll(){
        return studentRepository.findAll().stream().map(studentEntity -> {
            StudentResponse studentResponse = new StudentResponse();
            studentResponse.setId(studentEntity.getId());
            studentResponse.setName(studentEntity.getName());
            studentResponse.setEmail(studentEntity.getEmail());
            return studentResponse;
        }).toList();
    }

    public StudentResponse addStudent(CreateStudentRequest createStudentRequest){
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName(createStudentRequest.getName());
        studentEntity.setEmail(createStudentRequest.getEmail());
        studentEntity.setAge(createStudentRequest.getAge());
        studentRepository.save(studentEntity);
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setId(studentEntity.getId());
        studentResponse.setName(studentEntity.getName());
        studentResponse.setEmail(studentEntity.getEmail());
        studentResponse.setAge(studentEntity.getAge());
        return studentResponse;
    }

    public void registerCourse(Long studentId, Long courseId){
        StudentEntity studentEntity = studentRepository.findById(studentId).orElse(null);
        CourseEntity courseEntity = courseRepository.findById(courseId).orElse(null);
        studentEntity.getCourses().add(courseEntity);
        studentRepository.save(studentEntity);
    }

    public List<CourseEntity> getCourse(Long studentId){
        StudentEntity studentEntity = studentRepository.findById(studentId).orElse(null);
        return studentEntity.getCourses();
    }

}
