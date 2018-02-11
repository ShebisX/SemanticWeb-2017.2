package com.GoTOnt.GameOfThronesOntology.model;

public class Family extends BaseObject {

	private String slogan;

	public Family(String name, String slogan) {
		super(name);
		this.slogan = slogan;
	}

	public String getSlogan() {
		return slogan;
	}
}
