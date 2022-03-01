package pro.sky.exception.Service;

import pro.sky.exception.Model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee findEmployeeWithMaxSalaryByDepartmentId (int departmentId);

    Employee findEmployeeWithMinSalaryByDepartmentId (int departmentId);

    Collection<Employee> findEmployeesByDepartmentId (int departmentId);

    Map <Integer, List<Employee>> findAllEmployeesByDepartmentId();
}
