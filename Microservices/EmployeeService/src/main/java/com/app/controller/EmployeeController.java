package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.req.EmployeeRequest;
import com.app.respponse.EmployeeResponse;
import com.app.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	
	@Value("${server.port}")
	private String port;
	
	@Autowired
	EmployeeService empService;
	
	/*
	 * webflux
	 * @PostMapping("/saveEmployee") public EmployeeResponse
	 * createEmployee(@RequestBody EmployeeRequest er) { return
	 * empService.createEmployee(er); }
	 */
	
	@PostMapping("/saveEmployee")
	public EmployeeResponse createEmployee(@RequestBody EmployeeRequest er) {
		return empService.createEmployee(er);
	}
	
	@GetMapping("/getEmployee/{id}")
	public EmployeeResponse getEmployee(@PathVariable Long id) {
		System.out.println("Calling from the port is :: "+port);
		return empService.getEmployeeById(id);
	}

}
