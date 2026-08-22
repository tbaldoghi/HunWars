package com.elixir.hunwars.enums;

public enum GameViewType {
	OVERVIEW("Overview"),
	RELIGION("Religion"),
	MAP("Map"),
	AGRICULTURE("Agriculture"),
	BUILDINGS("Buildings"),
	WORKERS("Workers"),
	ARMIES("Armies"),
	TRADE("Trade"),
	DIPLOMACY("Diplomacy"),
	WAR("War"),
	STORAGE("Storage"),
	FOOD("Food");
	
	private String name;
	
	GameViewType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
