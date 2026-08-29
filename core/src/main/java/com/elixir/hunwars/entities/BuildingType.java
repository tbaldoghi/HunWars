package com.elixir.hunwars.entities;

public enum BuildingType {
	YURT(new BuildingRuleSet("Yurt", 10, LandType.FIELD, 6)),
	GARRISON(new BuildingRuleSet("Garrison", 50, LandType.FIELD, 6)),
	KAM_HUT(new BuildingRuleSet("Kam's hut", 50, LandType.FIELD, 6)),
	PALISADE_WALL(new BuildingRuleSet("Palisade wall", 10, LandType.FIELD, 6)),
	GUARD_TOWER(new BuildingRuleSet("Guard tower", 50, LandType.FIELD, 6)),
	MARKET(new BuildingRuleSet("Market", 200, LandType.FIELD, 6)),
	STORAGE(new BuildingRuleSet("Storage", 50, LandType.FIELD, 6)),
	TREASURY(new BuildingRuleSet("Treasury", 50, LandType.FIELD, 6)),
	BLACKSMITH(new BuildingRuleSet("Blacksmith", 50, LandType.FIELD, 6)),
	ARROW_MAKER(new BuildingRuleSet("Arrow maker", 50, LandType.FIELD, 6)),
	POTTER(new BuildingRuleSet("Potter", 50, LandType.FIELD, 6)),
	HUSBANDRY(new BuildingRuleSet("Husbandry", 50, LandType.FIELD, 6)),
	LUMBER_CAMP(new BuildingRuleSet("Lumber camp", 50, LandType.FOREST, 6)),
	BOG_ORE_MINE(new BuildingRuleSet("Bog ore mine", 50, LandType.MARSH, 6)),
	CLAY_PIT(new BuildingRuleSet("Clay pit", 50, LandType.RIVER, 6));

	private final BuildingRuleSet buildingRuleSet;

	BuildingType(BuildingRuleSet buildingRuleSet) {
		this.buildingRuleSet = buildingRuleSet;
	}

	public BuildingRuleSet getBuildingRuleSet() {
		return buildingRuleSet;
	}
}
