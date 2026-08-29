package com.elixir.hunwars.entities;

public class BuildingData {
	public static final int IN_PROGRESS_COLUMN = 12;
	private final BuildingType type;
	private final String name;
	private final int capacity;
	private final int productionTime;
	private int have;
	private int priority;
	private int[] inProgress = new int[IN_PROGRESS_COLUMN];

	public BuildingData(BuildingType type) {
		this.type = type;
		this.name = type.getBuildingRuleSet().getName();
		this.capacity = type.getBuildingRuleSet().getCapacity();
		this.productionTime = type.getBuildingRuleSet().getProductionTime();
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
	
	public int getProductionTime() {
		return productionTime - 1;
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

	public int[] getInProgress() {
		return inProgress;
	}

	public void setInProgress(int index, int amount) {
		inProgress[index] += amount;
	}
}
