package com.DataStructure;

import java.util.*;

public class VoidRelic implements Comparable<VoidRelic>  {
	String mEra;
	String mName;
	ArrayList<DropSet> mDropList;
	
	public VoidRelic(String era, String name) {
		mEra = era;
		mName = name;
		mDropList = new ArrayList<DropSet>();
	}
	
	public String getName() {
		return mEra + mName;
	}
	
	public String getItemPartName(int i) {
		return mDropList.get(i).getItemPartName();
	}
	
	public String getItemDropRate(int i) {
		return mDropList.get(i).getDropRate();
	}
	
	public void addDrop(DropSet dropSet) {
		mDropList.add(dropSet);
	}
	
	public boolean equals(String era, String name) {
		return era.equals(mEra) && mName.equals(name);
	}
	
	public String toString() {
		String s = "[" + mEra + " " + mName + "] {\n";
		
		for (DropSet ds: mDropList)
			s += "  " + ds.toString() + "\n";
		
		return s + "}";
	}

	@Override
	public int compareTo(VoidRelic vr) {
		final String[] sEraOrder = {"古紀", "前紀", "中紀", "後紀"};
		
		int i, j;
		
		for (i = 0; i < sEraOrder.length; i++)
			if (this.mEra.equals(sEraOrder[i])) break;
		
		for (j = 0; j < sEraOrder.length; j++)
			if (vr.mEra.equals(sEraOrder[j])) break;
	
		if (i == j) return this.mName.compareTo(vr.mName);
		
		return i - j;
	}
}
