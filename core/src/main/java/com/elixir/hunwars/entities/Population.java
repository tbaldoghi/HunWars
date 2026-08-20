package com.elixir.hunwars.entities;

import java.util.LinkedHashMap;

public class Population {
	private LinkedHashMap<PopulationType, PopulationData> populations = new LinkedHashMap<>();
	
	public Population() {
		populateLands();
		resetPopulationData();
	}
	
	public int getTotalPopulationCount() {
		int counter = 0;
		
		for (PopulationType populationType : populations.keySet()) {
			counter += populations.get(populationType).getHave();
		}

		return counter;
	}
	
	private void populateLands() {
		for (PopulationType populationType : PopulationType.values()) {
			PopulationData populationData = new PopulationData(populationType);

			populations.put(populationType, populationData);
		}
	}

	private void resetPopulationData() {
		populations.get(PopulationType.WORKER).setHave(500);
		populations.get(PopulationType.TRIBESMAN).setHave(0);
		populations.get(PopulationType.SPEARMAN).setHave(0);
		populations.get(PopulationType.ARCHER).setHave(0);
		populations.get(PopulationType.LANCER).setHave(0);
		populations.get(PopulationType.HORSE_ARCHER).setHave(0);
		populations.get(PopulationType.TARKHAN).setHave(0);
		populations.get(PopulationType.KAM).setHave(0);
	}
}
