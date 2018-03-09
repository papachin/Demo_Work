import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Reader_Files {

	public static void main(String args[]) {

        // Will be left-aligned.
        JPanel configurePanel = new JPanel();
        configurePanel.add(new JButton("Configure"));

        // Will be right-aligned.
        JPanel okCancelPanel = new JPanel();
        okCancelPanel.add(new JButton("Ok"));
        okCancelPanel.add(new JButton("Cancel"));

        // The full panel.
        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.add(configurePanel, BorderLayout.WEST);
        buttonPanel.add(okCancelPanel,  BorderLayout.EAST);

        // Show it.
        JFrame t = new JFrame("Button Layout Demo");
        t.setContentPane(buttonPanel);
        t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        t.setSize(400, 75);
        t.setVisible(true);
    }
}