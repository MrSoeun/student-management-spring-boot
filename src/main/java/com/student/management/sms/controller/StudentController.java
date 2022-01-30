package com.student.management.sms.controller;

import com.student.management.sms.entity.Student;
import com.student.management.sms.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //handler method to handle list student and return mode and view
    @GetMapping("/students")
    public String listStudents(Model model){
        model.addAttribute("students", studentService.getAllStudent());

        //return view
        return "students";
    }

    @GetMapping("/students/view")
    public String createStudentForm(Model model)
    {
        //create student object to hold student from data
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("students") Student student){
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model){
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {
        //get student from data by id
        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        //save updated student object
        studentService.updateStudent(existingStudent);
        return "redirect:/students";
    }
    //handler method to handle delete student record
    @GetMapping("/student/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteStudentById(id);

        return "redirect:/students";
    }
}
