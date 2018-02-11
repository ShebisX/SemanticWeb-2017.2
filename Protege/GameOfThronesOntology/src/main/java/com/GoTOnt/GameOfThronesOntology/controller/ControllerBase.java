package com.GoTOnt.GameOfThronesOntology.controller;

import java.util.List;

import com.GoTOnt.GameOfThronesOntology.model.BaseObject;

public interface ControllerBase<T extends BaseObject> {

	public abstract List<T> getAll();

	public abstract T get(String uri);
}
