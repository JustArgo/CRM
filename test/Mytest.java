import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pakin.crm.domain.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class Mytest {
	/*@Autowired
	Date date;*/
	@Test
	public void testSpring() throws Exception {
		System.out.println("date");
	}
	
	@Test
	public void testJPA() throws Exception {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("myjpa");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		Employee emp=new Employee();
		entityManager.persist(emp);
		entityManager.getTransaction().commit();
	}
}
