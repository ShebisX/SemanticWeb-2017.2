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

import com.GoTOnt.GameOfThronesOntology.model.Organization;
import com.GoTOnt.GameOfThronesOntology.utils.OntologyUtils;

public class DAOOrganization extends DAO<Organization> {

	public DAOOrganization() {
		queryFile = "static/queries/organizations.rq";
	}

	@Override
	public List<Organization> getAll() {
		Query query = OntologyUtils.createQueryFromFile(queryFile);
		Map<String, Organization> results = queryOrganizations(query, "");
		List<Organization> organizations = new ArrayList<>();

		for (String key : results.keySet()) {
			organizations.add(results.get(key));
		}

		return organizations;
	}

	@Override
	public Organization get(String uri) {
		SelectBuilder builder = OntologyUtils.getBasePrefixes();
		Query query = OntologyUtils.createQueryFromFile(queryFile);
		HashMap<Var, Node> values = new HashMap<>();

		values.put(SelectBuilder.makeVar("?organization"), builder.makeNode(uri));
		query = SelectBuilder.rewrite(query, values);

		return queryOrganizations(query, uri).get(uri);
	}

	private HashMap<String, Organization> queryOrganizations(Query query, String uri) {
		ResultSet results = executeQuery(query);
		HashMap<String, Organization> organizations = new HashMap<>();

		String organization;
		while (results.hasNext()) {
			QuerySolution row = (QuerySolution) results.nextSolution();
			if (row.contains("organization")) {
				organization = row.get("organization").toString();
			}
			else {
				organization = uri;
			}

			Organization organizationRelationEnd = getOrganization(organizations, row, organization);

			// if (row.contains("p")) {
			// String person = row.get("p").toString();
			// String personName = row.get("personName").toString();
			//
			// Person personRelationEnd = new Person(personName, person);
			// organizationRelationEnd
			// .addRelation(new Relation(organizationRelationEnd, personRelationEnd,
			// RelationType.HasMember));
			// personRelationEnd
			// .addRelation(new Relation(personRelationEnd, organizationRelationEnd,
			// RelationType.IsMember));
			// }
		}

		return organizations;
	}

	private Organization getOrganization(HashMap<String, Organization> organizations, QuerySolution row, String uri) {
		Organization organization;
		if (organizations.containsKey(uri)) {
			organization = organizations.get(uri);
		}
		else {
			String name = row.get("organizationName").toString();
			organization = new Organization(name, uri);
			organizations.put(uri, organization);
		}
		return organization;
	}
}
