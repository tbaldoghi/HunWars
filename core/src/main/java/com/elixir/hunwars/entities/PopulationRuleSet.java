package com.elixir.hunwars.entities;

import com.elixir.hunwars.enums.HousingType;

public class PopulationRuleSet {
	private final String name;
	private final HousingType housingType;
	
	public PopulationRuleSet(String name, HousingType housingType) {
		this.name = name;
		this.housingType = housingType;
	}

	public String getName() {
		return name;
	}

	public HousingType getHousingType() {
		return housingType;
	}
}
