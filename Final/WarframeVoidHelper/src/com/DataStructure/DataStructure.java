package com.DataStructure;

import java.io.*;
import java.util.*;
import com.Func;

public class DataStructure {
	public ArrayList<VoidRelic> mVoidRelicList;
	public ArrayList<ItemPart> mItemPartList;
	public ArrayList<ItemSet> mItemSetList;
	public ArrayList<Planet> mPlanetList;
	
	public DataStructure() {
		mVoidRelicList = new ArrayList<VoidRelic>();
		mItemPartList = new ArrayList<ItemPart>();
		mItemSetList = new ArrayList<ItemSet>();
		mPlanetList = new ArrayList<Planet>();
		
		loadVoidRelic();
		loadItemSet();
		loadRelicMission();
	}
	
	public String[] getItemSetStringList() {
		String[] s = new String[mItemSetList.size()];
		
		for (int i = 0; i < mItemSetList.size(); i++)
			s[i] = mItemSetList.get(i).getName();
		
		return s;
	}
	
	private void loadVoidRelic() {
		String[] sVoidRelic = Func.getFileToString(new File("Data\\VoidRelic.txt")).split("[\t\n]");
		
		for (int i = 0; i + 3 < sVoidRelic.length; i += 4) {
			String era = sVoidRelic[i];
			String name = sVoidRelic[i + 1];
			String itemPartName = sVoidRelic[i + 2];
			String dropRate = sVoidRelic[i + 3];
			
			VoidRelic tVoidRelic = getVoidRelic(era, name);
			ItemPart tItemPart = getItemPart(itemPartName);
			DropSet tDropSet = new DropSet(tItemPart, dropRate);
			tVoidRelic.addDrop(tDropSet);
		}
		
		Collections.sort(mVoidRelicList);
		Collections.sort(mItemPartList);
	}
	
	private void loadItemSet() {
		String[] sItemSet = Func.getFileToString(new File("Data\\ItemSet.txt")).split("\r\n\r\n");
		
		for (int i = 0; i < sItemSet.length; i++) {
			String[] t = sItemSet[i].split("\r\n");
			
			String sItemSetName = t[0].split("\t")[0];
			
			ItemSet tItemSet = new ItemSet(sItemSetName);
			for (int j = 1; j < t.length; j++)
				tItemSet.add(getItemPart(t[j]));
			
			mItemSetList.add(tItemSet);
		}
	}
	
	private void loadRelicMission() {
		String[] sRelicMission = Func.getFileToString(new File("Data\\RelicMission.txt")).split("\r\n\r\n");
		for (String sPlanet: sRelicMission) {
			String[] sMission = sPlanet.split("\r\n");
			Planet tPlanet = new Planet(sMission[0]);
			for (int i = 1; i < sMission.length; i++) {
				String[] ss = sMission[i].split("\t");
				tPlanet.addMission(ss[0], ss[1]);
			}
			mPlanetList.add(tPlanet);
		}
		for (Planet p: mPlanetList)
			System.out.println(p);
	}
	
	private VoidRelic getVoidRelic(String era, String name) {
		for (VoidRelic vr: mVoidRelicList)
			if (vr.equals(era, name))
				return vr;
		
		VoidRelic vr = new VoidRelic(era, name);
		mVoidRelicList.add(vr);
		
		return vr;
	}
	
	private ItemPart getItemPart(String itemPartName) {
		for (ItemPart ip: mItemPartList)
			if (ip.equals(itemPartName))
				return ip;
		
		ItemPart ip = new ItemPart(itemPartName);
		mItemPartList.add(ip);
 
		return ip;
	}
	
	public ItemSet getItemSet(String itemSetName) {
		for (ItemSet is: mItemSetList)
			if (is.getName().equals(itemSetName))
				return is;
		return null;
	}
}
