package com.api.employee.EmployeeDetails;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;



    @GetMapping("/employees")
    public List<Employee> getEmployees(){

        return this.employeeService.getAllEmployees();
    }
    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable("id") int id){
        return EmployeeService.getEmployeeById(id);
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
     Employee employee0 =   this.employeeService.addEmployee(employee);
        return employee0;
    }
    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@RequestBody Employee employee, @PathVariable("id") int id) {
        this.employeeService.updateEmpoloyee(employee, id);
        return employee;
    }
}
