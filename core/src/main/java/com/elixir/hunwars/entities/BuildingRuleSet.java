package com.elixir.hunwars.entities;

public class BuildingRuleSet {
	private final String name;
	private final int capacity;
	private final LandType landType;

	public BuildingRuleSet(String name, int capacity, LandType landType) {
		this.name = name;
		this.capacity = capacity;
		this.landType = landType;
	}

	public String getName() {
		return name;
	}

	public int getCapacity() {
		return capacity;
	}
	
	public LandType getLandType() {
		return landType;
	}
}
