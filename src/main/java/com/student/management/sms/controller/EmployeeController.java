package com.student.management.sms.controller;

import com.student.management.sms.entity.Employee;
import com.student.management.sms.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public String listEmployee(Model model)
    {
        model.addAttribute("employees", employeeService.getEmployee());
        return "employee/employee";
    }

    @GetMapping("/employees/view")
    public String createEmployeeForm(Model model)
    {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employee/create_employee";
    }

    @PostMapping("/employees")
    public String saveEmployee(@ModelAttribute("employee") Employee employee)
    {
        employeeService.saveEmployee(employee);

        return "redirect:/employees";
    }

    @GetMapping("employees/edit/{id}")
    public String getEmployeeById(@PathVariable Long id, Model model)
    {
        model.addAttribute("employee", employeeService.getEmployeeById(id));
        return "employee/edit_employee";
    }

    @PostMapping("/employees/{id}")
    public String updateEmployee(@PathVariable Long id, @ModelAttribute("employee") Employee employee, Model model)
    {
        Employee existingEmployee = employeeService.getEmployeeById(id);

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setGender(employee.getGender());
        existingEmployee.setBirthDate(employee.getBirthDate());
        existingEmployee.setPlaceOfBirth(employee.getPlaceOfBirth());
        existingEmployee.setCurrentAddress(employee.getCurrentAddress());
        existingEmployee.setPhone(employee.getPhone());
        existingEmployee.setEmail(employee.getEmail());

        employeeService.updateEmployee(existingEmployee);

        return "redirect:/employees";
    }

}
