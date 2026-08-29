package com.elixir.hunwars.entities;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Building {
	private LinkedHashMap<BuildingType, BuildingData> buildings = new LinkedHashMap<>();
	private Husbandry husbandry;
	
	public Building() {
		populateBuildings();
		resetBuildingData();
	}
	
	public BuildingData getBuilding(BuildingType buildingType) {
		return buildings.get(buildingType);
	}

	public List<BuildingData> getBuildings() {
		return new ArrayList<BuildingData>(buildings.values());
	}

	public List<BuildingData> getPrioritizedBuildings() {
		List<BuildingData> buildingsToPrioritize = getBuildings();
		
		buildingsToPrioritize.sort((BuildingData a, BuildingData b) -> a.getPriority() - b.getPriority());
		
		return buildingsToPrioritize;
	}

	public int getInProgress(BuildingType buildingType, int index) {
		return buildings.get(buildingType).getInProgress()[index];
	}

	public int getTotalInProgressCount(BuildingType buildingType) {
		int counter = 0;
		int[] inProgress = buildings.get(buildingType).getInProgress();
		
		for (int i = 0; i < inProgress.length; i++) {
			counter += inProgress[i];
		}

		return counter;
	}

	public int getPercentage(BuildingType buildingType, int totalLandCount) {
		int buildingHave = buildings.get(buildingType).getHave();
		
		if (totalLandCount == 0 || buildingHave == 0) {
			return 0;
		}
		
		return (int)((float)buildingHave / totalLandCount * 100);
	}

	public int storageCapcityForResource(ResourceType resourceType) {
		int capacity = resourceType.getResourceRuleSet().getStorageCapacity().getCapacity();
		int storageNumber = getBuilding(BuildingType.STORAGE).getHave();

		return capacity * storageNumber;
	}
	
	public Husbandry getHusbandry() {
		return husbandry;
	}
	
	public void build(BuildingType buildingType, int amount) {
		BuildingData buildingData = buildings.get(buildingType);

		buildingData.setInProgress(buildingData.getProductionTime(), amount);
	}

	private void populateBuildings() {
		int priority = 1;

		for (BuildingType buildingType : BuildingType.values()) {
			BuildingData buildingData = new BuildingData(buildingType);

			buildingData.setPriority(priority);
			buildings.put(buildingType, buildingData);

			priority++;
		}
	}

	private void resetBuildingData() {
		buildings.get(BuildingType.YURT).setHave(30);
		buildings.get(BuildingType.GARRISON).setHave(10);
		buildings.get(BuildingType.KAM_HUT).setHave(2);
		buildings.get(BuildingType.PALISADE_WALL).setHave(0);
		buildings.get(BuildingType.GUARD_TOWER).setHave(0);
		buildings.get(BuildingType.MARKET).setHave(5);
		buildings.get(BuildingType.STORAGE).setHave(5);
		buildings.get(BuildingType.TREASURY).setHave(0);
		buildings.get(BuildingType.BLACKSMITH).setHave(1);
		buildings.get(BuildingType.ARROW_MAKER).setHave(0);
		buildings.get(BuildingType.HUSBANDRY).setHave(10);
		husbandry = new Husbandry(getBuilding(BuildingType.HUSBANDRY).getHave());
		buildings.get(BuildingType.LUMBER_CAMP).setHave(1);
		buildings.get(BuildingType.BOG_ORE_MINE).setHave(1);
		buildings.get(BuildingType.CLAY_PIT).setHave(2);
	}
}
