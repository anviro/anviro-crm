package org.anviro.crm.backend.another.service;

import org.anviro.crm.backend.another.database.dbservice.DepartmentDBService;
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
    public DepartmentBean getDepartment(Long id)
    {
        return departmentDBService.getDeparment(id);
    }

    @Override
    public DepartmentBean getDepartmentByName(String name)
    {
        return departmentDBService.getDeparment(name);
    }

    @Override
    public boolean addDepartment(DepartmentBean department) {
        return departmentDBService.addDepartment(department);
    }

    @Override
    public void updateDepartment(DepartmentBean department) {
        departmentDBService.updateDepartment(department);
    }

    @Override
    public void removeDepartment(Long id) {
        departmentDBService.removeDepartment(id);
    }
}
