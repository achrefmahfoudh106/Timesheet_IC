package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.repository.UserRepository;

@Service
public class EmployeServiceImp implements IEmployeService {

	@Autowired
	EmployeRepository empRepository;

	private static final Logger l = LogManager.getLogger(EmployeServiceImp.class);



	
	@Override
	public List<Employe> retrieveAllEmployes() { 
		List<Employe> employes = null; 

			employes = (List<Employe>) empRepository.findAll();  
		

		return employes;
	}

	@Override
	public Employe addEmploye(Employe e) {
		return empRepository.save(e); 
	}

	@Override
	public void deleteEmploye(int id) {
		empRepository.deleteById(id);
	}

	@Override
	public Employe updateEmploye(Employe e) {
		return empRepository.save(e);
	}

	@Override
	public Employe retrieveEmploye(int id) {
		//l.info("in  retrieveUser id = " + id);
		Employe e =  empRepository.findById(id).get(); 
		//l.info("employe returned : " + e);
		return e; 
	}
 
	
}
