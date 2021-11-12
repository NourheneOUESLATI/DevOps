package tn.esprit.spring;




//import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static org.junit.Assert.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;


//import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;
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
		String date ="05/02/2023";
		Date dateC=new SimpleDateFormat("dd/MM/yyyy").parse(date);
		Contrat c=new Contrat(dateC,"MENSUEL",3200);
		ci.ajouterContrat(c);
		assertNotNull(c);
		l.info("Contract added" );
} 
	
	
	
	
	
	
	
	@Test
	public void testGetAllContrats() {
		Iterable<Contrat> le=cr.findAll();
		le.forEach(e->l.info(e+"\n"));
	} 
	
	@Test 
	public void getContratById()
	{
		try {
			
			assertNotNull(cr.findById(2));	
			l.info("Contract trouvé "  );
			} catch (NullPointerException e) {
				l.error(e.getMessage());
			}
	
		
	}
	
	@Test 
	public void testDeleteContratByRef(){
		assertNotNull(cr.findById(2));
		cr.deleteById(2);
		
		
	}
	
	@Test 
	public void updateContrat() throws ParseException {
		try {
			String date ="22/22/2030";
			Date dateC=new SimpleDateFormat("dd/MM/yyyy").parse(date);
			Contrat c = new Contrat(dateC,"CDI",1250);
			c.setReference(6);
			int Id = ci.ajouterContrat(c);
			c.setSalaire(2030);
			ci.ajouterContrat(c);
			l.info("Update contrat effectué");
			} catch (NullPointerException e) {
				l.error(e.getMessage());
			}
		}
		
	@Test
	public void testaffecterEmployetContrat() {
		cr.findById(1).get();
		ci.getEmployeById(3);
		ci.affecterContratAEmploye(1, 3);
		l.info("le contrat est affecté");
	}
		
		
		//assertNotNull(cr.findById(10));} 
		
		
/*@Test 
public void testDeleteAllContrats(){
	cr.deleteAll();
	l.info("ALL DELETED");
}*/
}


