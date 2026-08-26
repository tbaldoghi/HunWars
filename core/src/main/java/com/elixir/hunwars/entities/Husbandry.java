package com.elixir.hunwars.entities;

public class Husbandry {
	private int husbandry;
	private int pasture;
	private int arableLand;
	
	public Husbandry(int husbandry) {
		this.setHusbandry(husbandry);
		this.setPasture(husbandry);
		this.setArableLand(0);
	}

	public int getHusbandry() {
		return husbandry;
	}

	public void setHusbandry(int husbandry) {
		this.husbandry = husbandry;
	}

	public int getPasture() {
		return pasture;
	}

	public void setPasture(int value) {
		if (value <= husbandry) {
			this.pasture = value;
			this.arableLand = husbandry - value;
		}
	}

	public int getArableLand() {
		return arableLand;
	}

	public void setArableLand(int value) {
		if (value <= husbandry) {
			this.arableLand = value;
			this.pasture = husbandry - value;
		}
	}
}
