package tn.esprit.spring;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

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
	 void TestajoutContrat() throws ParseException {
		String date ="07/11/2021";
		Date dateC=new SimpleDateFormat("dd/MM/yyyy").parse(date);
		Contrat c=new Contrat(dateC,"MENSUEL",1200);
		ci.ajouterContrat(c);
		assertNotNull(c);
} 
	/*
	@Test
	public void testDeleteContratByRef(){
		Contrat c = new Contrat(new Date(),"MENSUEL",1200);
		ci.ajouterContrat(c);
		assertNotNull(c);
		ci.deleteContratById(c.getReference());
		assertNull(cr.findById(c.getReference()));
	}
	*/
	
	
	@Test
	public void testDeleteAllContrats(){
		cr.deleteAll();
		l.info("ALL DELETED");
	}
	
	@Test
	 void testGetAllContrats() {
		Iterable<Contrat> le= cr.findAll() ;
		le.forEach(e->l.info(e+"\n"));
	} 
}

