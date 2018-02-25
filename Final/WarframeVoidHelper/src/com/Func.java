package com;

import java.awt.*;
import java.io.*;

public class Func {
	public static GridBagConstraints makeGrid(int x, int y, int w, int h) {
		return makeGrid(x, y, w, h, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.WEST);
	}
	
	public static GridBagConstraints makeGrid(int x, int y, int w, int h, double wx, double wy) {
        return makeGrid(x, y, w, h, wx, wy, GridBagConstraints.BOTH, GridBagConstraints.WEST);
	}
	
	public static GridBagConstraints makeGrid(int x, int y, int w, int h, double wx, double wy, int fill, int anchor) {
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = x; 
		c.gridy = y;
        c.gridwidth = w;
        c.gridheight = h;
        c.weightx = wx;
        c.weighty = wy;
        c.fill = fill;
        c.anchor = anchor;
        return c;
	}
	
	public static String getFileToString(File file) {
		String sFile = null;
		try {
			FileInputStream fin = new FileInputStream(file.getPath());
			byte ba[] = new byte[fin.available()];
            fin.read(ba);
            sFile = new String(ba, "UTF-8");
            sFile = sFile.replace("\uFEFF", "");
            fin.close();
		} catch(IOException e) { }
		return sFile;
	}
}
