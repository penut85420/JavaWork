package com.DataStructure;

import java.util.*;

public class ItemSet {
	String mName;
	ArrayList<ItemPart> mItemPartList;
	
	public ItemSet(String name) {
		mItemPartList = new ArrayList<ItemPart>();
		mName = name;
	}
	
	public String getName() {
		return mName;
	}
	
	public int getSetTotal() {
		return mItemPartList.size();
	}
	
	public String getItemPartName(int i) {
		return mItemPartList.get(i).getName();
	}
	
	public void add(ItemPart itemPart) {
		mItemPartList.add(itemPart);
	}
	
	public String toString() {
		String s = mName + " {\n";
		for (ItemPart ip: mItemPartList) 
			s += "  " + ip.getName() + "\n";
		return s + "}";
	}
}
