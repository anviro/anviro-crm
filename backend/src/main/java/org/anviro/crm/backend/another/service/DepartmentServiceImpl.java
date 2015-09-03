package org.anviro.crm.backend.another.service;

import org.anviro.crm.backend.another.database.service.DepartmentDBService;
import org.anviro.crm.common.beans.another.DepartmentBean;
import org.anviro.crm.common.webservices.DepartmentService;
import org.anviro.crm.common.webservices.WebServiceConstants;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "org.anviro.crm.common.webservices.DepartmentService",
        serviceName = WebServiceConstants.DEPARTMENT_SERVICE_NAME)
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDBService departmentDBService;

    @Override
    public List<DepartmentBean> getDepartments() {
        return departmentDBService.getDepartments();
    }

    @Override
    public DepartmentBean getDepartment(Long id) {
        return null;
    }

    @Override
    public DepartmentBean getDepartmentByName(String name) {
        return null;
    }

    @Override
    public boolean addDepartment(DepartmentBean department) {
        return departmentDBService.addDepartment(department);
    }

    @Override
    public boolean updateDepartment(DepartmentBean department) {
        return false;
    }

    @Override
    public boolean removeDepartment(Long departmentId) {
        return false;
    }
}
