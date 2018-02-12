package com.GoTOnt.GameOfThronesOntology;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.GoTOnt.GameOfThronesOntology.controller.Controller;
import com.GoTOnt.GameOfThronesOntology.dao.DAOFamily;
import com.GoTOnt.GameOfThronesOntology.dao.DAOOrganization;
import com.GoTOnt.GameOfThronesOntology.dao.DAOPerson;
import com.GoTOnt.GameOfThronesOntology.dao.DAOReligion;
import com.GoTOnt.GameOfThronesOntology.model.Family;
import com.GoTOnt.GameOfThronesOntology.model.Organization;
import com.GoTOnt.GameOfThronesOntology.model.Person;
import com.GoTOnt.GameOfThronesOntology.model.Religion;

@RestController
public class Endpoint {

	private static HashMap<String, Controller> controllers = new HashMap<>();
	static {
		controllers.put("family", new Controller<Family>(new DAOFamily()));
		controllers.put("organization", new Controller<Organization>(new DAOOrganization()));
		controllers.put("person", new Controller<Person>(new DAOPerson()));
		controllers.put("religion", new Controller<Religion>(new DAOReligion()));
	}

	@RequestMapping(value = "/api/families")
	public List<Family> getFamilies() {
		return controllers.get("family").getAll();
	}

	@RequestMapping(value = "/api/family")
	public Family getFamily(@RequestParam(value = "uri") String uri) {
		return (Family) controllers.get("family").get(uri);
	}

	@RequestMapping(value = "/api/organizations")
	public List<Organization> getOrganizations() {
		return controllers.get("organization").getAll();
	}

	@RequestMapping(value = "/api/organization")
	public Organization getOrganization(@RequestParam(value = "uri") String uri) {
		return (Organization) controllers.get("organization").get(uri);
	}

	@RequestMapping(value = "/api/persons")
	public List<Person> getPersons() {
		return controllers.get("person").getAll();
	}

	@RequestMapping(value = "/api/person")
	public Person getPerson(@RequestParam(value = "uri") String uri) {
		return (Person) controllers.get("person").get(uri);
	}

	@RequestMapping(value = "/api/religions")
	public List<Religion> getReligions() {
		return controllers.get("religion").getAll();
	}

	@RequestMapping(value = "/api/religion")
	public Religion getReligion(@RequestParam(value = "uri") String uri) {
		return (Religion) controllers.get("religion").get(uri);
	}
}
