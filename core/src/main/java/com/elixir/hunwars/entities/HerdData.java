package com.elixir.hunwars.entities;

public class HerdData {
	private final HerdType type;
	private final String name;
	private int have;
	
	public HerdData(HerdType type) {
		this.type = type;
		this.name = type.getHerdRuleSet().getName();
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
}
