package com.TodoList;

import java.util.*;

import com.DataStructure.*;

public class TodoListData {
	public ArrayList<ItemSet> mTodoList;
	public ArrayList<Boolean[]> mTodoListCheck;
	
	public TodoListData() {
		mTodoList = new ArrayList<ItemSet>();
		mTodoListCheck = new ArrayList<Boolean[]>();
	}
	
	public void add(ItemSet itemSet) {
		mTodoList.add(itemSet);
		Boolean[] tBool = new Boolean[itemSet.getSetTotal()];
		for (int i = 0; i < itemSet.getSetTotal(); i++)
			tBool[i] = Boolean.FALSE;
		mTodoListCheck.add(tBool);
	}
	
	public int getSize(int i) {
		if (i >= mTodoList.size()) return 0;
		return mTodoList.get(i).getSetTotal();
	}
	
	public String getName(int i) {
		return mTodoList.get(i).getName();
	}
	
	public int size() {
		return mTodoList.size();
	}
}
