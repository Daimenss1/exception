package pro.sky.exception;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.exception.Model.Employee;
import pro.sky.exception.Service.DepartmentServiceImpl;
import pro.sky.exception.Service.EmployeeMapService;
import pro.sky.exception.exceptions.EmployeeNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static pro.sky.exception.EmployeeTestConstants.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImplTest {

    @Mock
    private EmployeeMapService employeeService;

    @InjectMocks
    private DepartmentServiceImpl out;

    @Test
    public void shouldFindEmployeeWithMaxSalaryByDepartmentId() {
        when(employeeService.getAllEmployees()).thenReturn(EMPLOYEES);
        assertEquals(MAX_SALARY_EMPLOYEE, out.findEmployeeWithMaxSalaryByDepartmentId(DEPARTMENT_ID));
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenNoMaxSalary() {
        when(employeeService.getAllEmployees()).thenReturn(new ArrayList<>());
        assertThrows(EmployeeNotFoundException.class,
                () -> out.findEmployeeWithMaxSalaryByDepartmentId(DEPARTMENT_ID));
    }

    @Test
    public void shouldFindEmployeeWithMinSalaryByDepartmentId() {
        when(employeeService.getAllEmployees()).thenReturn(EMPLOYEES);
        assertEquals(MIN_SALARY_EMPLOYEE, out.findEmployeeWithMinSalaryByDepartmentId(DEPARTMENT_ID));
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenNoMinSalary() {
        when(employeeService.getAllEmployees()).thenReturn(new ArrayList());
        assertThrows(EmployeeNotFoundException.class,
                () -> out.findEmployeeWithMinSalaryByDepartmentId(DEPARTMENT_ID));
    }

    @Test
    public void shouldReturnEmptyMapWhenEmployeeDontExist() {
        when(employeeService.getAllEmployees()).thenReturn(new ArrayList());
        assertEquals(new HashMap(), out.findAllEmployeesByDepartmentId());
    }

    @Test
    public void shouldReturnAllEmployeesByDepartmentIdWhenEmployeesExist() {
        when(employeeService.getAllEmployees()).thenReturn(DIFFERENT_DEPARTMENTS_EMPLOYEES);
        assertEquals(DEPARTMENT_MAP, out.findAllEmployeesByDepartmentId());
    }

    @Test
    public void shouldReturnEmptyCollectionWhenNoEmployeesExistInDepartment() {
        when(employeeService.getAllEmployees()).thenReturn(EMPLOYEES);
        assertEquals(new ArrayList(), out.findEmployeesByDepartmentId(DEPARTMENT_ID2));
    }
    @Test
    public void shouldReturnEmployeesByDepartmentWhenEmployeesExistThere () {
        when(employeeService.getAllEmployees()).thenReturn(DIFFERENT_DEPARTMENTS_EMPLOYEES);
        assertEquals(List.of(MAX_SALARY_EMPLOYEE), out.findEmployeesByDepartmentId(DEPARTMENT_ID));
        assertEquals(List.of(OTHER_DEPARTMENT_EMPLOYEE), out.findEmployeesByDepartmentId(DEPARTMENT_ID2));
    }


}
