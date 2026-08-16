package com.elixir.hunwars;

import com.elixir.hunwars.entities.Building;
import com.elixir.hunwars.entities.Land;

public class Side {
	private int population;
	private int silver;
	private boolean isHumanPlayer = true;
	private Building building;
	private Land land;
	
	public Side() {
		resetGameData();
	}

	public int getPopulation() {
		return population;
	}

	public int getSilver() {
		return silver;
	}

	public Building getBuilding() {
		return building;
	}
	
	public Land getLand() {
		return land;
	}
	
	private void resetGameData() {
		population = 1000;
		silver = 500;
		building = new Building();
		land = new Land();
	}
}
