package com.DataStructure;

import java.util.*;

public class Planet {
	String mPlanetName;
	ArrayList<Mission> mMissionList;
	
	public Planet(String planetName) {
		mMissionList = new ArrayList<Mission>();
		mPlanetName = planetName;
	}
	
	public void addMission(String name, String type) {
		mMissionList.add(new Mission(name, type));
	}
	
	public String toString() {
		String s = mPlanetName + " {\n";
		
		for (Mission m: mMissionList)
			s += "  " + m.toString() + "\n";
		
		return s + "}\n";
	}
	
	class Mission {
		String mMissionName;
		String mMissionType;
		
		public Mission(String name, String type) {
			mMissionName = name;
			mMissionType = type;
		}
		
		public String toString() {
			return mMissionName + " " + mMissionType;
		}
	}
}
