package online.luffyk.service.impl;

import online.luffyk.dao.EmployeeMapper;
import online.luffyk.domain.Employee;
import online.luffyk.service.EmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Resource
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> showAllEmployeesService() {
        return employeeMapper.showAllEmployees();
    }
}
