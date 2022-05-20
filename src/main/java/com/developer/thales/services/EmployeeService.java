package com.developer.thales.services;

import com.developer.thales.models.Employee;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

public interface EmployeeService {
    Employee getEmployee(int id) throws IOException, ParseException;
    List<Employee> getEmployees() throws IOException, ParseException;
}
