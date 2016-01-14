import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pakin.crm.domain.Employee;
import com.pakin.crm.service.IEmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class SpringJPATest {
	@Autowired
	IEmployeeService employeeService;
	@Test
	public void testSpringJPA() throws Exception {
		Employee emp=new Employee();
		emp.setUsername("pakin");
		employeeService.save(emp);
	}
}
