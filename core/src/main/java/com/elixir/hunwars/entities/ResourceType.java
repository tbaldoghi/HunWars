package com.elixir.hunwars.entities;

import com.elixir.hunwars.enums.StorageCapacity;
import com.elixir.hunwars.enums.StorageType;

public enum ResourceType {
	HIDE(new ResourceRuleSet("Hide", StorageType.STORAGE, StorageCapacity.MISCELLANEOUS)),
	WOOL(new ResourceRuleSet("Wool", StorageType.STORAGE, StorageCapacity.MISCELLANEOUS)),
	WOOD(new ResourceRuleSet("Wood", StorageType.STORAGE, StorageCapacity.MISCELLANEOUS)),
	BOG_IRON(new ResourceRuleSet("Bog iron", StorageType.STORAGE, StorageCapacity.MISCELLANEOUS)),
	CLAY(new ResourceRuleSet("Clay", StorageType.STORAGE, StorageCapacity.MISCELLANEOUS)),
	WEAPON(new ResourceRuleSet("Weapon", StorageType.STORAGE, StorageCapacity.WEAPON)),
	ARROW(new ResourceRuleSet("Arrow", StorageType.STORAGE, StorageCapacity.WEAPON)),
	FOOD(new ResourceRuleSet("Food", StorageType.STORAGE, StorageCapacity.FOOD)),
	GOODS(new ResourceRuleSet("Goods", StorageType.STORAGE, StorageCapacity.MISCELLANEOUS)),
	SILVER(new ResourceRuleSet("Silver", StorageType.MONEY, StorageCapacity.MONEY));

	private final ResourceRuleSet resourceRuleSet;

	ResourceType(ResourceRuleSet resourceRuleSet) {
		this.resourceRuleSet = resourceRuleSet;
	}

	public ResourceRuleSet getResourceRuleSet() {
		return resourceRuleSet;
	}
}
