package com.elixir.hunwars.entities;

public class BuildingData {
	private final BuildingType type;
	private final String name;
	private final int capacity;
	private int have;
	private int priority;

	public BuildingData(BuildingType type) {
		this.type = type;
		this.name = type.getBuildingRuleSet().getName();
		this.capacity = type.getBuildingRuleSet().getCapacity();
	}
	
	public BuildingType getType() {
		return type;
	}
	
	public String getName() {
		return name;
	}
	
	public int getCapacity() {
		return capacity;
	}

	public int getHave() {
		return have;
	}

	public void setHave(int have) {
		this.have = have;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}
}
