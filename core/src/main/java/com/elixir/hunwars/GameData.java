package com.elixir.hunwars;

public class GameData {
	private int land;
	private int population;
	private int silver;
	
	public GameData() {
		resetGameData();
	}

	public int getLand() {
		return land;
	}

	public int getPopulation() {
		return population;
	}

	public int getSilver() {
		return silver;
	}

	private void resetGameData() {
		land = 100;
		population = 1000;
		silver = 500;
	}
}
