package pro.sky.exception.Service;

import org.springframework.stereotype.Service;
import pro.sky.exception.Model.Employee;
import pro.sky.exception.exceptions.EmployeeNotFoundException;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeMapService employeeService;

    public DepartmentServiceImpl(EmployeeMapService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee findEmployeeWithMaxSalaryByDepartmentId(int departmentId) {
        return employeeService.getAllEmployees().stream().filter(e-> e.getDepartmentId()==departmentId).
                max(Comparator.comparingInt(e-> e.getSalary()))
                .orElseThrow(()-> new EmployeeNotFoundException("This Employee has been already added!"));

    }

    @Override
    public Employee findEmployeeWithMinSalaryByDepartmentId(int departmentId) {
        return employeeService.getAllEmployees().stream().filter(e-> e.getDepartmentId()==departmentId).
                min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(()-> new EmployeeNotFoundException("This Employee has been already added!"));

    }

    @Override
    public Collection<Employee> findEmployeesByDepartmentId(int departmentId) {
        return employeeService.getAllEmployees().stream()
                .filter(e-> e.getDepartmentId()==departmentId)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> findAllEmployeesByDepartmentId() {
        Map<Integer, List<Employee>> result = new HashMap<>();
        employeeService.getAllEmployees().stream().
                forEach(e-> {
                   List<Employee> departmentEmployees = result.getOrDefault(e.getDepartmentId(), new ArrayList<Employee>());
                   departmentEmployees.add(e);
                    result.put(e.getDepartmentId(),departmentEmployees);
                });
        return result;
    }
}
