package com.RelicMission;

import java.awt.*;
import javax.swing.*;

import com.Func;
import com.DataStructure.DataStructure;

public class RelicMission {
	JPanel mPanel;
	DataStructure mDataStructure;
	
	public RelicMission(JPanel panel, DataStructure dataStruct) {
		mPanel = panel;
		mDataStructure = dataStruct;
		
		panel.setLayout(new GridBagLayout());
		
		makeGUI();
	}
	
	private void makeGUI() {
		JTextField mSearchTarget = new JTextField();
		JButton mSearch = new JButton("搜尋");
		RelicMissionTableModel mRelicMissionTableModel = new RelicMissionTableModel();
		JTable mRelicMissionTable = new JTable(mRelicMissionTableModel);
		JScrollPane mSp = new JScrollPane(mRelicMissionTable);
		
		mPanel.add(mSearchTarget, Func.makeGrid(0, 0, 19, 1, 19, 1));
		mPanel.add(mSearch, Func.makeGrid(19, 0, 1, 1, 1, 1));
		mPanel.add(mSp, Func.makeGrid(0, 1, 20, 100, 20, 100));
	}
}
