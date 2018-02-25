package com.RelicViewer;

import java.util.Comparator;

public class DropRateComparator implements Comparator {
	@Override
	public int compare(Object o1, Object o2) {
		String s1 = o1.toString(), s2 = o2.toString();
		int i1 = valueOfDropRate(s1), i2 = valueOfDropRate(s2) ;
		return Integer.valueOf(i1).compareTo(Integer.valueOf(i2));
	}
	
	public int valueOfDropRate(String s) {
		if (s.contains("高")) return 3;
		else if (s.contains("中")) return 2;
		else return 1;
	}
}
