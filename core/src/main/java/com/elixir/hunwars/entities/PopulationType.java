package com.elixir.hunwars.entities;

import com.elixir.hunwars.enums.HousingType;

public enum PopulationType {
	WORKER(new PopulationRuleSet("Worker", HousingType.YURT, 1)),
	TRIBESMAN(new PopulationRuleSet("Tribesman", HousingType.GARRISON, 1)),
	SPEARMAN(new PopulationRuleSet("Spearman", HousingType.GARRISON, 1)),
	ARCHER(new PopulationRuleSet("Archer", HousingType.GARRISON, 1)),
	LANCER(new PopulationRuleSet("Lancer", HousingType.GARRISON, 2)),
	HORSE_ARCHER(new PopulationRuleSet("Horse archer", HousingType.GARRISON, 2)),
	TARKHAN(new PopulationRuleSet("Tarkhan", HousingType.GARRISON, 3)),
	KAM(new PopulationRuleSet("Kam", HousingType.HUT, 1));

	private final PopulationRuleSet populationRuleSet;

	PopulationType(PopulationRuleSet populationRuleSet) {
		this.populationRuleSet = populationRuleSet;
	}

	public PopulationRuleSet getPopulationRuleSet() {
		return populationRuleSet;
	}
}
