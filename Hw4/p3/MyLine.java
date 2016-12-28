package ntou.cs.java2016.Penut.hw4.p3;

import java.awt.*;

public class MyLine extends MyShape {
	private Point mEnd;
	
	public MyLine() {
		super();
		setEndPosition(new Point(0, 0));
	}
	
	public MyLine(Point begin, Point end, Color color) {
		super(begin, color);
		setEndPosition(end);
	}
	
	public void setEndPosition(Point end) {
		mEnd = end;
	}
	
	public int getEndX() { return mEnd.x; }
	public int getEndY() { return mEnd.y; }
	
	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawLine(getX(), getY(), getEndX(), getEndY());
	}

	@Override
	public boolean isInside(Point p) {
		return false;
	}

	@Override
	public void setCenter(Point p) {
		// TODO Auto-generated method stub
		
	}

}
