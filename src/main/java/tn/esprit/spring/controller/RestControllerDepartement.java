package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import tn.esprit.spring.entities.Departement;

import tn.esprit.spring.services.IDepartementService;
@RestController
public class RestControllerDepartement {
	@Autowired
    IDepartementService idepartmentservice;
	
	
	
    @DeleteMapping("/deleteDepartementById/{depId}") 
	@ResponseBody 
	public void deleteContratByRef(@PathVariable("depId")int depId)
	{
    	idepartmentservice.deleteDepartmentById(depId);
	}
    
    
    @GetMapping(value = "/getDepartementById/{depId}")
    @ResponseBody
	public Departement getDepartementById(@PathVariable("depId") int depId) {

		return idepartmentservice.getDepartmentById(depId);
	}
    
    @GetMapping(value = "/getDepartementById")
    @ResponseBody
	public List<Departement> getAllDepartements() {

		return idepartmentservice.getAllDepartements();
	}
    
    

}