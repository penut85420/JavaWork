package com.DataStructure;

import java.util.*;

public class ItemPart implements Comparable<ItemPart> {
	String mName;
	ArrayList<VoidRelic> mDropRelicList;
	
	public ItemPart(String name) {
		mName = name;
	}
	
	public void addDropRelic(VoidRelic relic) {
		mDropRelicList.add(relic);
	}
	
	public String getName() {
		return mName;
	}
	
	public boolean equals(String s) {
		return mName.equals(s);
	}

	public int compareTo(ItemPart ip) {
		return this.mName.compareTo(ip.mName);
	}
}
