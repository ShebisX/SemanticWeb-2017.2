package com.GoTOnt.GameOfThronesOntology.dao;

import java.util.List;

import com.GoTOnt.GameOfThronesOntology.model.BaseObject;
import com.GoTOnt.GameOfThronesOntology.query.SimpleQueryBuilder;

public abstract class DAO<T extends BaseObject> {

	private SimpleQueryBuilder queryBuilder;

	public DAO(SimpleQueryBuilder queryBuilder) {
		this.queryBuilder = queryBuilder;
	}

	public abstract List<T> getAll();

	public abstract T get(String uri);
}
