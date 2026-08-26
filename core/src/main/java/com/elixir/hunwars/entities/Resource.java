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
	
	public int hideProduction(Herd herd) {
		int cattleHave = herd.getHerd(HerdType.CATTLE).getHave();
		// TODO: Horse, too?
		return cattleHave * ResourceType.HIDE.getResourceRuleSet().getProduction();
	}
	
	public int woolProduction(Herd herd) {
		int sheepHave = herd.getHerd(HerdType.SHEEP).getHave();

		return sheepHave * ResourceType.WOOL.getResourceRuleSet().getProduction();
	}
	
	public int mineProduction(Building building, BuildingType buildingType, ResourceType resourceType) {
		int buildingHave = building.getBuilding(buildingType).getHave();

		return buildingHave * resourceType.getResourceRuleSet().getProduction();
	}

	public int craftProduction(Building building, BuildingType buildingType, ResourceType inResourceType, ResourceType outResourceType) {
		int buildingHave = building.getBuilding(buildingType).getHave();
		int inResourceHave = resources.get(inResourceType).getHave();
		int production = 0;

		if (buildingHave == 0) {
			return production;
		}

		while (buildingHave != 0) {
			production = buildingHave * outResourceType.getResourceRuleSet().getProduction();

			if (inResourceHave / production >= 1) {
				return production;
			}

			buildingHave--;
		}

		return production;
	}
	
	public int foodProduction() {
		return 10;
	}

	public void resourceProduction(Herd herd, Building building) {
		resources.get(ResourceType.HIDE).increaseHave(hideProduction(herd));
		resources.get(ResourceType.WOOD).increaseHave(mineProduction(building, BuildingType.LUMBER_CAMP, ResourceType.WOOD));
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
