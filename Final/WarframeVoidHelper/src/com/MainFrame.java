package com;

import java.awt.*;
import javax.swing.*;

import com.TodoList.*;
import com.DataStructure.DataStructure;
import com.RelicMission.RelicMission;
import com.RelicViewer.*;

import java.util.*;

public class MainFrame {
	JFrame mFrame;
	JPanel mPanel;
	ArrayList<JPanel> mTabbedPanel;
	DataStructure mDataStruct;
	
	public MainFrame() {
		mFrame = new JFrame("Warframe Void Helper");
		mFrame.setSize(1280, 720);
		mFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mPanel = new JPanel();
		mPanel.setLayout(new GridBagLayout());
		mFrame.add(mPanel);
		
		mTabbedPanel = new ArrayList<JPanel>();
		
		mDataStruct = new DataStructure();

		makeGUI();
	}
	
	public void run() {
		mFrame.setVisible(true);
	}
	
	private void makeGUI() {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			SwingUtilities.updateComponentTreeUI(mFrame);
		}
		catch (Exception uie) { uie.printStackTrace(); }
		
		final String[] sTabName = {"目標部件", "遺物檢視", "關卡名稱查詢", "杜卡德查詢"};
		
		JTabbedPane mTabbedPane = new JTabbedPane();
		mTabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

		for (String s: sTabName) {
			JPanel panel = new JPanel();
			panel.setPreferredSize(getPanelSize());
			mTabbedPanel.add(panel);
			mTabbedPane.addTab(s, panel);
		}
		
		@SuppressWarnings("unused")
		TodoList mTodoList = new TodoList(mTabbedPanel.get(0), mDataStruct);
		@SuppressWarnings("unused")
		RelicViewer mRelicViewer = new RelicViewer(mTabbedPanel.get(1), mDataStruct);
		@SuppressWarnings("unused")
		RelicMission mRelicMission = new RelicMission(mTabbedPanel.get(2), mDataStruct);
		
		mPanel.add(mTabbedPane, Func.makeGrid(0, 0, 2, 100, 1, 1));
	}
	
	private Dimension getPanelSize() {
		return new Dimension(mFrame.getWidth(), mFrame.getHeight());
	}
}
