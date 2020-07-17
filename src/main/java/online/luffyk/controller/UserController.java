package online.luffyk.controller;

import online.luffyk.domain.Employee;
import online.luffyk.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class UserController {
    @Resource
    private EmployeeService employeeService;

    @RequestMapping("hello")
    public String hello(){
        System.out.println("你好SpringMVC");
        List<Employee> employees = employeeService.showAllEmployeesService();
        for(Employee value:employees){
            System.out.println(value);
        }
        return "hello";
    }
}
