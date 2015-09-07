package org.anviro.crm.backend.another.service;

import org.anviro.crm.backend.another.database.dbservice.EmployeeDBService;
import org.anviro.crm.common.beans.another.EmployeeBean;
import org.anviro.crm.common.webservices.EmployeeService;
import org.anviro.crm.common.webservices.WebServiceConstants;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "org.anviro.crm.common.webservices.EmployeeService",
        serviceName = WebServiceConstants.EMPLOYEE_SERVICE_NAME)
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDBService employeeDBService;

    @Override
    public List<EmployeeBean> getEmployees() {
        return employeeDBService.getEmployees();
    }

    @Override
    public List<EmployeeBean> getEmployeesByDepartment(Long id) {
        return employeeDBService.getEmployeesByDepartment(id);
    }

    @Override
    public List<EmployeeBean> getEmployeesByPosition(String position) {

        return employeeDBService.getEmployeesByPosition(position);
    }

    @Override
    public List<EmployeeBean> getEmployeesByName(String name) {
        return employeeDBService.getEmployeesByName(name);
    }

    @Override
    public List<EmployeeBean> getEmployeesByPhone(String phone) {
        return employeeDBService.getEmployeesByPhone(phone);
    }

    @Override
    public EmployeeBean getEmployee(Long employeeId) {
        return employeeDBService.getEmployee(employeeId);
    }

    @Override
    public void addEmployee(EmployeeBean employee, Long departmentId) {
        employeeDBService.addEmployee(employee, departmentId);
    }

    @Override
    public void updateEmployee(EmployeeBean employee) {
        employeeDBService.updateEmployee(employee);
    }

    @Override
    public void removeEmployee(Long employeeId) {
        employeeDBService.removeEmployee(employeeId);
    }

    @Override
    public void moveToAnotherDepartment(Long employeeId, Long departmentId) {
        employeeDBService.moveToAnotherDepartment(employeeId, departmentId);
    }
}
