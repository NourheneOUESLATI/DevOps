package tn.esprit.spring.services;

import java.util.List;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.repository.DepartementRepository;

@Service
public class DepartementServiceImpl implements IDepartementService {
	private static final Logger l = Logger.getLogger(DepartementServiceImpl.class); 

	@Autowired
	DepartementRepository deptRepoistory;


	public List<Departement> getAllDepartements() {
		l.info(" In get all  departments");
		List<Departement> departments = (List<Departement>) deptRepoistory.findAll();
		for (Departement departement : departments) {
			l.debug("department +++ : " + departement);
		}
		l.info("Out of getAllDepartments."); 
		return departments;
	}


	@Override
	public Departement ajouterDepartment(Departement department) {
		try {
			l.info(" loading save department");
			Departement d = deptRepoistory.save(department);
			l.info(" Successful saving department");
			return d;
			} catch (Exception e) {
		           l.error("saving not completed !!!!");	
		          }return null;
	}


	@Transactional
	public void deleteDepartmentById(int id) {
		try {
			l.info(" search for department");
		Departement d = deptRepoistory.findById(id).get();
		l.info(" found departement");
		l.info(" deleting  departement");
		deptRepoistory.delete(d);	
		l.info(" operation finish  departement");
		} catch (Exception e) {
			l.error("departement could not be found !!!!");	
		}
		
	}


	@Override
	public Departement getDepartmentById(int departmentId) {
		try {
			l.info(" get departement");
		return  deptRepoistory.findById(departmentId).get();
		} catch (Exception e) {
			l.error("get departement operation failed");	
		}
		return null;
	}


	@Override
	public Departement updateDepartment(Departement department) {
		try {
			l.info(" loading update departement");
			Departement d = deptRepoistory.save(department);
			l.info(" Successful update departement");
			return d;
		} catch (Exception e) {
l.error("update not completed !!!!");	
}
		
		return null;
	}
	}

