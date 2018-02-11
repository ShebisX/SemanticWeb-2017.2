package com.GoTOnt.GameOfThronesOntology.model;

public class Person extends BaseObject {

	private String alias;
	private String socialRange;

	public Person(String name, String alias, String socialRange) {
		super(name);
		this.alias = alias;
		this.socialRange = socialRange;
	}

	public String getAlias() {
		return alias;
	}

	public String getSocialRange() {
		return socialRange;
	}
}
