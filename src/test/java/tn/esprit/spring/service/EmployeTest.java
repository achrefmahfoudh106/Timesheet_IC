package tn.esprit.spring.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.IEmployeService;
import tn.esprit.spring.services.IUserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeTest {
	@Autowired
	IEmployeService us; 

	@Test
	public void testRetrieveAllEmployes() {
		List<Employe> listEmployes = us.retrieveAllEmployes(); 
		// if there are 7 users in DB : 
		Assert.assertEquals(7, listEmployes.size());
	}
	
	
	//@Test
	//public void testAddEmploye() throws ParseException {
		//SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		//Date d = dateFormat.parse("2015-03-23");
		//Employe e = new Employe("nom", "prenom", "email", true, Role.INGENIEUR);
		//Employe employeAdded = us.addEmploye(e); 
		//Assert.assertEquals(e.getPrenom(), employeAdded.getNom());
	//}
 

	@Test
	public void testModifyEmploye() throws ParseException   {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2015-03-23");
		Employe e = new Employe(1, "prenom", "email", "actif", null, false, Role.INGENIEUR) ;
		Employe empUpdated  = us.updateEmploye(e); 
		Assert.assertEquals(e.getNom(), empUpdated.getPrenom());
	}

	
	@Test
	public void testDeleteEmp() {
		us.deleteEmploye(0);;
		Assert.assertNull(us.retrieveEmploye(0));
	}
	
	@Test
	public void testRetrieveEmploye() {
		Employe empRetrieved = us.retrieveEmploye(1); 
		Assert.assertEquals(1L, empRetrieved.getId());
	}
	
}
