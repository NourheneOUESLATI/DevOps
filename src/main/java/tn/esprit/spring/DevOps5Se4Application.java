package tn.esprit.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.repository.DepartementRepository;

@SpringBootApplication
public class DevOps5Se4Application  implements CommandLineRunner {
	@Autowired
	DepartementRepository ids;
	

	public static void main(String[] args) {
		SpringApplication.run(DevOps5Se4Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		Departement dep=new Departement(1,"dep2");
		Departement dep1=new Departement(2,"dep3");
		Departement dep2=new Departement(3,"dep4");
		ids.save(dep);
		ids.save(dep1);
		ids.save(dep2);
		
	}

}
