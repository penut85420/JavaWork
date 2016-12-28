package ntou.cs.java2016.Penut.hw4.p3;

import java.awt.*;
import javax.swing.*;

public abstract class MyFillableShape extends MyShape {
	private boolean mIsFill;
	
	public MyFillableShape() {
		super();
		mIsFill = false;
	}
	
	public MyFillableShape(Point position, Color color, boolean fill) {
		super(position, color);
		mIsFill = fill;
	}
	
	public boolean isFill() { return mIsFill; }
}
