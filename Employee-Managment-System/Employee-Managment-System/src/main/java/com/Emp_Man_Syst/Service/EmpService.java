package com.Emp_Man_Syst.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Emp_Man_Syst.Entity.Employee;
import com.Emp_Man_Syst.Repository.EmpRepo;

@Service
public class EmpService {
	@Autowired
	EmpRepo ep;
	
	public Employee createEmp(Employee emp) {
		return ep.save(emp);
	}
	
	public List<Employee> getAllEmp(){
		return ep.findAll();
	}
	
	public Employee getEmpById(int id) {
		return ep.findById(id).orElse(null);
	}
	
	public Employee updateEmp(Employee emp, int id) {
		Employee oldEmp = ep.findById(id).orElse(null);
		/* oldEmp.setId(emp.getId()); */
		oldEmp.setName(emp.getName());
		oldEmp.setDesg(emp.getDesg());
		oldEmp.setSal(emp.getSal());
		oldEmp.setEmail(emp.getEmail());
		oldEmp.setAge(emp.getAge());
		ep.save(oldEmp);
		return oldEmp;
	}
	
	public void deleteEmp(int id) {
		ep.deleteById(id);
	}
	
	public List<Employee> getEmpByDesg(String desg){
		return ep.findByDesg(desg);
	}
	
	public List<Employee> getEmpByAge(int age){
		return ep.findByAgeGreaterThan(age);
	}

}
