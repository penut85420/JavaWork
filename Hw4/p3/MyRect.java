package ntou.cs.java2016.Penut.hw4.p3;

import java.awt.*;
import javax.swing.*;

public class MyRect extends MyFillableShape {
	private int mWidth;
	private int mHeight;
	
	public MyRect(Point position, Color color, int width, int height, boolean fill) {
		super(position, color, fill);
		setWidth(width);
		setHeight(height);
	}
	
	public void setWidth(int width) { mWidth = width; }
	public void setHeight(int height) { mHeight = height; }
	
	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		if (isFill()) {
			g.fillRect(getX(), getY(), mWidth, mHeight);
		} else {
			g.drawRect(getX(), getY(), mWidth, mHeight);
		}
	}

	@Override
	public boolean isInside(Point p) {
		if (p.x < getX()) return false;
		if (p.y < getY()) return false;
		if (p.x > getX() + mWidth) return false;
		if (p.y > getY() + mHeight) return false;
		return true;
	}
	
	@Override
	public void setCenter(Point p) {
		setPosition(new Point(p.x - mWidth / 2, p.y - mHeight / 2));
	}
}
