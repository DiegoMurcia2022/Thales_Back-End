package com.developer.thales.services.impl;

import com.developer.thales.logic.BusinessModel;
import com.developer.thales.models.Employee;
import com.developer.thales.services.EmployeeService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    public EmployeeServiceImpl() {
    }

    @Override
    public Employee getEmployee(int id) throws IOException, ParseException {
        URL url = new URL("http://dummy.restapiexample.com/api/v1/employee/"+String.valueOf(id));

        String inline = "";
        Scanner scanner = new Scanner(url.openStream());

        while (scanner.hasNext()) {
            inline += scanner.nextLine();
        }

        scanner.close();

        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(inline);
        JSONObject data = (JSONObject) object.get("data");

        if (data!=null) {
            String name = data.get("employee_name").toString();
            long salary = Long.parseLong(data.get("employee_salary").toString());
            int age = Integer.parseInt(data.get("employee_salary").toString());
            String profileImage = data.get("profile_image").toString();

            return new Employee(id, name, salary, age, profileImage, BusinessModel.getAnnualSalary(salary));
        }

        return null;
    }

    @Override
    public List<Employee> getEmployees() throws IOException, ParseException {
        URL url = new URL("http://dummy.restapiexample.com/api/v1/employees");

        String inline = "";
        Scanner scanner = new Scanner(url.openStream());

        while (scanner.hasNext()) {
            inline += scanner.nextLine();
        }

        scanner.close();

        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(inline);
        JSONArray data = (JSONArray) object.get("data");

        int id, age;
        long salary, annualSalary;
        String name, profileImage;
        String jsonEmployee;
        JSONObject employeeInformation;

        List<Employee> employees = new ArrayList<>();

        for (int i=0; i<data.size(); i++) {
            jsonEmployee = data.get(i).toString();
            employeeInformation = (JSONObject) parser.parse(jsonEmployee);

            id = Integer.parseInt(employeeInformation.get("id").toString());
            name = employeeInformation.get("employee_name").toString();
            salary = Long.parseLong(employeeInformation.get("employee_salary").toString());
            age = Integer.parseInt(employeeInformation.get("employee_age").toString());
            profileImage = employeeInformation.get("profile_image").toString();
            annualSalary = BusinessModel.getAnnualSalary(salary);

            employees.add(new Employee(id, name, salary, age, profileImage, annualSalary));
        }

        return employees;
    }
}
