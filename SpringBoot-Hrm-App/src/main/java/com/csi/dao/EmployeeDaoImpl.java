package com.csi.dao;

import com.csi.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeDaoImpl implements EmployeeDao {

   private static SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();

    @Override
    public void signUp(Employee employee) {

        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();

        session.save(employee);

        transaction.commit();

    }

    @Override
    public boolean signIn(String empEmailId, String empPassword) {
        boolean flag = false;

        for (Employee employee: getALlData()){
            if(employee.getEmpEmailId().equals(empEmailId) && employee.getEmpPassword().equals(empPassword)){
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public Employee getDataById(int empId) {
        Session session = factory.openSession();

        return (Employee) session.get(Employee.class, empId);
    }

    @Override
    public List<Employee> getDataByName(String empName) {

        Session session = factory.openSession();

        return getALlData().stream().filter(emp->emp.getEmpName().equals(empName)).collect(Collectors.toList());
    }

    @Override
    public List<Employee> getDataByEmailId(String empEmailId) {
        return getALlData().stream().filter(emp->emp.getEmpEmailId().equals(empEmailId)).collect(Collectors.toList());
    }

    @Override
    public List<Employee> getDataBySalary(Double empSalary) {
        return getALlData().stream().filter(emp->emp.getEmpSalary().equals(empSalary)).collect(Collectors.toList());
    }

    @Override
    public List<Employee> getALlData() {
        Session session = factory.openSession();

        return session.createQuery("from Employee").list();
    }

    @Override
    public void updateData(int empId, Employee employee) {

        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();

        Employee employee1 = getDataById(empId);

        employee1.setEmpName(employee.getEmpName());
        employee1.setEmpAddress(employee.getEmpAddress());
        employee1.setEmpContactNumber(employee.getEmpContactNumber());
        employee1.setEmpSalary(employee.getEmpSalary());
        employee1.setEmpDOB(employee.getEmpDOB());
        employee1.setEmpEmailId(employee.getEmpEmailId());
        employee1.setEmpPassword(employee.getEmpPassword());

        session.update(employee1);
        transaction.commit();
    }

    @Override
    public void deleteDataById(int empId) {

        Session session = factory.openSession();

        Transaction transaction= session.beginTransaction();

        session.delete(getDataById(empId));
        transaction.commit();
    }

    @Override
    public void deleteAllData() {

        Session session = factory.openSession();

        for (Employee employee: getALlData()){
            Transaction transaction = session.beginTransaction();

            session.delete(employee);

            transaction.commit();
        }
    }
}
