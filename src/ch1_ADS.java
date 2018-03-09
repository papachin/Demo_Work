import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.io.PrintStream;

import javax.swing.JComponent;
@SuppressWarnings("unused")

public class ch1_ADS{
	public static PrintStream printer = System.out;

	public static void main(String [] args) {
		Rectangle box = new Rectangle(5, 10, 20, 30);
		
		printer.print(box);
		
		// Move the rectangle 10 
		box.translate(15, 25);
		
		// Print information about the moved rectangle 
		printer.print("x: ");
		printer.println(box.getX());
		printer.println("Expected: 20");
		
		printer.print("y: ");
		printer.println(box.getY());
		printer.println("Expected: 35");
	}
	
	public void paintComponent (Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		Rectangle box = new Rectangle(5, 10, 20, 30);
		g2.draw(box);
		box.translate(15, 25);
		g2.draw(box);
	}
}