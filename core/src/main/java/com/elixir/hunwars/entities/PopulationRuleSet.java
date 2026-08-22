package com.elixir.hunwars.entities;

import com.elixir.hunwars.enums.HousingType;

public class PopulationRuleSet {
	private final String name;
	private final HousingType housingType;
	private final int foodPerTurn;
	
	public PopulationRuleSet(String name, HousingType housingType, int foodPerTurn) {
		this.name = name;
		this.housingType = housingType;
		this.foodPerTurn = foodPerTurn;
	}

	public String getName() {
		return name;
	}

	public HousingType getHousingType() {
		return housingType;
	}

	public int getFoodPerTurn() {
		return foodPerTurn;
	}
}
