package com.elixir.hunwars.entities;

import com.elixir.hunwars.enums.StorageCapacity;
import com.elixir.hunwars.enums.StorageType;

public enum ResourceType {
	HIDE(new ResourceRuleSet("Hide", StorageType.STORAGE, StorageCapacity.MISCELLANEOUS, 2)),
	WOOL(new ResourceRuleSet("Wool", StorageType.STORAGE, StorageCapacity.MISCELLANEOUS, 3)),
	WOOD(new ResourceRuleSet("Wood", StorageType.STORAGE, StorageCapacity.MISCELLANEOUS, 8)),
	BOG_IRON(new ResourceRuleSet("Bog iron", StorageType.STORAGE, StorageCapacity.MISCELLANEOUS, 8)),
	CLAY(new ResourceRuleSet("Clay", StorageType.STORAGE, StorageCapacity.MISCELLANEOUS, 8)),
	WEAPON(new ResourceRuleSet("Weapon", StorageType.STORAGE, StorageCapacity.WEAPON, 3)),
	ARROW(new ResourceRuleSet("Arrow", StorageType.STORAGE, StorageCapacity.WEAPON, 3)),
	FOOD(new ResourceRuleSet("Food", StorageType.STORAGE, StorageCapacity.FOOD, 5)),
	GOODS(new ResourceRuleSet("Goods", StorageType.STORAGE, StorageCapacity.MISCELLANEOUS, 3)),
	SILVER(new ResourceRuleSet("Silver", StorageType.MONEY, StorageCapacity.MONEY, 1));

	private final ResourceRuleSet resourceRuleSet;

	ResourceType(ResourceRuleSet resourceRuleSet) {
		this.resourceRuleSet = resourceRuleSet;
	}

	public ResourceRuleSet getResourceRuleSet() {
		return resourceRuleSet;
	}
}
