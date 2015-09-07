package org.anviro.crm.common.webservices;

import org.anviro.crm.common.beans.another.DepartmentBean;

import javax.jws.WebService;
import java.util.List;

@WebService
public interface DepartmentService extends AbstractService {

    List<DepartmentBean> getDepartments();

    DepartmentBean getDepartment(Long id);

    DepartmentBean getDepartmentByName(String name);

    boolean addDepartment(DepartmentBean department);

    void updateDepartment(DepartmentBean department);

    void removeDepartment(Long departmentId);

}
