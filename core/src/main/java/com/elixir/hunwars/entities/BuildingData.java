package com.elixir.hunwars.entities;

public class BuildingData {
	private final BuildingType type;
	private final String name;
	private int have;
	private int priority;

	public BuildingData(BuildingType type, String name) {
		this.type = type;
		this.name = name;
	}
	
	public BuildingType getType() {
		return type;
	}
	
	public String getName() {
		return name;
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
