package com.api.employee.EmployeeDetails;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class EmployeeService {
    private static List<Employee> list = new ArrayList<>();
    static {
        list.add(new Employee(1,26,"bala","bala@gmail.com","rjy"));
        list.add(new Employee(2,27,"bhargav","bhargav@gmail.com","hyd"));
    }

    public  List<Employee> getAllEmployees()
    {
        return list;
    }

    public static Employee getEmployeeById(int id)
    {
      Employee employee = null;
        employee =   list.stream().filter(e->e.getId()==id).findFirst().get();
        return employee;
    }

    public Employee addEmployee(Employee employee)
    {
        list.add(employee);
        return employee;
    }



    public void updateEmpoloyee(Employee employee, int id)
    {
       list =   list.stream().map(b->{
            if(b.getId()==id)
            {
                b.setName(employee.getName());
                b.setEmail(employee.getEmail());
                b.setAge(employee.getAge());
                b.setAddress(employee.getAddress());
            }
            return b;

        }).collect(Collectors.toList());

    }
}
