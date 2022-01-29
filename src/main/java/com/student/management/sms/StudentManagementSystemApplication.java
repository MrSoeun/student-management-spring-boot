package com.student.management.sms;

import com.student.management.sms.entity.ClassRoom;
import com.student.management.sms.entity.Student;
import com.student.management.sms.repository.ClassRoomReposistory;
import com.student.management.sms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;

//	@Override
//	public void run(String... args) throws Exception {
////		Student student1 = new Student("Soeun", "Lay", "laysoeun@gmail.com");
////		studentRepository.save(student1);
////		Student student2 = new Student("Soeun2", "Lay2", "soeunlay2@gmail.com");
////		studentRepository.save(student2);
//
//	}

	@Autowired
	private ClassRoomReposistory classRoomReposistory;

	@Override
	public void run(String... args) throws Exception {
//		ClassRoom classRoom1 = new ClassRoom("Class room 001","This class is only 50 student");
//		classRoomReposistory.save(classRoom1);
	}
}
