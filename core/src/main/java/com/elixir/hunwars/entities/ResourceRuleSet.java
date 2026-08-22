package com.elixir.hunwars.entities;

import com.elixir.hunwars.enums.StorageCapacity;
import com.elixir.hunwars.enums.StorageType;

public class ResourceRuleSet {
	private final String name;
	private final StorageType storageType;
	private final StorageCapacity storageCapacity;
	
	public ResourceRuleSet(String name, StorageType storageType, StorageCapacity storageCapacity) {
		this.name = name;
		this.storageType = storageType;
		this.storageCapacity = storageCapacity;
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
}
