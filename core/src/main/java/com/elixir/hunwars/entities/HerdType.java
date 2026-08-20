package com.elixir.hunwars.entities;

public enum HerdType {
	CATTLE(new HerdRuleSet("Cattle")),
	SHEEP(new HerdRuleSet("Sheep")),
	HORSE(new HerdRuleSet("Horse"));
	
	private final HerdRuleSet herdRuleSet;
	
	HerdType(HerdRuleSet herdRuleSet) {
		this.herdRuleSet = herdRuleSet;
	}
	
	public HerdRuleSet getHerdRuleSet() {
		return herdRuleSet;
	}
}
