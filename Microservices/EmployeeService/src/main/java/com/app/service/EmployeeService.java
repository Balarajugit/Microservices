package com.app.service;

import com.app.req.EmployeeRequest;
import com.app.respponse.EmployeeResponse;

public interface EmployeeService {
	
	public EmployeeResponse createEmployee(EmployeeRequest empReq);
	
	public EmployeeResponse getEmployeeById(Long id);

}
