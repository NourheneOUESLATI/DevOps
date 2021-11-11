package tn.esprit.spring;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.services.IEmployeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContratServiceTest {
	
	@Autowired
	IEmployeService ci ;
	
	@Autowired
	ContratRepository cr ;
	
	
	private static final Logger l = LogManager.getLogger(ContratServiceTest.class);

	
	@Test
	public void ajoutContrat() throws ParseException {
		String date ="07/11/2021";
		Date dateC=new SimpleDateFormat("dd/MM/yyyy").parse(date);
		Contrat c=new Contrat(dateC,"MENSUEL",1200);
		ci.ajouterContrat(c);
		assertNotNull(c);
} 
	
	/*@Test 
	public void testDeleteContratByRef(){
		ci.deleteContratById(3);
		assertNull(cr.findById(3));
	}*/
	
	
	
	/*@Test 
	public void testDeleteAllContrats(){
		cr.deleteAll();
		l.info("ALL DELETED");
	}*/
	
	@Test
	public void testGetAllContrats() {
		Iterable<Contrat> le= cr.findAll() ;
		le.forEach(e->l.info(e+"\n"));
	} 
}

