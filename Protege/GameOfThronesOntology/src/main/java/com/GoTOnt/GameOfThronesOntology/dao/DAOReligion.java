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

import com.GoTOnt.GameOfThronesOntology.model.Religion;
import com.GoTOnt.GameOfThronesOntology.utils.OntologyUtils;

public class DAOReligion extends DAO<Religion> {

	public DAOReligion() {
		queryFile = "static/queries/religions.rq";
	}

	@Override
	public List<Religion> getAll() {
		Query query = OntologyUtils.createQueryFromFile(queryFile);
		Map<String, Religion> results = queryReligions(query, "");
		List<Religion> religions = new ArrayList<>();

		for (String key : results.keySet()) {
			religions.add(results.get(key));
		}

		return religions;
	}

	@Override
	public Religion get(String uri) {
		SelectBuilder builder = OntologyUtils.getBasePrefixes();
		Query query = OntologyUtils.createQueryFromFile(queryFile);
		HashMap<Var, Node> values = new HashMap<>();

		values.put(SelectBuilder.makeVar("?religion"), builder.makeNode(uri));
		query = SelectBuilder.rewrite(query, values);

		return queryReligions(query, uri).get(uri);
	}

	private HashMap<String, Religion> queryReligions(Query query, String uri) {
		ResultSet results = executeQuery(query);
		HashMap<String, Religion> religions = new HashMap<>();

		String religion;
		while (results.hasNext()) {
			QuerySolution row = (QuerySolution) results.nextSolution();
			if (row.contains("religion")) {
				religion = row.get("religion").toString();
			}
			else {
				religion = uri;
			}

			Religion religionRelationEnd = getReligion(religions, row, religion);

			// if (row.contains("p")) {
			// String person = row.get("p").toString();
			// String personName = row.get("personName").toString();
			//
			// Person personRelationEnd = new Person(personName, person);
			// religionRelationEnd
			// .addRelation(new Relation(religionRelationEnd, personRelationEnd,
			// RelationType.HasMember));
			// personRelationEnd
			// .addRelation(new Relation(personRelationEnd, religionRelationEnd,
			// RelationType.IsMember));
			// }
		}

		return religions;
	}

	private Religion getReligion(HashMap<String, Religion> religions, QuerySolution row, String uri) {
		Religion religion;
		if (religions.containsKey(uri)) {
			religion = religions.get(uri);
		}
		else {
			String name = row.get("religionName").toString();
			religion = new Religion(name, uri);
			religions.put(uri, religion);
		}
		return religion;
	}
}
