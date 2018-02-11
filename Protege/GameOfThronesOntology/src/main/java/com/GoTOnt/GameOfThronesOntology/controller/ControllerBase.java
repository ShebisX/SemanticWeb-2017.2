package com.GoTOnt.GameOfThronesOntology.controller;

import java.util.List;

import com.GoTOnt.GameOfThronesOntology.model.BaseObject;

public interface ControllerBase {

	public List<BaseObject> getAll();

	public BaseObject get(String uri);
}
