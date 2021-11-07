package tn.esprit.spring;

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


	/**
	 * TEST METHODS RELATED TO DEPARTMENT CLASS
	 */

	/**
	 * TEST METHOD AFFECTED EMPLOYEE TO DEPARTMENT
	 */
	@Test
	public void testAffectedEmployeeADepartment() {
		Optional<Departement> d = departmentRepository.findById(1);
		Employe e = ems.getEmployeById(1);
		assertAll("properties",
				() -> {
					assertNotNull(d);
					assertNotNull(e);
				},
				() -> {
					ems.affecterEmployeADepartement(1,1);
					List<Employe> employees = d.get().getEmployes();
					assertTrue(employees.contains(e));
				}
		);
	}

	/**
	 * TEST METHOD DISAFFECTED EMPLOYEE TO DEPARTMENT
	 */
	@Test
	public void testDisaffectedEmployeeADepartment() {
		Optional<Departement> d = departmentRepository.findById(1);
		Employe e = ems.getEmployeById(1);
		assertAll("properties",
				() -> {
					assertNotNull(d);
					assertNotNull(e);
				},
				() -> {
					ems.desaffecterEmployeDuDepartement(1,1);
					List<Employe> employees = d.get().getEmployes();
					assertTrue(!employees.contains(e));
				}
		);
	}

	/**
     * TEST METHOD GET SALAIRE MOYEN BY DEPARTMENT ID
     */
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

}