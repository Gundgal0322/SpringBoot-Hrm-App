package com.csi.dao;

import com.csi.model.Employee;

import java.util.List;

public interface EmployeeDao {

    public  void signUp(Employee employee);

    public  boolean signIn(String empEmailId, String empPassword);

    public Employee getDataById(int empId);

    public List<Employee> getDataByName(String empName);

    public List<Employee> getDataByEmailId(String empEmailId);

    public List<Employee> getDataBySalary(Double empSalary);

    public List<Employee> getALlData();

    public void updateData(int empId, Employee employee);

    public void deleteDataById(int empId);

    public void deleteAllData( );


}
