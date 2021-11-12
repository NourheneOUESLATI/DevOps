package tn.esprit.spring;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
//import org.junit.Test;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;
import tn.esprit.spring.entities.*;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.services.IEmployeService;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
 public class EmployeServiceTest {

	@Autowired
	IEmployeService ems;
	@Autowired
	DepartementRepository departmentRepository;
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
		ems.getEmployeById(17);
		assertNotNull(ems.getEmployeById(17));
	}
	

	@Test
	public void testupdateemailEmploye(){
		ems.getEmployeById(25);
		assertNotNull(ems.getEmployeById(25));
		ems.mettreAjourEmailByEmployeId("nourhene.oueslati@esprit.tn", 25);
	}


	@Test
	public void testGetEmployeprenom(){
		Employe e=ems.getEmployeById(17);
		assertNotNull(e.getPrenom());
	}
/*

	@Test
	public void testAffecterEtDisaffectedEmployeeADepartment() {
		Employe e = new Employe();
		Departement d = new Departement();
		departmentRepository.save(d);
		ems.ajouterEmploye(e);
		ems.affecterEmployeADepartement(e.getId(), d.getId());

		assertEquals(1, d.getEmployes().size());

		ems.desaffecterEmployeDuDepartement(e.getId(), d.getId());
		assertNotEquals(1, d.getEmployes().size());


	}
*/

/*
	@Test
    public void testGetSalaireMoyenByDepartmentId() {
        Optional<Departement> d = departmentRepository.findById(1);
		assertAll("properties",
				() -> {
					assertNotNull(d);
					assertNotNull(ems.getSalaireMoyenByDepartementId(1));
				},
				() -> {
					List<Employe> employees = d.get().getEmployes();
					float acc = 0;
					for (Employe employee : employees) {
						Contrat contrat = employee.getContrat();
						Float salaire = contrat.getSalaire();
						acc = acc + salaire;
					};
					assertTrue(ems.getSalaireMoyenByDepartementId(1) == acc);
				}
		);
    }
*/
}