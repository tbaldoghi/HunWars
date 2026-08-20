package com.elixir.hunwars;

import com.elixir.hunwars.entities.Building;
import com.elixir.hunwars.entities.BuildingData;
import com.elixir.hunwars.entities.BuildingType;
import com.elixir.hunwars.entities.Herd;
import com.elixir.hunwars.entities.Land;
import com.elixir.hunwars.entities.Population;
import com.elixir.hunwars.entities.Resource;

public class Side {
	private int silver;
	private boolean isHumanPlayer = true;
	private Building building;
	private Land land;
	private Resource resource;
	private Herd herd;
	private Population population;
	
	public Side() {
		resetGameData();
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

	public Resource getResource() {
		return resource;
	}
	
	public Herd getHerd() {
		return herd;
	}

	public Population getPopulation() {
		return population;
	}

	private void resetGameData() {
		silver = 500;
		building = new Building();
		land = new Land();
		resource = new Resource();
		herd = new Herd();
		population = new Population();
	}
}
