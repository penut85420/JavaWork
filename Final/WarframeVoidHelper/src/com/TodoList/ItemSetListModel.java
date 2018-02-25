package com.TodoList;

import javax.swing.AbstractListModel;

public class ItemSetListModel extends AbstractListModel<String> {
	TodoListData mTodoListData;
	
	public ItemSetListModel(TodoListData todoListData) {
		mTodoListData = todoListData;
	}
	
	@Override
	public String getElementAt(int index) {
		return mTodoListData.getName(index);
	}

	@Override
	public int getSize() {
		return mTodoListData.size();
	}
}
