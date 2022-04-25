package pro.sky.exception.Service;


import org.springframework.stereotype.Service;
import pro.sky.exception.Model.Employee;
import pro.sky.exception.exceptions.EmployeeExistsException;
import pro.sky.exception.exceptions.EmployeeNotFoundException;

import java.util.HashSet;
import java.util.Set;

@Service
public class EmployeeServiceCollectionImpl implements EmployeeCollectionService {

   private Set<Employee> employees = new HashSet<>();


    @Override
    public Employee addEmployee(String firstName, String lastName) {

        Employee addingEmployee = new Employee(firstName,lastName);

        if (employees.contains(addingEmployee)) {
            throw new EmployeeExistsException("This Employee has been already added!");

        }

        employees.add(addingEmployee);
        return addingEmployee;

    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee removingEmployee = new Employee(firstName,lastName);

        if (!employees.remove(removingEmployee)) {
            throw new EmployeeNotFoundException(" This employee cant found");
        }
        return removingEmployee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee findingEmployee = new Employee(firstName,lastName);

        if (!employees.contains(findingEmployee)) {
            throw new EmployeeNotFoundException(" This employee cant found");
        }
        return findingEmployee;
    }

    @Override
    public Set<Employee> getAllEmployees() {
        return employees;
    }
}


