package com.GoTOnt.GameOfThronesOntology.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.jena.arq.querybuilder.SelectBuilder;
import org.apache.jena.graph.Node;
import org.apache.jena.query.Query;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.sparql.core.Var;

import com.GoTOnt.GameOfThronesOntology.model.Person;
import com.GoTOnt.GameOfThronesOntology.utils.OntologyUtils;

public class DAOPerson extends DAO<Person> {

	public DAOPerson() {
		queryFile = "static/queries/persons.rq";
	}

	@Override
	public List<Person> getAll() {
		Query query = OntologyUtils.createQueryFromFile(queryFile);
		Map<String, Person> results = queryPersons(query, "");
		List<Person> persons = new ArrayList<>();

		for (String key : results.keySet()) {
			persons.add(results.get(key));
		}

		return persons;
	}

	@Override
	public Person get(String uri) {
		SelectBuilder builder = OntologyUtils.getBasePrefixes();
		Query query = OntologyUtils.createQueryFromFile(queryFile);
		HashMap<Var, Node> values = new HashMap<>();

		values.put(SelectBuilder.makeVar("?p"), builder.makeNode(uri));
		query = SelectBuilder.rewrite(query, values);

		return queryPersons(query, uri).get(uri);
	}

	private HashMap<String, Person> queryPersons(Query query, String uri) {
		ResultSet results = executeQuery(query);
		HashMap<String, Person> persons = new HashMap<>();

		String p;
		while (results.hasNext()) {
			QuerySolution row = (QuerySolution) results.nextSolution();
			if (row.contains("p")) {
				p = row.get("p").toString();
			}
			else {
				p = uri;
			}

			Person person = getPerson(persons, row, p);
			if (row.contains("alias")) {
				String alias = "";
				alias = row.get("alias").toString();
				person.alias = alias;
			}
			// if (row.contains("x")) {
			// String x = row.get("x").toString();
			// String typeX = row.get("typeX").toString();
			// String nameX = row.get("nameX").toString();
			//
			// BaseObject endRelation = null;
			// RelationType relationType = null;
			// if (typeX.contains("Organization")) {
			// endRelation = new Organization(nameX, x);
			// relationType = RelationType.IsMember;
			// }
			// else if (typeX.contains("Religion")) {
			// endRelation = new Religion(nameX, x);
			// relationType = RelationType.HasReligion;
			// }
			// else if (typeX.contains("Family")) {
			// endRelation = new Family(nameX, x);
			// relationType = RelationType.IsMember;
			// }
			//
			// if (endRelation != null) {
			// Relation relation = new Relation(person, endRelation, relationType);
			// person.addRelation(relation);
			// endRelation.addRelation(relation);
			// }
			// }
		}

		return persons;
	}

	private Person getPerson(HashMap<String, Person> persons, QuerySolution row, String uri) {
		Person person;
		if (persons.containsKey(uri)) {
			person = persons.get(uri);
		}
		else {
			String name = row.get("name").toString();
			person = new Person(name, uri);
			persons.put(uri, person);
		}
		return person;
	}
}
