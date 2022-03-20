package pro.sky.exception.Service;


import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.exception.Model.Employee;
import pro.sky.exception.exceptions.EmployeeExistsException;
import pro.sky.exception.exceptions.EmployeeNotFoundException;

import javax.naming.InvalidNameException;
import java.util.*;

@Service
public class EmployeeServiceMapImpl implements EmployeeMapService {

    private final Map<String, Employee> employees = new HashMap<>();


    @Override
    public Employee addEmployee(String firstName, String lastName) {
        validateNames(firstName, lastName);

        Employee addingEmployee = new Employee(firstName,lastName);

        String key = firstName + lastName;

        if (employees.containsKey(key)) {
            throw new EmployeeExistsException("This Employee has been already added!");

        }

        employees.put(key, addingEmployee);
        return addingEmployee;

    }

    private void validateNames(String... names){
        Arrays.stream(names).forEach(name->{
            if (!StringUtils.isAlpha(name)) {
                throw new InvalidNameException();
            }
        });

    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        String key = firstName + lastName;
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException(" This employee cant found");
        }
        return employees.remove(key);
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        String key = firstName + lastName;
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException(" This employee cant found");
        }
        return employees.get(key);
    }

    @Override
    public Collection<Employee> getAllEmployees() {
        return Collections.unmodifiableCollection(employees.values());
    }
}

