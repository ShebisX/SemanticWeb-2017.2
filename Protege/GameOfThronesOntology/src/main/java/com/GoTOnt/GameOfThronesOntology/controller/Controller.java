package com.GoTOnt.GameOfThronesOntology.controller;

import java.util.List;

import com.GoTOnt.GameOfThronesOntology.dao.DAO;
import com.GoTOnt.GameOfThronesOntology.model.BaseObject;

public class Controller<T extends BaseObject> {

	private DAO repository;

	public Controller(DAO repository) {
		this.repository = repository;
	}

	public List<T> getAll() {
		return (List<T>) repository.getAll();
	}

	public T get(String uri) {
		return (T) repository.get(uri);
	}
}
