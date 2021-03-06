package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.User;

public interface IEmployeService {
	List<Employe> retrieveAllEmployes(); 
	Employe addEmploye(Employe e);
	void deleteEmploye(int id);
	Employe updateEmploye(Employe e);
	Employe retrieveEmploye(int id);
}
