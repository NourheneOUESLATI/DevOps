package tn.esprit.spring.services;


import java.util.List;



import tn.esprit.spring.entities.Departement;


public interface IDepartementService {
	
	
	public List<Departement> getAllDepartements();

	

	public Departement ajouterDepartment(Departement department);

	public void deleteDepartmentById(int id);

	public Departement getDepartmentById(int departmentId);



	public Departement updateDepartment(Departement department) ;
	
	
	

	
}
