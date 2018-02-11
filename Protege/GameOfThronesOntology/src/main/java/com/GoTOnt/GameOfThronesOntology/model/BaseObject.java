package com.GoTOnt.GameOfThronesOntology.model;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseObject {

	public String name;
	private List<Relation> relations;

	public BaseObject(String name) {
		this.name = name;
		this.relations = new ArrayList<>();
	}

	public void addRelation(Relation relation) {
		relations.add(relation);
	}

	public List<Relation> getRelations() {
		return relations;
	}
}
