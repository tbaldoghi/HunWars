package com.elixir.hunwars.entities;

public enum BuildingType {
	YURT("Yurt"),
	GARRISON("Garrison"),
	KAM_HUT("Kam's hut"),
	PALISADE_WALL("Palisade wall"),
	GUARD_TOWER("Guard tower"),
	MARKET("Market"),
	STORAGE("Storage"),
	TREASURY("Treasury"),
	BLACKSMITH("Blacksmith"),
	ARROW_MAKER("Arrow maker"),
	HUSBANDRY("Husbandry"),
	LUMBER_CAMP("Lumber camp"),
	BOG_ORE_MINE("Bog ore mine"),
	CLAY_PIT("Clay pit");
	
	private String name;

	BuildingType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
