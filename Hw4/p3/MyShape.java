package ntou.cs.java2016.Penut.hw4.p3;

import java.awt.*;

public abstract class MyShape {
	private Point mPosition;
	private Color mColor;
	
	public MyShape() {
		mPosition = new Point(0, 0);
		mColor = Color.BLACK;
	}
	
	public MyShape(Point point, Color color) {
		setPosition(point);
		setColor(color);
	}
	
	// Set Left-Top position
	public void setPosition(Point p) { mPosition = p; }
	
	public void setColor(Color c) { mColor = c; }
	
	public int getX() { return mPosition.x; }
	public int getY() { return mPosition.y; }
	public Color getColor() { return mColor; }
	
	public abstract void draw(Graphics g);
	
	// To determine if the point is inside the shape
	public abstract boolean isInside(Point p);
	
	// Set shape's center position
	public abstract void setCenter(Point p);
}
