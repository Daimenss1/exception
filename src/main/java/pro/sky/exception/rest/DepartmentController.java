package pro.sky.exception.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.exception.Model.Employee;
import pro.sky.exception.Service.DepartmentServiceImpl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping ("departments")
public class DepartmentController<DepartmentService> {
    private final DepartmentServiceImpl departmentService;

    public DepartmentController(DepartmentServiceImpl departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping("/max-salary")
    public Employee findEmployeesWithMaxSalaryByDepartmentId(@RequestParam int departmendId) {
        return departmentService.findEmployeeWithMaxSalaryByDepartmentId(departmendId);
    }
    @GetMapping("/min-salary")
    public Employee findEmployeesWithMinSalaryByDepartmentId(@RequestParam int departmendId) {
        return departmentService.findEmployeeWithMinSalaryByDepartmentId(departmendId);
    }
    @GetMapping(path = "/all", params = {"departmentId"} )
    public Collection<Employee> findEmployeesByDepartmentId(@RequestParam int departmendId) {
        return departmentService.findEmployeesByDepartmentId(departmendId);
    }
    @GetMapping("/all")
    public Map<Integer, List<Employee>> findAllEmployeesByDepartmentId() {
        return departmentService.findAllEmployeesByDepartmentId();
    }
}
