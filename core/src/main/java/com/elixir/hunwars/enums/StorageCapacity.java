package com.elixir.hunwars.enums;

public enum StorageCapacity {
	MISCELLANEOUS(300),
	WEAPON(150),
	FOOD(1000),
	MONEY(-1);

	private int capacity;
	
	private StorageCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public int getCapacity() {
		return capacity;
	}
}
