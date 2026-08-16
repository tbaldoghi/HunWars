package com.elixir.hunwars.entities;

public class LandData {
	private final LandType type;
	private int have;

	public LandData(LandType type) {
		this.type = type;
	}

	public int getHave() {
		return have;
	}

	public void setHave(int have) {
		this.have = have;
	}
}
