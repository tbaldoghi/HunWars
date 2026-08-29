package com.elixir.hunwars.entities;

public class BuildingRuleSet {
	private final String name;
	private final int capacity;
	private final LandType landType;
	private final int productionTime;

	public BuildingRuleSet(String name, int capacity, LandType landType, int productionTime) {
		this.name = name;
		this.capacity = capacity;
		this.landType = landType;
		this.productionTime = productionTime;
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

	public int getProductionTime() {
		return productionTime;
	}
}
