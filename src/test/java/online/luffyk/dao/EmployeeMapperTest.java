package online.luffyk.dao;

import online.luffyk.domain.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class EmployeeMapperTest {
    @Resource
    private EmployeeMapper employeeMapper;

    @Test
    public void testShowAllEmployees() {
        System.out.println(employeeMapper);
        List<Employee> employees = employeeMapper.showAllEmployees();
        for(Employee employee:employees){
            System.out.println(employee);
        }
    }
}
