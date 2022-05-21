package com.developer.thales;

import com.developer.thales.models.Employee;
import com.developer.thales.services.EmployeeService;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class ThalesApplicationTests {
	@Autowired
	EmployeeService employeeService;

	@Test
	public void testAnnualSalaryCalculation() throws IOException, ParseException {
		long result = 3849600;
		Employee employee = employeeService.getEmployee(1);
		Assertions.assertEquals(result, employee.getAnnualSalary());
	}
}
