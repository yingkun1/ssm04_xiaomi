package online.luffyk.dao;

import online.luffyk.domain.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeMapper {
    List<Employee> showAllEmployees();
}
