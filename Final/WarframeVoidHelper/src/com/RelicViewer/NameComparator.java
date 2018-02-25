package com.RelicViewer;

import java.util.Comparator;

public class NameComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		String s1 = o1.toString(), s2 = o2.toString();
		if (valueOfRelicName(s1) == valueOfRelicName(s2)) {
			return s1.substring(3).compareTo(s2.substring(3));
		} else {
			return Integer.valueOf(valueOfRelicName(s1)).compareTo(Integer.valueOf(valueOfRelicName(s2)));
		}
		
	}
	public int valueOfRelicName(String s) {
		if (s.contains("古")) return 1;
		else if (s.contains("前")) return 2;
		else if (s.contains("中")) return 3;
		else return 4;
	}		
}
