package com.RelicMission;

import javax.swing.table.*;

public class RelicMissionTableModel extends AbstractTableModel {
	String[] sColName = {"星球", "關卡"};
	@Override
	public int getColumnCount() {
		return sColName.length;
	}

	@Override
	public String getColumnName(int col) {
		return sColName[col];
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		return null;
	}

}
