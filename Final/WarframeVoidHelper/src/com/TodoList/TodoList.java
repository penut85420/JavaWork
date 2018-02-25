package com.TodoList;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import com.Func;
import com.DataStructure.*;

public class TodoList {
	JPanel mPanel;
	TodoListAddManager mTodoListAddManager;
	TodoListData mTodoListData;
	JList<String> mItemSetList;
	
	public TodoList(JPanel panel, DataStructure dataStructure) {
		mPanel = panel;
		mTodoListData = new TodoListData();
		mItemSetList = new JList<String>(new ItemSetListModel(mTodoListData));
		
		mPanel.setLayout(new GridBagLayout());

		mTodoListAddManager = new TodoListAddManager(dataStructure, mTodoListData, mItemSetList);
		
		makeGUI();
	}
	
	private void makeGUI() {
		JButton mAdd = new JButton("新增");
		JButton mDelete = new JButton("刪除");
		JTable mItemPartTable = new JTable(new TodoListTableModel(mTodoListData));
		JScrollPane mTableScrollPane = new JScrollPane(mItemPartTable);
		JScrollPane mListScrollPane = new JScrollPane(mItemSetList);
		
		mAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mTodoListAddManager.show();
			}
		});
		
		mPanel.add(mListScrollPane, Func.makeGrid(0, 0, 10, 100, 10, 100));
		mPanel.add(mAdd, 			Func.makeGrid(0, 100, 1, 1, 5, 1));
		mPanel.add(mDelete, 		Func.makeGrid(5, 100, 1, 1, 5, 1));
		mPanel.add(mTableScrollPane,Func.makeGrid(10, 0, 40, 101, 40, 101));
	}

}

// TODO
// 		Fire table change
//		Check must work