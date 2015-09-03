package org.anviro.crm.common.webservices;

import org.anviro.crm.common.beans.another.EmployeeBean;

import javax.jws.WebService;
import java.util.List;

@WebService
public interface EmployeeService extends AbstractService {

    List<EmployeeBean> getEmployees();

    List<EmployeeBean> getEmployeesByDepartment(Long id);

    List<EmployeeBean> getEmployeesByPosition(String position);

    List<EmployeeBean> getEmployeesByName(String name);

    List<EmployeeBean> getEmployeesByPhone(String phone);

    EmployeeBean getEmployee(Long employeeId);

    boolean addEmployee(EmployeeBean employee, Long departmentId);

    boolean updateEmployee(EmployeeBean employee);

    boolean removeEmployee(Long employeeId);

    boolean moveToAnotherDepartment(Long employeeId, Long departmentId);

}
