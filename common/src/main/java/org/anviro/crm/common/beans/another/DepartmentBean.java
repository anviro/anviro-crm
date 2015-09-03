package org.anviro.crm.common.beans.another;

import java.util.List;

public class DepartmentBean {

    private Long id;
    private String name;
    private String address;
    private String phone;
    private List<EmployeeBean> employees;

    public DepartmentBean() {
    }

    public DepartmentBean(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public DepartmentBean(Long id, String name, String address, String phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public DepartmentBean(Long id, String name, String address, String phone, List<EmployeeBean> employees) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.employees = employees;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<EmployeeBean> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeBean> employees) {
        this.employees = employees;
    }

}
