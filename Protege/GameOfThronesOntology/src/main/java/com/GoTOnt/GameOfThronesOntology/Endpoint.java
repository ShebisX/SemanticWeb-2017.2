package com.GoTOnt.GameOfThronesOntology;

import java.util.HashMap;

import org.springframework.web.bind.annotation.RestController;

import com.GoTOnt.GameOfThronesOntology.controller.AnimalController;
import com.GoTOnt.GameOfThronesOntology.controller.ControllerBase;
import com.GoTOnt.GameOfThronesOntology.controller.FamilyController;
import com.GoTOnt.GameOfThronesOntology.controller.OrganizationController;
import com.GoTOnt.GameOfThronesOntology.controller.PersonController;
import com.GoTOnt.GameOfThronesOntology.controller.PlaceController;
import com.GoTOnt.GameOfThronesOntology.controller.ReligionController;

@RestController
public class Endpoint {

	private static HashMap<String, ControllerBase> controllers = new HashMap<>();
	static {
		controllers.put("animal", new AnimalController());
		controllers.put("family", new FamilyController());
		controllers.put("organization", new OrganizationController());
		controllers.put("person", new PersonController());
		controllers.put("place", new PlaceController());
		controllers.put("religion", new ReligionController());
	}
}
