import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.io.PrintStream;
import javax.swing.JComponent;
import javax.swing.JFrame;
@SuppressWarnings("unused")

public class RectangleComponent extends JComponent {
	public static void main (String [] args) {
		JFrame frame = new JFrame();
		frame.setSize(250, 250);
		frame.setTitle("Rectangle");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		RectangleComponent c = new RectangleComponent();
		frame.add(c);
		frame.setVisible(true);
	}
	
	public void paintComponent (Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		Rectangle box = new Rectangle(5, 10, 20, 30);
		g2.draw(box);
		box.translate(15, 25);
		g2.draw(box);
		box.translate(15, 25);
		g2.draw(box);
	}
}
