package com.elixir.hunwars.entities;

public class PopulationData {
	private final PopulationType type;
	private final String name;
	private int have;

	public PopulationData(PopulationType type) {
		this.type = type;
		this.name = type.getPopulationRuleSet().getName();
	}
	
	public String getName() {
		return name;
	}

	public int getHave() {
		return have;
	}

	public void setHave(int have) {
		this.have = have;
	}
}
