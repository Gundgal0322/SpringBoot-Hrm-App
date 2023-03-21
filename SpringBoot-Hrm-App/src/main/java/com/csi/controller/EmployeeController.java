package com.csi.controller;


import com.csi.model.Employee;
import com.csi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeService employeeServiceImpl;

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody Employee employee){
        employeeServiceImpl.signUp(employee);
        return ResponseEntity.ok("Sign Up Successfully");
    }

    @GetMapping("/signin/{empEmailId}/{empPassword}")
    public ResponseEntity<String> signIn(@PathVariable String empEmailId, @PathVariable String empPassword ){
        employeeServiceImpl.signIn(empEmailId, empPassword);
        return ResponseEntity.ok("Sign In Successfully");
    }

    @GetMapping("/getdatabyid/{empId}")
    public ResponseEntity<Employee> getDataById(@PathVariable int empId){
        return ResponseEntity.ok(employeeServiceImpl.getDataById(empId));
    }

    @GetMapping("/getdatabyname/{empName}"8
    public ResponseEntity<List<Employee>> getDataByName(@PathVariable String empName){
        return ResponseEntity.ok(employeeServiceImpl.getDataByName(empName));
    }

    @GetMapping("/getdatabysalary{empSalary}")
    public ResponseEntity<List<Employee>> getDataBySalary(@PathVariable double empSalary){
        return ResponseEntity.ok(employeeServiceImpl.getDataBySalary(empSalary));
    }

    @GetMapping("/getalldata")
    public ResponseEntity<List<Employee>> getAllData(){
        return ResponseEntity.ok(employeeServiceImpl.getALlData());
    }

    @GetMapping("/getdatabyanyinput/{input}")
    public ResponseEntity<List<Employee>> getDataByAnyInput(@PathVariable String input){
        return ResponseEntity.ok(employeeServiceImpl.getALlData().stream().filter(emp->emp.getEmpName().equals(input)
        || emp.getEmpSalary() == Double.valueOf(input)
        || emp.getEmpEmailId().equals(input) || emp.getEmpAddress().equals(input)
        ).collect(Collectors.toList()));
    }

    @PutMapping("/updatedata/{empId}")
    public ResponseEntity<String> updateData(@PathVariable int empId, @RequestBody Employee employee){
        employeeServiceImpl.updateData(empId, employee);
        return ResponseEntity.ok("Record Updated Successfully");
    }

    @DeleteMapping("/deletedatabyid/{empId}")
    public ResponseEntity<String> deleteDataById(@PathVariable int empId){
        employeeServiceImpl.deleteDataById(empId);
        return ResponseEntity.ok("Record Delete Successfully");
    }

    @DeleteMapping("/deletealldata")
    public  ResponseEntity<String> deleteAllData(  ){
        employeeServiceImpl.deleteAllData();
        return ResponseEntity.ok("All Record Delete Successfully");

    }
}
