package com.GoTOnt.GameOfThronesOntology.dao;

import java.util.List;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Model;

import com.GoTOnt.GameOfThronesOntology.model.BaseObject;
import com.GoTOnt.GameOfThronesOntology.utils.OntologyUtils;

public abstract class DAO<T extends BaseObject> {

	protected final static Model model = OntologyUtils.readRDFFile("static/source.owl");
	protected String queryFile;

	protected ResultSet executeQuery(Query query) {
		QueryExecution exec = QueryExecutionFactory.create(query, model);
		return exec.execSelect();
	}

	public abstract List<T> getAll();

	public abstract T get(String uri);
}
