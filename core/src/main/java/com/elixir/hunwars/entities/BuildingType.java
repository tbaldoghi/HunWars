package com.elixir.hunwars.entities;

public enum BuildingType {
	YURT(new BuildingRuleSet("Yurt", 10, LandType.FIELD)),
	GARRISON(new BuildingRuleSet("Garrison", 50, LandType.FIELD)),
	KAM_HUT(new BuildingRuleSet("Kam's hut", 50, LandType.FIELD)),
	PALISADE_WALL(new BuildingRuleSet("Palisade wall", 10, LandType.FIELD)),
	GUARD_TOWER(new BuildingRuleSet("Guard tower", 50, LandType.FIELD)),
	MARKET(new BuildingRuleSet("Market", 200, LandType.FIELD)),
	STORAGE(new BuildingRuleSet("Storage", 50, LandType.FIELD)),
	TREASURY(new BuildingRuleSet("Treasury", 50, LandType.FIELD)),
	BLACKSMITH(new BuildingRuleSet("Blacksmith", 50, LandType.FIELD)),
	ARROW_MAKER(new BuildingRuleSet("Arrow maker", 50, LandType.FIELD)),
	POTTER(new BuildingRuleSet("Potter", 50, LandType.FIELD)),
	HUSBANDRY(new BuildingRuleSet("Husbandry", 50, LandType.FIELD)),
	LUMBER_CAMP(new BuildingRuleSet("Lumber camp", 50, LandType.FOREST)),
	BOG_ORE_MINE(new BuildingRuleSet("Bog ore mine", 50, LandType.MARSH)),
	CLAY_PIT(new BuildingRuleSet("Clay pit", 50, LandType.RIVER));

	private final BuildingRuleSet buildingRuleSet;

	BuildingType(BuildingRuleSet buildingRuleSet) {
		this.buildingRuleSet = buildingRuleSet;
	}

	public BuildingRuleSet getBuildingRuleSet() {
		return buildingRuleSet;
	}
}
