package com.GoTOnt.GameOfThronesOntology.model;

public class Relation {

	private BaseObject end1;
	private BaseObject end2;
	private RelationType type;

	public Relation(BaseObject end1, BaseObject end2, RelationType type) {
		this.end1 = end1;
		this.end2 = end2;
		this.type = type;
	}

	public BaseObject getEnd1() {
		return end1;
	}

	public BaseObject getEnd2() {
		return end2;
	}

	public RelationType getType() {
		return type;
	}
}
