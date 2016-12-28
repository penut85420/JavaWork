package ntou.cs.java2016.Penut.hw4.p2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.*;

public class WeatherViewer {
	JFrame mFrame;
	JPanel mPanel;
	JComboBox<String> mCityList;
	JComboBox<String> mDateBox;
	JTextField mDayTemperature;
	JTextField mNightTemperature;
	JLabel mDayIcon;
	JLabel mNightIcon;
	TemperatureFetcher mTemperatureFetcher;
	
	public WeatherViewer() {
		mFrame = new JFrame("Java Weather Homework");
		mPanel = new JPanel();
		mTemperatureFetcher = new TemperatureFetcher();
		
		mFrame.setSize(400, 200);
		mFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mPanel.setLayout(new GridLayout(4, 2));
		mFrame.add(mPanel);
		
		makeGUI();
	}
	
	public void run() {
		mFrame.setVisible(true);
	}
	
	private void makeGUI() {
		// Component Row 1: City Select Area
		String[] sCity = ("基隆市 臺北市 新北市 "
				+ "桃園市 新竹市 新竹縣 苗栗縣 "
				+ "臺中市 彰化縣 南投縣 雲林縣 "
				+ "嘉義市 嘉義縣 臺南市 高雄市 "
				+ "屏東縣 宜蘭縣 花蓮縣 臺東縣 "
				+ "金門縣 澎湖縣").split(" ");
		
		JLabel mLabel1 = new JLabel("請選擇城市：");
		mCityList = new JComboBox<String>(sCity);
		
		// Component Row 2: Date Select Area
		TemperatureBundle t = null;
		try {
			t = mTemperatureFetcher.getTemperature("基隆");
		} catch (Exception e) { e.printStackTrace(); }
		JLabel mLabel2 = new JLabel("請選擇日期：");
		mDateBox = new JComboBox<String>(t.getWeekDates());
		
		// Component Row 3: Day Temperature Display Area
		JLabel mLabel3 = new JLabel("白天氣溫：");
		mDayTemperature = new JTextField();
		mDayIcon = new JLabel();
		
		JPanel mDayPanel = new JPanel();
		mDayPanel.setLayout(new GridLayout(1, 2));
		mDayPanel.add(mDayTemperature);
		mDayPanel.add(mDayIcon);
		
		// Component Row 4: Night Temperature Display Area
		JLabel mLabel4 = new JLabel("晚上氣溫：");
		mNightTemperature = new JTextField();
		mNightIcon = new JLabel();
		
		JPanel mNightPanel = new JPanel();
		mNightPanel.setLayout(new GridLayout(1, 2));
		mNightPanel.add(mNightTemperature);
		mNightPanel.add(mNightIcon);
		
		// Component Property Setting
		mCityList.setMaximumRowCount(3);
		mDateBox.setMaximumRowCount(3);
		mDayTemperature.setEditable(false);
		mNightTemperature.setEditable(false);
		
		// Component Event Setting
		mCityList.addActionListener(new ComboBoxAction());
		mDateBox.addActionListener(new ComboBoxAction());
		
		// Add Component
		mPanel.add(mLabel1);
		mPanel.add(mCityList);
		
		mPanel.add(mLabel2);
		mPanel.add(mDateBox);
		
		mPanel.add(mLabel3);
		mPanel.add(mDayPanel);
		
		mPanel.add(mLabel4);
		mPanel.add(mNightPanel);
	}
	
	class ComboBoxAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String sLocation = (String) mCityList.getSelectedItem();
			int nDate = mDateBox.getSelectedIndex();
			TemperatureBundle t = null;
			try {
				t = mTemperatureFetcher.getTemperature(sLocation);
				mDayTemperature.setText(t.getDayTemps()[nDate]);
				mNightTemperature.setText(t.getNightTemps()[nDate]);
				mDayIcon.setIcon(new ImageIcon(new URL(t.getDayImages()[nDate])));
				mNightIcon.setIcon(new ImageIcon(new URL(t.getNightImages()[nDate])));
			} catch (Exception e1) { e1.printStackTrace(); }
		}
	}
}
