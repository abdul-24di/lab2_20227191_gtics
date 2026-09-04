package com.lab2.lab2_20227191.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lab2.lab2_20227191.model.Employee;

@Repository

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
    List<Employee> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailContainingIgnoreCase(String firstName, String lastName, String email);

    List<Employee> findByJobIDIgnoreCase(String jobID);

    List<Employee> findBySalaryGreaterThanEqual(Double salarioMinimo);

}


