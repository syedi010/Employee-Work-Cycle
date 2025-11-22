package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.Entity.BGV;
import com.example.Entity.Employee;
import com.example.Repository.EmployeeRepository;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BasicController {

    @Autowired
    EmployeeRepository employeeRepository1;

    @GetMapping("/form")
    public String EmployeeForm(Model model) {

        Employee employee = new Employee();
        employee.setBgvStatus(new BGV());
        model.addAttribute("employee", employee);
        return "Form"; // yaha 'form.html' ka naam hai
    }

    @PostMapping("/saveEmployee")
    public String postMethodName(@ModelAttribute Employee employee, Model model) {
        employeeRepository1.save(employee);
        model.addAttribute("message", "Employee added successfully");
        return "employeeForm";

    }

}
