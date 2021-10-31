package tn.esprit.spring;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.List;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.services.IEmployeService;

@SpringBootTest
 class EmployeServiceTest {

	@Autowired
	IEmployeService ems;
	@Autowired
	DepartementRepository depts;
	@Autowired
	ContratRepository conts;
	
	private static final Logger l = Logger.getLogger(EmployeServiceTest.class); 
	
	@Test
	void ajouterEmploye() {
		Employe e = new Employe("test", "test", "test", true, Role.ADMINISTRATEUR);
		e = ems.ajouterEmploye(e);
		assertNotNull(e);
	}
	
	
}
