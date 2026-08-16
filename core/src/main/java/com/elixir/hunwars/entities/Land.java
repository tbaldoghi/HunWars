package com.elixir.hunwars.entities;

import java.util.Iterator;
import java.util.LinkedHashMap;

public class Land {
	private LinkedHashMap<LandType, LandData> lands = new LinkedHashMap<>();
	
	public Land() {
		populateLands();
		resetLandData();
	}
	
	public int getTotalLandCount() {
		int counter = 0;
		
		for (LandType landType : lands.keySet()) {
			counter += lands.get(landType).getHave();
		}
		
		return counter;
	}
	
	public int getLandCount(LandType landType) {
		return lands.get(landType).getHave();
	}
	
	private void populateLands() {
		for (LandType landType : LandType.values()) {
			LandData land = new LandData(landType);

			lands.put(landType, land);
		}
	}
	
	private void resetLandData() {
		lands.get(LandType.FOREST).setHave(10);
		lands.get(LandType.MARSH).setHave(10);
		lands.get(LandType.RIVER).setHave(10);
		lands.get(LandType.WILDERNESS).setHave(40);
		lands.get(LandType.FIELD).setHave(40);
	}
}
