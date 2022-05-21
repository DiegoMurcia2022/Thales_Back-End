package com.developer.thales.controllers;

import com.developer.thales.models.Employee;
import com.developer.thales.services.EmployeeService;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(@Autowired EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee")
    public ResponseEntity<Employee> getEmployeeById(@RequestParam(name = "id") int id) {
        try {
            return ResponseEntity.ok().body(employeeService.getEmployee(id));
        } catch (IOException | ParseException e) {
            return ResponseEntity.ok().build();
        }
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployees() {
        try {
            return new ResponseEntity<>(employeeService.getEmployees(), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.ok().body(new ArrayList<>());
        }
    }
}
