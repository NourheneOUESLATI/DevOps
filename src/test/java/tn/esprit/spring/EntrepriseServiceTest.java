package tn.esprit.spring;

import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;
import tn.esprit.spring.services.IDepartementService;
import tn.esprit.spring.services.IEntrepriseService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EntrepriseServiceTest {

	@Autowired
	IEntrepriseService entrepriseSerice;
	
	@Autowired
	EntrepriseRepository entrepriseRepo;
	
	@Autowired
	DepartementRepository departementRepo;
	
	public static final Logger l = LogManager.getLogger(EntrepriseServiceTest.class);
	
	/*@Test
	public void ajouterEntreprise() {
		Entreprise e = new Entreprise("entreprise5" ,"entreprise5");
		entrepriseSerice.ajouterEntreprise(e);
		assertNotNull(e);
		l.info("entreprise ajoutee");
	}
	
	@Test
	public void getEntrepriseById() {
		
		assertNotNull(entrepriseSerice.getEntrepriseById(1));
		l.info(entrepriseSerice.getEntrepriseById(1).getName());
	}
	
	/*@Test
	public void deleteEntrepriseById() {
		entrepriseSerice.deleteEntrepriseById(3);
		l.info("deleted enterprise");
	}*/
	
	@Test
	public void affecterDepartementAEntreprise() {
		departementRepo.findById(2);
		entrepriseSerice.getEntrepriseById(4);
		entrepriseSerice.affecterDepartementAEntreprise(2, 4);
	}
	
	@Test
	public void getAllDepartementsNamesByEntreprise() {
		entrepriseSerice.getEntrepriseById(4);
		entrepriseSerice.getAllDepartementsNamesByEntreprise(4);
	}
	
}
