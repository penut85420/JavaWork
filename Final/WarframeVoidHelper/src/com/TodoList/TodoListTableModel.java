package com.TodoList;

import javax.swing.table.*;

public class TodoListTableModel extends AbstractTableModel {
	String[] sColName = {"已擁有", "部件名稱", "掉落遺物", "掉落機率"};
	TodoListData mTodoListData;
	
	public TodoListTableModel(TodoListData todoListData) {
		mTodoListData = todoListData;
	}
	
	@Override
	public int getColumnCount() {
		return sColName.length;
	}
	
	public String getColumnName(int col) {
		return sColName[col];
	}
	
	@Override
	public Class<?> getColumnClass(int col) {
		if (col == 0) return boolean.class;
		return String.class;
	}

	@Override
	public int getRowCount() {
		return mTodoListData.getSize(0);
	}

	@Override
	public Object getValueAt(int row, int col) {
		System.out.println(mTodoListData.mTodoListCheck.get(0)[row]);
		if (col == 0) return mTodoListData.mTodoListCheck.get(0)[row];
		if (col == 1) return mTodoListData.mTodoList.get(0).getItemPartName(row);
		return null;
	}

	@Override
	public boolean isCellEditable(int row, int col) {
		return true;
	}
}
