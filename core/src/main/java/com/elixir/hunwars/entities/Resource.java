package com.elixir.hunwars.entities;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.elixir.hunwars.enums.StorageType;

public class Resource {
	private LinkedHashMap<ResourceType, ResourceData> resources = new LinkedHashMap<>();

	public Resource() {
		populateResources();
		resetResourceData();
	}
	
	public ResourceData getResource(ResourceType resourceType) {
		return resources.get(resourceType);
	}
	
	public List<ResourceData> getStorageResources() {
		return new ArrayList<ResourceData>(
			resources
				.values()
				.stream()
				.filter(resource -> resource.getStorageType() == StorageType.STORAGE)
				.toList()
		);
	}

	private void populateResources() {
		for (ResourceType resourceType : ResourceType.values()) {
			ResourceData resourceData = new ResourceData(resourceType);

			resources.put(resourceType, resourceData);
		}
	}

	private void resetResourceData() {
		resources.get(ResourceType.HIDE).setHave(10);
		resources.get(ResourceType.WOOL).setHave(10);
		resources.get(ResourceType.WOOD).setHave(10);
		resources.get(ResourceType.BOG_IRON).setHave(10);
		resources.get(ResourceType.CLAY).setHave(10);
		resources.get(ResourceType.WEAPON).setHave(10);
		resources.get(ResourceType.ARROW).setHave(10);
		resources.get(ResourceType.FOOD).setHave(1000);
		resources.get(ResourceType.GOODS).setHave(10);
		resources.get(ResourceType.SILVER).setHave(10);
	}
}
