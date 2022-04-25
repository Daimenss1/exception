package pro.sky.exception.Service;

import pro.sky.exception.Model.Employee;

import java.util.Set;

public interface EmployeeCollectionService {

    Employee addEmployee (String firstName, String lastName);

    Employee removeEmployee (String firstName, String lastName);

    Employee findEmployee (String firstName, String lastName);

    Set<Employee>getAllEmployees();
}
