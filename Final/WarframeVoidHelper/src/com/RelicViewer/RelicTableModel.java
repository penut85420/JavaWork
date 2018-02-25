package com.RelicViewer;

import javax.swing.table.*;

import com.DataStructure.*;

public class RelicTableModel extends AbstractTableModel{
	String[] sColName = {"遺物名稱", "掉落部件", "掉落機率"};
	
	DataStructure mDataStructure;
	
	public RelicTableModel(DataStructure dataStructure) {
		mDataStructure = dataStructure;
	}
	
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
		return mDataStructure.mVoidRelicList.size() * 6;
	}

	@Override
	public Object getValueAt(int row, int col) {
		VoidRelic vr = mDataStructure.mVoidRelicList.get(row / 6);
		if (col == 0) {
			return vr.getName();
		} else if (col == 1) {
			return vr.getItemPartName(row % 6);
		} else if (col == 2) {
			return vr.getItemDropRate(row % 6);
		}
		return null;
	}
	
}
