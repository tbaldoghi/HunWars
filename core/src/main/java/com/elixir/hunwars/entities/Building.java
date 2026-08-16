package com.elixir.hunwars.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;

public class Building {
	private LinkedHashMap<BuildingType, BuildingData> buildings = new LinkedHashMap<>();
	
	public Building() {
		populateBuildings();
	}
	
	public List<BuildingData> getBuildings() {
		return new ArrayList<BuildingData>(buildings.values());
	}

	public List<BuildingData> getPrioritizedBuildings() {
		List<BuildingData> buildingsToPrioritize = getBuildings();
		
		buildingsToPrioritize.sort((BuildingData a, BuildingData b) -> a.getPriority() - b.getPriority());
		
		return buildingsToPrioritize;
	}

	private void populateBuildings() {
		int priority = 1;

		for (BuildingType buildingType : BuildingType.values()) {
			BuildingData buildingData = new BuildingData(buildingType, buildingType.getName());

			buildingData.setPriority(priority);
			buildings.put(buildingType, buildingData);

			priority++;
		}
	}
}
