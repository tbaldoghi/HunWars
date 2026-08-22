package com.elixir.hunwars.entities;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Population {
	private LinkedHashMap<PopulationType, PopulationData> populations = new LinkedHashMap<>();
	
	public Population() {
		populateLands();
		resetPopulationData();
	}
	
	public List<PopulationData> getPopulations() {
		return new ArrayList<PopulationData>(populations.values());
	}

	public int getTotalPopulationCount() {
		int counter = 0;
		
		for (PopulationType populationType : populations.keySet()) {
			counter += populations.get(populationType).getHave();
		}

		return counter;
	}
	
	public int foodPerTurn() {
		int counter = 0;

		for (PopulationData populationData : populations.values()) {
			counter += populationData.getHave() * populationData.getFoodPerTurn();
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
