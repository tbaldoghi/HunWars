package com.elixir.hunwars.entities;

public enum BuildingType {
	YURT(new BuildingRuleSet("Yurt", 10)),
	GARRISON(new BuildingRuleSet("Garrison", 50)),
	KAM_HUT(new BuildingRuleSet("Kam's hut", 50)),
	PALISADE_WALL(new BuildingRuleSet("Palisade wall", 10)),
	GUARD_TOWER(new BuildingRuleSet("Guard tower", 50)),
	MARKET(new BuildingRuleSet("Market", 200)),
	STORAGE(new BuildingRuleSet("Storage", 50)),
	TREASURY(new BuildingRuleSet("Treasury", 50)),
	BLACKSMITH(new BuildingRuleSet("Blacksmith", 50)),
	ARROW_MAKER(new BuildingRuleSet("Arrow maker", 50)),
	HUSBANDRY(new BuildingRuleSet("Husbandry", 50)),
	LUMBER_CAMP(new BuildingRuleSet("Lumber camp", 50)),
	BOG_ORE_MINE(new BuildingRuleSet("Bog ore mine", 50)),
	CLAY_PIT(new BuildingRuleSet("Clay pit", 50));

	private final BuildingRuleSet buildingRuleSet;

	BuildingType(BuildingRuleSet buildingRuleSet) {
		this.buildingRuleSet = buildingRuleSet;
	}

	public BuildingRuleSet getBuildingRuleSet() {
		return buildingRuleSet;
	}
}
