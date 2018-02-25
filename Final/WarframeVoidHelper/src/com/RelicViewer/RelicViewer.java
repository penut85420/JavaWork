package com.RelicViewer;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.*;

import com.Func;
import com.DataStructure.DataStructure;

public class RelicViewer {
	private JPanel mPanel;
	private DataStructure mDataStructure;
	
	private final String[] sSearchType = {"遺物", "部件名稱"};
	private JTextField mSearchTarget;
	private JComboBox<String> mSearchType;
	private JButton mSearch;
	private TableModel mTableModel;
	private JTable mRelicTable;
	private TableRowSorter<TableModel> mSorter;
	private JScrollPane mScrollPane;
	
	public RelicViewer(JPanel panel, DataStructure dataStructure) {
		mPanel = panel;
		mDataStructure = dataStructure;
		
		mPanel.setLayout(new GridBagLayout());
		
		makeGUI();
	}
	
	private void makeGUI() {
		mSearchTarget = new JTextField();
		mSearchType = new JComboBox<String>(sSearchType);
		mSearch = new JButton("搜尋");
		mTableModel = new RelicTableModel(mDataStructure);
		mRelicTable = new JTable(mTableModel);
		mSorter = new TableRowSorter<TableModel>(mTableModel);
		mScrollPane = new JScrollPane(mRelicTable);
		
		mSearchTarget.addActionListener(new SearchListener());
		mSearch.addActionListener(new SearchListener());
		mSorter.setComparator(0, new NameComparator());
		mSorter.setComparator(2, new DropRateComparator());
		mRelicTable.setRowSorter(mSorter);
		
		mPanel.add(mSearchTarget, 	Func.makeGrid(0, 0, 7, 1, 7, 1));
		mPanel.add(mSearchType, 	Func.makeGrid(7, 0, 2, 1, 2, 1));
		mPanel.add(mSearch, 		Func.makeGrid(9, 0, 1, 1, 1, 1));
		mPanel.add(mScrollPane, 	Func.makeGrid(0, 1, 10, 1, 10, 100));
	}
	
	class SearchListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String searchTarget = mSearchTarget.getText().toUpperCase(); //.replaceAll("\\s+", "");
			int searchCol = mSearchType.getSelectedIndex();
			
			if (searchTarget.length() == 0) {
				mSorter.setRowFilter(null);
			} else {
				try {
					mSorter.setRowFilter(RowFilter.regexFilter(searchTarget, searchCol));
				} catch (Exception e) { }
			}
		}
	}
}
