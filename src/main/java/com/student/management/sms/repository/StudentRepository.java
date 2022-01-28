package com.student.management.sms.repository;

import com.student.management.sms.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
//    List<Student> findAllStudentList();
}
