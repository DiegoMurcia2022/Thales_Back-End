package com.developer.thales.controllers;

import com.developer.thales.models.Employee;
import com.developer.thales.services.EmployeeService;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(@Autowired EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee")
    public ResponseEntity<?> getEmployeeById(@RequestParam(name = "id") int id) {
        try {
            return new ResponseEntity<>(employeeService.getEmployee(id), HttpStatus.OK);
        } catch (IOException | ParseException e) {
            return new ResponseEntity<>(HttpStatus.TOO_MANY_REQUESTS);
        }
    }

    @GetMapping("/employees")
    public ResponseEntity<?> getEmployees() {
        try {
            return new ResponseEntity<>(employeeService.getEmployees(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.TOO_MANY_REQUESTS);
        }
    }
}
