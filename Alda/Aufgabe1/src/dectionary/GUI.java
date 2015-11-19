package dectionary;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JFrame {

	public GUI() {
		
		MenuEintrag menu = new MenuEintrag();
		
		 JPanel mainPanel = new JPanel();
	        mainPanel.setBorder(BorderFactory.createEmptyBorder(17, 17, 17, 17));
	        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
	        mainPanel.add(menu);
	        this.setContentPane(mainPanel);
	        
		this.setTitle("Wörterbuch");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);

	}

	public static void main(String[] args) {
		new GUI();
	}
}
