package com.student.management.sms.service;

import com.student.management.sms.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployee();

    Employee saveEmployee(Employee employee);

    Employee getEmployeeById(Long id);

    Employee updateEmployee(Employee employee);
}
