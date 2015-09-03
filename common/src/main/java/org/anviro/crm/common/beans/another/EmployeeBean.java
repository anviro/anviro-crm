package org.anviro.crm.common.beans.another;

import org.anviro.crm.common.beans.another.DepartmentBean;

import java.util.Date;
import java.util.List;

public class EmployeeBean {

    private Long id;
    private String name;
    private Date dateOfBirth;
    private String position;
    private List<String> phones;
    private String address;
    private String education;
    private int salary;
    private DepartmentBean department;

    public EmployeeBean() {
    }

    public EmployeeBean(Long id, String name, Date dateOfBirth, String position,
                        List<String> phones, String address, String education,
                        int salary, DepartmentBean department) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.position = position;
        this.phones = phones;
        this.address = address;
        this.education = education;
        this.salary = salary;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public DepartmentBean getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentBean department) {
        this.department = department;
    }

}
