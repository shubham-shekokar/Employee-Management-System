package com.Emp_Man_Syst.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Emp_Man_Syst.Entity.Employee;
import com.Emp_Man_Syst.Service.EmpService;

@RestController
public class EmpController {
	@Autowired
	EmpService es;
	
	@PostMapping("/add")
	public Employee createEmp(@RequestBody Employee emp) {
		return es.createEmp(emp);
	}
	
	@GetMapping("/getAllEmp")
	public List<Employee> getAllEmp(){
		return es.getAllEmp();
	}
	
	@GetMapping("/getEmpById/{id}")
	public Employee getEmpById(@PathVariable int id) {
		return es.getEmpById(id);
	}
	
	@PutMapping("/{id}")
	public Employee updateEmp(@RequestBody Employee emp, @PathVariable int id) {
		return es.updateEmp(emp, id);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmp(@PathVariable int id) {
		es.deleteEmp(id);
		return new ResponseEntity<String>("Employee deleted succesfully..", HttpStatus.OK);
	}
	
	@GetMapping("/getEmpByDesg/{desg}")
	public List<Employee> getEmpByDesg(@PathVariable String desg){
		return es.getEmpByDesg(desg);
	}
	
	@GetMapping("/getEmpByAge/{age}")
	public List<Employee> getEmpByAge(@PathVariable int age){
		return es.getEmpByAge(age);
	}

}
