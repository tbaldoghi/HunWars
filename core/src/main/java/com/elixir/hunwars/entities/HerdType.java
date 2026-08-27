package com.elixir.hunwars.entities;

public enum HerdType {
	CATTLE(new HerdRuleSet("Cattle", 5)),
	SHEEP(new HerdRuleSet("Sheep", 4)),
	HORSE(new HerdRuleSet("Horse", 3));
	
	private final HerdRuleSet herdRuleSet;
	
	HerdType(HerdRuleSet herdRuleSet) {
		this.herdRuleSet = herdRuleSet;
	}
	
	public HerdRuleSet getHerdRuleSet() {
		return herdRuleSet;
	}
}
