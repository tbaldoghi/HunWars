package com.elixir.hunwars.entities;

public class PopulationData {
	private final PopulationType type;
	private final String name;
	private final int foodPerTurn;
	private int have;

	public PopulationData(PopulationType type) {
		this.type = type;
		this.name = type.getPopulationRuleSet().getName();
		this.foodPerTurn = type.getPopulationRuleSet().getFoodPerTurn();
	}
	
	public String getName() {
		return name;
	}
	
	public int getFoodPerTurn() {
		return foodPerTurn;
	}

	public int getHave() {
		return have;
	}

	public void setHave(int have) {
		this.have = have;
	}
}
