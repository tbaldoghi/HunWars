package com.elixir.hunwars.entities;

import com.elixir.hunwars.enums.HousingType;

public enum PopulationType {
	WORKER(new PopulationRuleSet("Worker", HousingType.YURT)),
	TRIBESMAN(new PopulationRuleSet("Tribesman", HousingType.GARRISON)),
	SPEARMAN(new PopulationRuleSet("Spearman", HousingType.GARRISON)),
	ARCHER(new PopulationRuleSet("Archer", HousingType.GARRISON)),
	LANCER(new PopulationRuleSet("Lancer", HousingType.GARRISON)),
	HORSE_ARCHER(new PopulationRuleSet("Horse archer", HousingType.GARRISON)),
	TARKHAN(new PopulationRuleSet("Tarkhan", HousingType.GARRISON)),
	KAM(new PopulationRuleSet("Kam", HousingType.HUT));

	private final PopulationRuleSet populationRuleSet;

	PopulationType(PopulationRuleSet populationRuleSet) {
		this.populationRuleSet = populationRuleSet;
	}

	public PopulationRuleSet getPopulationRuleSet() {
		return populationRuleSet;
	}
}
