package com.elixir.hunwars.entities;

import com.elixir.hunwars.enums.HousingType;

public class PopulationRuleSet {
	private final HousingType housingType;
	
	public PopulationRuleSet(HousingType housingType) {
		this.housingType = housingType;
	}
	
	public HousingType getHousingType() {
		return housingType;
	}
}
