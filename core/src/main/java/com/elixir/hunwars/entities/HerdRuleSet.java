package com.elixir.hunwars.entities;

public class HerdRuleSet {
	private final String name;
	private final int foodProduction;
	
	public HerdRuleSet(String name, int foodProduction) {
		this.name = name;
		this.foodProduction = foodProduction;
	}

	public String getName() {
		return name;
	}

	public int getFoodProduction() {
		return foodProduction;
	}
}
