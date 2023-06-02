package com.dev.ramk;

import com.dev.ramk.impls.SimpleMap;
import com.dev.ramk.maps.AltMap;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {

		System.out.println("Alt Map");
		AltMap<Integer, Integer> altMap = new SimpleMap<>();
		System.out.println("Checking is empty: " + altMap.isEmpty());
		altMap.insert(1, 1);
		altMap.insert(2, 1);
		altMap.insert(3, 1);
		System.out.println("Map Size: " + altMap.size());
		System.out.println("Map Print: " + altMap.print());
		altMap.remove(2);
		System.out.println("Map Print: " + altMap.print());
		altMap.remove(3);
		System.out.println("Map Print: " + altMap.print());
		altMap.insert(4, 1);
		System.out.println("Map Print: " + altMap.print());
		altMap.insert(2, 1);
		altMap.insert(3, 1);
		System.out.println("Map Print: " + altMap.print());
		System.out.println("Checking if key 2 is present: " + altMap.containsKey(2));
		System.out.println("Checking if key 5 is present: " + altMap.containsKey(5));
		altMap.insert(5, 1);
		System.out.println("Map Print: " + altMap.print());
		altMap.removeAll(Arrays.asList(2, 4, 3));
		System.out.println("Map Print: " + altMap.print());
		altMap.remove(1);
		System.out.println("Map Print: " + altMap.print());
		altMap.insert(4, 1);
		altMap.insert(1, 1);
		altMap.insert(2, 1);
		altMap.insert(3, 1);
		System.out.println("Map Print: " + altMap.print());
		System.out.println("Value of 1: " + altMap.get(1));
		altMap.insert(1, 2);
		System.out.println("Value of 1 after update: " + altMap.get(1));
		System.out.println("Map Print: " + altMap.print());
		System.out.println("Entry print: " + altMap.getEntry(4).toString());
	}
}