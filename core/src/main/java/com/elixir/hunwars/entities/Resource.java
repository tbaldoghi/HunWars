package com.elixir.hunwars.entities;

import java.util.LinkedHashMap;

public class Resource {
	private LinkedHashMap<ResourceType, ResourceData> resources = new LinkedHashMap<>();
	
	public Resource() {
		populateResources();
	}
	
	private void populateResources() {
		for (ResourceType resourceType : ResourceType.values()) {
			ResourceData resourceData = new ResourceData(resourceType);

			resources.put(resourceType, resourceData);
		}
	}
}
