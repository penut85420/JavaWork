package ntou.cs.java2016.Penut.hw4.p3;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;
import java.util.*;

public class Shape extends JPanel {
	private int mNumOfShape;
	private ArrayList<MyShape> mShapeList;
	private MyShape mDragShape;
	public int nLines, nOvals, nRects;
	
	public Shape() {
		// Initialize
		
		mDragShape = null;
		
		setBackground(Color.WHITE);
		
		try {
			mNumOfShape = Integer.valueOf(JOptionPane.showInputDialog("Numbers of shape"));
		} catch(Exception e) { mNumOfShape = 0; }
		
		mShapeList = new ArrayList<MyShape>(mNumOfShape);
		
		nLines = nOvals = nRects = 0;
		
		// Generate shapes
		for (int i = 0; i < mNumOfShape; i++) {
			int shapeType = getVal(3);
			
			// Generate position
			int rX = getVal(400);
			int rY = getVal(300);
			
			// Generate random color
			int rR = getVal(256);
			int rG = getVal(256);
			int rB = getVal(256);
			
			if (shapeType == 0) {
				nLines++;
				// Generate random end point
				int rEndX = getVal(400);
				int rEndY = getVal(300);
				mShapeList.add(new MyLine(new Point(rX, rY), new Point(rEndX, rEndY), new Color(rR, rG, rB)));
			} else {
				// Generate random width and height
				int rW = getVal(390) + 10;
				int rH = getVal(290) + 10;
				boolean rFill = getVal(2) == 0? false: true;
				if (shapeType == 1) {
					nOvals++;
					mShapeList.add(new MyOval(new Point(rX, rY), new Color(rR, rG, rB), rW, rH, rFill));
				} else if (shapeType == 2) {
					nRects++;
					mShapeList.add(new MyRect(new Point(rX, rY), new Color(rR, rG, rB), rW, rH, rFill));
				}
			}
		}
		addMouseListener(new MouseListener() {
			// To get which shape is clicked
			public void mousePressed(MouseEvent e) {
				Collections.reverse(mShapeList);
				for (MyShape shape: mShapeList)
					if (shape.isInside(e.getPoint())) {
						mDragShape = shape;
						break;
					}
				Collections.reverse(mShapeList);
			}
			
			// To release shape
			public void mouseReleased(MouseEvent e) {
				mDragShape = null;
			}
			public void mouseExited(MouseEvent e) { }
			public void mouseEntered(MouseEvent e) { }
			public void mouseClicked(MouseEvent e) { }
		});
		
		addMouseMotionListener(new MouseMotionListener() {
			public void mouseMoved(MouseEvent e) { }
			
			// Make shape to move
			public void mouseDragged(MouseEvent e) {
				if (mDragShape != null) {
					mDragShape.setCenter(e.getPoint());
					repaint();
				}
			}
		});
		
		setLayout(new BorderLayout());
		JLabel mStatue = new JLabel(nLines + " Lines, " + nOvals + " Ovals, " + nRects + " Rectangles.");
		mStatue.setOpaque(true);
		add(mStatue, BorderLayout.SOUTH);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (MyShape shape: mShapeList)
			shape.draw(g);
	}
	
	// Generate random integer
	private int getVal(int n) {
		Double d = Math.random() * n;
		return d.intValue();
	}
}
