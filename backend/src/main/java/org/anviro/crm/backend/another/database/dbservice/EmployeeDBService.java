package org.anviro.crm.backend.another.database.dbservice;

import org.anviro.crm.backend.another.Utils;
import org.anviro.crm.backend.another.database.entity.Department;
import org.anviro.crm.backend.another.database.entity.Employee;
import org.anviro.crm.backend.another.database.repository.DepartmentRepository;
import org.anviro.crm.backend.another.database.repository.EmployeeRepository;
import org.anviro.crm.common.beans.another.DepartmentBean;
import org.anviro.crm.common.beans.another.EmployeeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeDBService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;


    public List<EmployeeBean> getEmployees() {
        List<Employee> dbEmployees = employeeRepository.findAll();
        List<EmployeeBean> employees = new ArrayList<>();
        for (Employee emp: dbEmployees) {
            employees.add(Utils.createEmployeeBean(emp));
        }
        return employees;
    }


    public List<EmployeeBean> getEmployeesByDepartment(Long id) {
        List<Employee> dbEmployees = employeeRepository.findByDepartment(departmentRepository.findOne(id));
        List<EmployeeBean> employees = new ArrayList<>();
        for (Employee emp: dbEmployees) {
            employees.add(Utils.createEmployeeBean(emp));
        }
        return employees;
    }

    public List<EmployeeBean> getEmployeesByPosition(String position) {
        List<Employee> dbEmployees = employeeRepository.findByPosition(position);
        List<EmployeeBean> employees = new ArrayList<>();
        for (Employee emp: dbEmployees) {
            employees.add(Utils.createEmployeeBean(emp));
        }
        return employees;
    }

    public List<EmployeeBean> getEmployeesByName(String name) {
        List<Employee> dbEmployees = employeeRepository.findByName(name);
        List<EmployeeBean> employees = new ArrayList<>();
        for (Employee emp: dbEmployees) {
            employees.add(Utils.createEmployeeBean(emp));
        }
        return employees;
    }

    public List<EmployeeBean> getEmployeesByPhone(String phone) {
        List<Employee> dbEmployees = employeeRepository.findByPhone(phone);
        List<EmployeeBean> employees = new ArrayList<>();
        for (Employee emp: dbEmployees) {
            employees.add(Utils.createEmployeeBean(emp));
        }
        return employees;
    }

    public EmployeeBean getEmployee(Long employeeId) {
        Employee dbEmployee = employeeRepository.findOne(employeeId);
        return Utils.createEmployeeBean(dbEmployee);
    }

    @Transactional
    public void addEmployee(EmployeeBean employee, Long departmentId) {
        Employee newEmployee = new Employee();
        newEmployee.setAddress(employee.getAddress());
        newEmployee.setDateOfBirth(employee.getDateOfBirth());
        newEmployee.setDepartment(departmentRepository.findOne(departmentId));
        newEmployee.setEducation(employee.getEducation());
        newEmployee.setName(employee.getName());
        newEmployee.setPhones(employee.getPhones());
        newEmployee.setPosition(employee.getPosition());
        newEmployee.setSalary(employee.getSalary());
        employeeRepository.saveAndFlush(newEmployee);
    }

    public void removeEmployee(Long employeeId) {
        employeeRepository.delete(employeeId);
    }

    @Transactional
    public void updateEmployee(EmployeeBean employee) {
        Employee updateEmployee = employeeRepository.findOne(employee.getId());
        updateEmployee.setAddress(employee.getAddress());
        updateEmployee.setDateOfBirth(employee.getDateOfBirth());
        updateEmployee.setEducation(employee.getEducation());
        updateEmployee.setName(employee.getName());
        updateEmployee.setPhones(employee.getPhones());
        updateEmployee.setPosition(employee.getPosition());
        updateEmployee.setSalary(employee.getSalary());
        employeeRepository.saveAndFlush(updateEmployee);
    }

    @Transactional
    public void moveToAnotherDepartment(Long employeeId, Long departmentId) {
        Employee employee = employeeRepository.findOne(employeeId);
        Department department = departmentRepository.findOne(departmentId);
        employee.setDepartment(department);
        employeeRepository.saveAndFlush(employee);
    }
}
