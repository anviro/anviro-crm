package org.anviro.crm.backend.another.service;

import org.anviro.crm.backend.another.database.service.EmployeeDBService;
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
        return null;
    }

    @Override
    public List<EmployeeBean> getEmployeesByDepartment(Long id) {
        return null;
    }

    @Override
    public List<EmployeeBean> getEmployeesByPosition(String position) {
        return null;
    }

    @Override
    public List<EmployeeBean> getEmployeesByName(String name) {
        return null;
    }

    @Override
    public List<EmployeeBean> getEmployeesByPhone(String phone) {
        return null;
    }

    @Override
    public EmployeeBean getEmployee(Long employeeId) {
        return null;
    }

    @Override
    public boolean addEmployee(EmployeeBean employee, Long departmentId) {
        return false;
    }

    @Override
    public boolean updateEmployee(EmployeeBean employee) {
        return false;
    }

    @Override
    public boolean removeEmployee(Long employeeId) {
        return false;
    }

    @Override
    public boolean moveToAnotherDepartment(Long employeeId, Long departmentId) {
        return false;
    }
}
