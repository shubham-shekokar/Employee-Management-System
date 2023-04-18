package com.Emp_Man_Syst.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Emp_Man_Syst.Entity.Employee;

@Repository
public interface EmpRepo extends JpaRepository<Employee, Integer>{
	public List<Employee> findByDesg(String desg);
	public List<Employee> findByAgeGreaterThan(int age);

}
