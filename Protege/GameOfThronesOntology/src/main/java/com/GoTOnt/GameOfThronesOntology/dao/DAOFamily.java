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

import com.GoTOnt.GameOfThronesOntology.model.Family;
import com.GoTOnt.GameOfThronesOntology.utils.OntologyUtils;

public class DAOFamily extends DAO<Family> {

	public DAOFamily() {
		queryFile = "static/queries/families.rq";
	}

	@Override
	public List<Family> getAll() {
		Query query = OntologyUtils.createQueryFromFile(queryFile);
		Map<String, Family> results = queryFamilies(query, "");
		List<Family> families = new ArrayList<>();

		for (String key : results.keySet()) {
			families.add(results.get(key));
		}

		return families;
	}

	@Override
	public Family get(String uri) {
		SelectBuilder builder = OntologyUtils.getBasePrefixes();
		Query query = OntologyUtils.createQueryFromFile(queryFile);
		HashMap<Var, Node> values = new HashMap<>();

		values.put(SelectBuilder.makeVar("?family"), builder.makeNode(uri));
		query = SelectBuilder.rewrite(query, values);

		return queryFamilies(query, uri).get(uri);
	}

	private HashMap<String, Family> queryFamilies(Query query, String uri) {
		ResultSet results = executeQuery(query);
		HashMap<String, Family> families = new HashMap<>();

		String family;
		while (results.hasNext()) {
			QuerySolution row = (QuerySolution) results.nextSolution();
			if (row.contains("family")) {
				family = row.get("family").toString();
			}
			else {
				family = uri;
			}

			Family familyRelationEnd = getFamily(families, row, family);
			
			if (row.contains("slogan")) {
				familyRelationEnd.slogan = row.get("slogan").toString();
			}
			// if (row.contains("p")) {
			// String person = row.get("p").toString();
			// String personName = row.get("personName").toString();
			//
			// Person personRelationEnd = new Person(personName, person);
			// familyRelationEnd
			// .addRelation(new Relation(familyRelationEnd, personRelationEnd,
			// RelationType.HasMember));
			// personRelationEnd
			// .addRelation(new Relation(personRelationEnd, familyRelationEnd,
			// RelationType.IsMember));
			// }
		}

		return families;
	}

	private Family getFamily(HashMap<String, Family> families, QuerySolution row, String uri) {
		Family family;
		if (families.containsKey(uri)) {
			family = families.get(uri);
		}
		else {
			String name = row.get("familyName").toString();
			family = new Family(name, uri);
			families.put(uri, family);
		}
		return family;
	}
}
