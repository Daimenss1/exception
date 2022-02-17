package pro.sky.exception.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.exception.Model.Employee;
import pro.sky.exception.Service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
@GetMapping ("/")
    public String greetEmployee () {
        return " Hello, Employees";
    }
@GetMapping("/add")
    public Employee addEmployee (@RequestParam("firstName") String firstName,
                               @RequestParam("lastName") String lastName) {
        Employee addedEmployee = employeeService.addEmployee(firstName,lastName);
        return addedEmployee;
    }
    @GetMapping("/remove")
    public Employee removeEmployee (@RequestParam("firstName") String firstName,
                                    @RequestParam("lastName") String lastName) {
        Employee removedEmployee = employeeService.removeEmployee(firstName,lastName);
        return removedEmployee;
    }

    @GetMapping("/find")
    public Employee findEmployee (@RequestParam("firstName") String firstName,
                                  @RequestParam("lastName") String lastName) {
        Employee foundEmployee = employeeService.findEmployee(firstName,lastName);
        return foundEmployee;
    }
}
