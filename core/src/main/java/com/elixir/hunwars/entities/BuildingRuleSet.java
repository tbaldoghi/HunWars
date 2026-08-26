package com.elixir.hunwars.entities;

public class BuildingRuleSet {
	private final String name;
	private final int capacity;

	public BuildingRuleSet(String name, int capacity) {
		this.name = name;
		this.capacity = capacity;
	}

	public String getName() {
		return name;
	}

	public int getCapacity() {
		return capacity;
	}
}
