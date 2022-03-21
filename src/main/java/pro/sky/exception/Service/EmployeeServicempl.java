package pro.sky.exception.Service;

import org.springframework.stereotype.Service;
import pro.sky.exception.Model.Employee;
import pro.sky.exception.exceptions.EmployeeArrayFullException;
import pro.sky.exception.exceptions.EmployeeExistsException;
import pro.sky.exception.exceptions.EmployeeNotFoundException;

@Service
public class EmployeeServicempl implements EmployeeService {

    private final Employee [] employees = new Employee[2];
    private int size;

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        if (employees.length==size) {
            throw new EmployeeArrayFullException("Employee array if full");
        }
        Employee addingEmployee = new Employee(firstName,lastName);
        int addingEmployeeIndex = getEmployeeIndex(addingEmployee);

        if (addingEmployeeIndex != -1) {
            throw new EmployeeExistsException("This Employee has been already added!");
        }
        employees[size++] = addingEmployee;
        return addingEmployee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee removingEmployee = new Employee(firstName,lastName);
        int employeeIndex = getEmployeeIndex(removingEmployee);

        if (employeeIndex == -1) {
            throw new EmployeeNotFoundException(" This employee cant found");
        }
        Employee removedEmployee = employees[employeeIndex];
        System.arraycopy(employees,employeeIndex + 1, employees, employeeIndex, size - employeeIndex);
        size--;
        return removedEmployee;
    }

    private int getEmployeeIndex(Employee employee) {
        for (int i=0; i< size; i++)
            if (employee.equals(employees[i])) {
                return i;
            }
        return -1;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee findingEmployee = new Employee(firstName,lastName);
        int employeeIndex = getEmployeeIndex(findingEmployee);

        if (employeeIndex == -1) {
            throw new EmployeeNotFoundException(" This employee cant found");
        }
        return employees[employeeIndex];
    }
}
