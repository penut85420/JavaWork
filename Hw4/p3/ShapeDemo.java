package ntou.cs.java2016.Penut.hw4.p3;

import java.awt.*;
import javax.swing.*;

public class ShapeDemo extends JFrame {
	public ShapeDemo() {
		super("Shape Demo");
		setSize(800, 600);
	}
	
	public static void main(String[] args) {
		ShapeDemo shapeDemo = new ShapeDemo();
		shapeDemo.setVisible(true);
		Shape mShape = new Shape();
		shapeDemo.add(mShape);
		mShape.updateUI();
	}
}
