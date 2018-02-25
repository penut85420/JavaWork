package com.DataStructure;

public class DropSet {
	ItemPart mItemPart;
	String mDropRate;
	
	public DropSet(ItemPart itemPart, String dropRate) {
		mItemPart = itemPart;
		mDropRate = dropRate;
	}
	
	public String toString() {
		return mItemPart.getName() + ", 掉落機率 " + mDropRate;
	}
	
	public String getItemPartName() {
		return mItemPart.getName();
	}
	
	public String getDropRate() {
		return mDropRate;
	}
}
