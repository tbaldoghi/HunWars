package com.elixir.hunwars.entities;

import com.elixir.hunwars.enums.StorageType;

public class ResourceData {
	private final ResourceType type;
	private final String name;
	private final StorageType storageType;
	private int have;
	
	public ResourceData(ResourceType type) {
		this.type = type;
		this.name = type.getResourceRuleSet().getName();
		this.storageType = type.getResourceRuleSet().getStorageType();
	}
	
	public ResourceType getType() {
		return type;
	}

	public int getHave() {
		return have;
	}

	public void setHave(int have) {
		this.have = have;
	}

	public String getName() {
		return name;
	}

	public StorageType getStorageType() {
		return storageType;
	}
}
