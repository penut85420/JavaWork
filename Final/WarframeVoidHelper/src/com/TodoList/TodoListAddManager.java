package com.TodoList;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.Func;
import com.DataStructure.*;

public class TodoListAddManager {
	JFrame mFrame;
	JPanel mPanel;
	DataStructure mDataStructure;
	TodoListData mTodoListData;
	JList<String> mItemSetList;
	
	public TodoListAddManager(DataStructure dataStructure, TodoListData todoListData, JList<String> itemSetList) {
		mDataStructure = dataStructure;
		mTodoListData = todoListData;
		mItemSetList = itemSetList;
		
		mFrame = new JFrame("新增");
		mFrame.setSize(300, 500);
		mFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		mPanel = new JPanel();
		mPanel.setLayout(new GridBagLayout());
		mFrame.add(mPanel);
		
		makeGUI();
	}
	
	public void show() {
		mFrame.setVisible(true);
	}
	
	private void makeGUI() {
		JList<String> mList = new JList<String>(mDataStructure.getItemSetStringList());
		JTextField mSearchTarget = new JTextField();
		JButton mSearch = new JButton("搜尋");
		JScrollPane mScrollPane = new JScrollPane(mList);
		JButton mAdd = new JButton("新增");
		JButton mCancel = new JButton("取消");
		
		mAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ItemSet tItemSet = mDataStructure.getItemSet(mList.getSelectedValue());
				mTodoListData.add(tItemSet);
				mItemSetList.setModel(new ItemSetListModel(mTodoListData));
				mFrame.setVisible(false);
			}
		});
		
		mCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mFrame.setVisible(false);
			}
		});
		
		mPanel.add(mSearchTarget, 	Func.makeGrid(0, 0, 5, 1, 5, 1));
		mPanel.add(mSearch, 		Func.makeGrid(5, 0, 5, 1, 5, 1));
		mPanel.add(mScrollPane, 	Func.makeGrid(0, 1, 10, 50, 10, 50));
		mPanel.add(mAdd, 			Func.makeGrid(0, 51, 5, 1, 5, 1));
		mPanel.add(mCancel, 		Func.makeGrid(5, 51, 5, 1, 5, 1));
	}
}
