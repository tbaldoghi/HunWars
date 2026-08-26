package com.elixir.hunwars.entities;

import com.elixir.hunwars.enums.StorageCapacity;
import com.elixir.hunwars.enums.StorageType;

public class ResourceRuleSet {
	private final String name;
	private final StorageType storageType;
	private final StorageCapacity storageCapacity;
	private final int production;
	
	public ResourceRuleSet(String name, StorageType storageType, StorageCapacity storageCapacity, int production) {
		this.name = name;
		this.storageType = storageType;
		this.storageCapacity = storageCapacity;
		this.production = production;
	}

	public String getName() {
		return name;
	}
	
	public StorageType getStorageType() {
		return storageType;
	}

	public StorageCapacity getStorageCapacity() {
		return storageCapacity;
	}

	public int getProduction() {
		return production;
	}
}
