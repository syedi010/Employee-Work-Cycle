package com.example.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Entity.BGV;
import com.example.Entity.Employee;
import com.example.Repository.EmployeeRepository;

@Controller
public class BasicController {

    private final EmployeeRepository employeeRepository1;

    public BasicController(EmployeeRepository employeeRepository1)
    {
        this.employeeRepository1 = employeeRepository1;
    }

    @GetMapping("/form")
    public String EmployeeForm(Model model) {

        Employee employee = new Employee();
        employee.setBgvStatus(new BGV());
        model.addAttribute("employee", employee);
        return "Form"; // yaha 'form.html' ka naam hai
    }

    @PostMapping("/saveEmployee")
    public String postMethodName(@ModelAttribute Employee employee, Model model) {

        if(employee==null)
        return "NoEmployeeAdded";
        else{
        employeeRepository1.save(employee);
        model.addAttribute("message", "Employee added successfully");
        return "employeeForm";
        }

    }

}
