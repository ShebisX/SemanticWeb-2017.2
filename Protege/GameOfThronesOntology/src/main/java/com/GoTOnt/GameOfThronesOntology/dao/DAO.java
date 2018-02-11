package com.GoTOnt.GameOfThronesOntology.dao;

import java.util.List;

import com.GoTOnt.GameOfThronesOntology.model.BaseObject;
import com.GoTOnt.GameOfThronesOntology.query.SimpleQueryBuilder;

public abstract class DAO {

	private SimpleQueryBuilder queryBuilder;

	public DAO(SimpleQueryBuilder queryBuilder) {
		this.queryBuilder = queryBuilder;
	}

	public abstract List<BaseObject> getAll();

	public abstract BaseObject get(BaseObject BaseObject);
}
