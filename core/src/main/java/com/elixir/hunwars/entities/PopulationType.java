package com.elixir.hunwars.entities;

import com.elixir.hunwars.enums.HousingType;

public enum PopulationType {
	WORKER(new PopulationRuleSet(HousingType.YURT)),
	TRIBESMAN(new PopulationRuleSet(HousingType.GARRISON)),
	SPEARMAN(new PopulationRuleSet(HousingType.GARRISON)),
	ARCHER(new PopulationRuleSet(HousingType.GARRISON)),
	LANCER(new PopulationRuleSet(HousingType.GARRISON)),
	HORSE_ARCHER(new PopulationRuleSet(HousingType.GARRISON)),
	TARKHAN(new PopulationRuleSet(HousingType.GARRISON)),
	RAIDER(new PopulationRuleSet(HousingType.GARRISON)),
	KAM(new PopulationRuleSet(HousingType.HUT));

	private final PopulationRuleSet populationRuleSet;

	PopulationType(PopulationRuleSet populationRuleSet) {
		this.populationRuleSet = populationRuleSet;
	}

	public PopulationRuleSet getPopulationRuleSet() {
		return populationRuleSet;
	}
}
