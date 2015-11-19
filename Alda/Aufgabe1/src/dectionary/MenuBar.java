package dectionary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MenuBar extends JMenuBar implements ActionListener {

	private JMenuItem open, beenden;
	private JMenu menu;
	private JMenuBar menuBar;
	private MenuEintrag area;
	private HashDictionary<String, String> hashDict = new HashDictionary<>();

	public MenuBar() {

		menuBar = new JMenuBar();
		menu = new JMenu("DATEI");
		menuBar.add(menu);

		open = new JMenuItem("Datei auswählen..");
		beenden = new JMenuItem("Wörterbuch schließen..");

		open.addActionListener(this);
		menu.add(open);
		menu.addSeparator();
		beenden.addActionListener(this);
		menu.add(beenden);

		menuBar.add(menu);
		this.add(menuBar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		if (source == beenden) {

			int end = JOptionPane.showConfirmDialog(beenden, "Wörterbuch Schließen ?", "Confirm Dialog",
					JOptionPane.YES_NO_OPTION);
			if (end == JOptionPane.YES_OPTION) {
				System.exit(0);

			}
		} else {
			JFileChooser file = new JFileChooser();
			int datei = file.showOpenDialog(this.getParent());
			if (datei == JFileChooser.APPROVE_OPTION) {
				File f = file.getSelectedFile();
				read(f);

			}

		}

	}

	public void read(File f) {
		LineNumberReader in = null;
		try {
			in = new LineNumberReader(new FileReader(f));
			String line;
			while ((line = in.readLine()) != null) {
				String[] sf = line.split(" ");
				if (sf.length == 2) {
					hashDict.insert(sf[0],  sf[1]); 
				} 
			}
			in.close();
		} catch (IOException ex) {
			Logger.getLogger(MenuBar.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
