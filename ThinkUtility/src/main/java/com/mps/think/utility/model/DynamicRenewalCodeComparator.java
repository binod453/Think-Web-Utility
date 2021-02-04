package com.mps.think.utility.model;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import com.mps.think.utility.model.paging.Direction;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

public class DynamicRenewalCodeComparator {
	@EqualsAndHashCode
	@AllArgsConstructor
	@Getter
	static class Key {
		String name;
		Direction dir;
	}

	static Map<Key, Comparator<DynamicRenewalCodeModel>> map = new HashMap<>();

	static {
		map.put(new Key("slNo", Direction.asc), Comparator.comparing(DynamicRenewalCodeModel::getSlNo));
		map.put(new Key("slNo", Direction.desc), Comparator.comparing(DynamicRenewalCodeModel::getSlNo).reversed());
		
		map.put(new Key("dynamicCode", Direction.asc), Comparator.comparing(DynamicRenewalCodeModel::getDynamicCode));
		map.put(new Key("dynamicCode", Direction.desc), Comparator.comparing(DynamicRenewalCodeModel::getDynamicCode).reversed());

		map.put(new Key("description", Direction.asc), Comparator.comparing(DynamicRenewalCodeModel::getDescription));
		map.put(new Key("description", Direction.desc), Comparator.comparing(DynamicRenewalCodeModel::getDescription).reversed());

		map.put(new Key("offerType", Direction.asc), Comparator.comparing(DynamicRenewalCodeModel::getOfferType));
		map.put(new Key("offerType", Direction.desc), Comparator.comparing(DynamicRenewalCodeModel::getOfferType).reversed());

		map.put(new Key("activeFrom", Direction.asc), Comparator.comparing(DynamicRenewalCodeModel::getActiveFrom));
		map.put(new Key("activeFrom", Direction.desc), Comparator.comparing(DynamicRenewalCodeModel::getActiveFrom).reversed());

		map.put(new Key("activeTo", Direction.asc), Comparator.comparing(DynamicRenewalCodeModel::getActiveTo));
		map.put(new Key("activeTo", Direction.desc), Comparator.comparing(DynamicRenewalCodeModel::getActiveTo).reversed());
	}

	public static Comparator<DynamicRenewalCodeModel> getComparator(String name, Direction dir) {
		return map.get(new Key(name, dir));
	}

	private DynamicRenewalCodeComparator() {
	    }
}
