package com.csi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee")
public class Employee {
    
    @Id
    @GeneratedValue
    
    @Column(name = "emp_id")
    private int empId;

    @Column(name = "emp_name")
    private String empName;

    @Column(name = "emp_addrerss")
    private String empAddress;

    @Column(name = "emp_contact_number")
    private Long empContactNumber;

    @Column(name = "emp_salary")
    private Double empSalary;

    @Column(name = "emp_dob")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date empDOB;

    @Column(name = "emp_email_id")
    private String empEmailId;

    @Column(name = "emp_password")
    private String empPassword;
}
