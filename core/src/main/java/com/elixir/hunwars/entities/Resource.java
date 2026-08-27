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

	public int woodProduction(Building building) {
		return mineProduction(building, BuildingType.LUMBER_CAMP, ResourceType.WOOD);
	}
	
	public int bogIronProduction(Building building) {
		return mineProduction(building, BuildingType.BOG_ORE_MINE, ResourceType.BOG_IRON);
	}
	
	public int clayProduction(Building building) {
		return mineProduction(building, BuildingType.CLAY_PIT, ResourceType.CLAY);
	}
	
	public int weaponProduction(Building building) {
		return craftProduction(building, BuildingType.BLACKSMITH, ResourceType.BOG_IRON, ResourceType.WEAPON);
	}
	
	public int arrowProduction(Building building) {
		return craftProduction(building, BuildingType.ARROW_MAKER, ResourceType.WOOD, ResourceType.ARROW);
	}
	
	public int goodsProduction(Building building) {
		return craftProduction(building, BuildingType.POTTER, ResourceType.CLAY, ResourceType.GOODS);
	}

	public int foodProduction(Herd herd, Building building) {
		int cattleHave = herd.getHerd(HerdType.CATTLE).getHave();
		int sheepHave = herd.getHerd(HerdType.SHEEP).getHave();
		// TODO: Horse, too?
		int arableLandHave = building.getHusbandry().getArableLand();
		int production = ResourceType.FOOD.getResourceRuleSet().getProduction();

		return arableLandHave * production + cattleHave * HerdType.CATTLE.getHerdRuleSet().getFoodProduction() + sheepHave * HerdType.SHEEP.getHerdRuleSet().getFoodProduction();
	}
	
	public int getResourceProduction(ResourceType resourceType, Herd herd, Building building) {
		switch (resourceType) {
		case HIDE:
			return hideProduction(herd);
		case WOOL:
			return woolProduction(herd);
		case WOOD:
			return woodProduction(building);
		case BOG_IRON:
			return bogIronProduction(building);
		case CLAY:
			return clayProduction(building);
		case WEAPON:
			return weaponProduction(building);
		case ARROW:
			return arrowProduction(building);
		case FOOD:
			return foodProduction(herd, building);
		case GOODS:
			return goodsProduction(building);
		default:
			break;
		}

		return 0;
	}
	
	private int mineProduction(Building building, BuildingType buildingType, ResourceType resourceType) {
		int buildingHave = building.getBuilding(buildingType).getHave();

		return buildingHave * resourceType.getResourceRuleSet().getProduction();
	}

	private int craftProduction(Building building, BuildingType buildingType, ResourceType inResourceType, ResourceType outResourceType) {
		int buildingHave = building.getBuilding(buildingType).getHave();
		int inResourceHave = resources.get(inResourceType).getHave();

		if (buildingHave == 0) {
			return 0;
		}

		int production = buildingHave * outResourceType.getResourceRuleSet().getProduction();

		while (production > 0) {
			if ((float)inResourceHave / production >= 1) {
				return production;
			}

			production--;
		}

		return production;
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
