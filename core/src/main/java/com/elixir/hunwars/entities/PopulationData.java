package com.elixir.hunwars.entities;

public class PopulationData {
	private final PopulationType type;
	private int have;

	public PopulationData(PopulationType type) {
		this.type = type;
	}

	public int getHave() {
		return have;
	}

	public void setHave(int have) {
		this.have = have;
	}
}
