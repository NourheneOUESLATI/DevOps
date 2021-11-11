package tn.esprit.spring;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.List;
//import org.junit.Test;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.services.IEmployeService;

@RunWith(SpringRunner.class)
@SpringBootTest
 public class EmployeServiceTest {

	@Autowired
	IEmployeService ems;
	@Autowired
	DepartementRepository depts;
	@Autowired
	ContratRepository conts;
	
	private static final Logger l = Logger.getLogger(EmployeServiceTest.class); 
	
	@Test
	public void ajouterEmploye() {
		Employe e = new Employe("test", "test", "test", true, Role.ADMINISTRATEUR);
		e = ems.ajouterEmploye(e);
		assertNotNull(e);
	}

	@Test
	public void testGetAllEmployes() {
		List<Employe> le=ems.getAllEmployes();
		le.forEach(e->l.info(e+"\n"));
		assertNotNull(le);
	}
	
	@Test
	public void testGetEmployeById(){
		ems.getEmployeById(1);
		assertNotNull(ems.getEmployeById(1));
	}
	
	/*@Test 
	public void testDeleteEmployeById(){
		ems.deleteEmployeById(25);
	}
	*/
	@Test
	public void testupdateemailEmploye(){
		ems.getEmployeById(1);
		assertNotNull(ems.getEmployeById(1));
		ems.mettreAjourEmailByEmployeId("nourhene.oueslati@esprit.tn", 1);
	}

	@Test
	public void testaffecterEmployeADepartement() {
		ems.getEmployeById(1);
		depts.findById(1);
		ems.affecterEmployeADepartement(1, 1);
	}
	
	@Test
	public void testdesaffecterEmployeADepartement() {
		ems.getEmployeById(1);
		depts.findById(1);
		ems.desaffecterEmployeDuDepartement(1, 1);
	}
	
	@Test
	public void testGetEmployeprenom(){
		Employe e=ems.getEmployeById(1);
		assertNotNull(e.getPrenom());
	}
	
}