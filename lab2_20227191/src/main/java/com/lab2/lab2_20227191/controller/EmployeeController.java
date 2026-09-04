package com.lab2.lab2_20227191.controller;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.lab2.lab2_20227191.model.Employee;
import com.lab2.lab2_20227191.repository.EmployeeRepository;

@Controller
@RequestMapping("/employees")

public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public String listar(Model model) {
        List<Employee> empleados = employeeRepository.findAll();
        model.addAttribute("empleados", empleados);
        return "listado";
    }
    @GetMapping("/ver")
    public String ver(@RequestParam Integer id, Model model) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado: " + id));
        model.addAttribute("employee", employee);
        return "detalle";
    }

}
