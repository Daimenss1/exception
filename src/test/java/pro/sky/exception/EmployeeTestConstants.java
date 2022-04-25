package pro.sky.exception;


import pro.sky.exception.Model.Employee;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.groupingBy;

public class EmployeeTestConstants {

    public static final String FIRST_NAME = "John";
    public static final String LAST_NAME = "Smith";
    public static final String FIRST_NAME2 = "Mike";
    public static final String LAST_NAME2 = "Been";

    public static final int MAX_SALARY = 2000;

    public static final int MIN_SALARY = 1000;

    public static final int DEPARTMENT_ID = 1;

    public static final int DEPARTMENT_ID2 = 2;

    public static final Employee MAX_SALARY_EMPLOYEE = new Employee(FIRST_NAME, LAST_NAME, MAX_SALARY, DEPARTMENT_ID);

    public static final Employee MIN_SALARY_EMPLOYEE = new Employee(FIRST_NAME, LAST_NAME, MIN_SALARY, DEPARTMENT_ID);

    public static final Employee OTHER_DEPARTMENT_EMPLOYEE = new Employee(FIRST_NAME2, LAST_NAME2, MIN_SALARY, DEPARTMENT_ID2);

    static final Set<Employee> EMPLOYEES = Set.of(MAX_SALARY_EMPLOYEE, MIN_SALARY_EMPLOYEE);

    static final Set<Employee> DIFFERENT_DEPARTMENTS_EMPLOYEES = Set.of(MAX_SALARY_EMPLOYEE, OTHER_DEPARTMENT_EMPLOYEE);
    public static final Map<Integer, List<Employee>> DEPARTMENT_MAP = DIFFERENT_DEPARTMENTS_EMPLOYEES.stream().
            collect(groupingBy(Employee::getDepartmentId));
    public static final String WRONG_FIRST_NAME = "Jo1hn";
    public static final String WRONG_LAST_NAME = "Sm2ith";
}
