package com.cybersoft.jpabai3.repository;


import com.cybersoft.jpabai3.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface StudentRepository extends JpaRepository<StudentEntity,Long> {
}
