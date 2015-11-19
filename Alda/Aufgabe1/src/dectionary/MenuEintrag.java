package dectionary;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class MenuEintrag extends JPanel implements ActionListener {

	private String[] sucheAuswahl = { "HashMapDict", "TreeMapDict", "SortedArrayDict", "HashDict", "BinaryTreeDict" };

	private HashDictionary<String, String> hashDict;
	private SortedArrayDictionary<String, String> sortedDict;
	private MapDictionary<String, String> mapDict;
	// private MapDictionary<String, String> tmapDict;
	private BinaryTreeDictionary<String, String> binaryDict;

	private JTextArea ausgabeArea;
	private JTextField DE, EN;
	private JComboBox auswahl;
	private JButton delete, insert, search;

	public MenuEintrag() {

		sortedDict = new SortedArrayDictionary<>();
		mapDict = new MapDictionary<>(new HashMap<String, String>());
		// tmapDict = new MapDictionary<>(new TreeMap<String, String>());
		binaryDict = new BinaryTreeDictionary<>();
		hashDict = new HashDictionary<>();

		Border border = BorderFactory.createTitledBorder("Einfügen/Suchen/Löschen");
		this.setBorder(border);
		this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

		JPanel allPanel = new JPanel();

		JPanel p1 = new JPanel();
		p1.add(new JLabel("DE"));
		p1.add(new JLabel("EN"));
		p1.setLayout(new GridLayout(2, 1));

		JPanel p2 = new JPanel();
		DE = new JTextField("", 20);
		p2.add(DE);
		EN = new JTextField("", 20);
		p2.add(EN);
		p2.setLayout(new GridLayout(2, 1));

		allPanel.add(p1);
		allPanel.add(p2);

		JPanel ausgabePanel = new JPanel();
		Border border1 = BorderFactory.createTitledBorder("Ausgabe");
		ausgabePanel.setBorder(border1);
		ausgabePanel.setLayout(new BorderLayout());

		ausgabeArea = new JTextArea();
		ausgabeArea.setPreferredSize(new Dimension(400, 250));
		JScrollPane scroll = new JScrollPane(ausgabeArea);
		ausgabePanel.add(scroll, BorderLayout.CENTER);
		ausgabeArea.setEditable(false);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		auswahl = new JComboBox(sucheAuswahl);
		auswahl.setSelectedIndex(0);
		allPanel.add(auswahl);

		delete = new JButton("Löschen");
		allPanel.add(delete);
		delete.addActionListener(this);
		insert = new JButton("Einfügen");
		allPanel.add(insert);
		insert.addActionListener(this);
		search = new JButton("Suchen");
		allPanel.add(search);
		search.addActionListener(this);

		this.add(allPanel);
		this.add(ausgabePanel);
	}

	private void searchAllClass() {
		StringBuilder allgemein = new StringBuilder("");
		String wortDE = DE.getText();		

		if (!wortDE.equals("")) {
			if (mapDict != null) {
				mapDict.search(wortDE);

			}
			if (sortedDict != null) {
				sortedDict.search(wortDE);

			}
			if (binaryDict != null) {
				binaryDict.search(wortDE);

			}
			if (hashDict != null) {
				hashDict.search(wortDE);

			}
			allgemein.append(wortDE).append(",").append(mapDict.myMap.get(wortDE)).append("");
		} else {

			JOptionPane.showMessageDialog(this, "Wort nicht gefunden !");
		}
		ausgabeArea.setText(allgemein.toString());

	}

	private void insertAllClass() {
		StringBuilder allgemein = new StringBuilder("");
		String w1 = DE.getText();
		String w2 = EN.getText();

		if (!(w1.equals("") && w2.equals(""))) {
			if (mapDict != null) {
				mapDict.insert(w1, w2);

			}
			if (sortedDict != null) {
				sortedDict.insert(w1, w2);

			}
			if (binaryDict != null) {
				binaryDict.insert(w1, w2);

			}
			if (hashDict != null) {
				hashDict.insert(w1, w2);

			}
			allgemein.append(w1).append(",").append(w2).append("");
		} else {

			JOptionPane.showMessageDialog(this, "Wortpaar zum Einf�gen eingeben !");
		}
		ausgabeArea.setText(allgemein.toString());

	}

	private void removeAllClass() {
		StringBuilder allgemein = new StringBuilder("");
		String w1 = DE.getText();

		if (!w1.equals("")) {
			if (mapDict != null) {
				mapDict.remove(w1);

			}
			if (sortedDict != null) {
				sortedDict.remove(w1);

			}
			if (binaryDict != null) {
				binaryDict.remove(w1);

			}
			if (hashDict != null) {
				hashDict.remove(w1);

			}
			allgemein.append("");
		} else {

			JOptionPane.showMessageDialog(this, "Wort zum L�schen eingeben !");
		}
		ausgabeArea.setText(allgemein.toString());

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object methode = e.getSource();
		Object zustand = auswahl.getSelectedItem();

		// MapDict
		if (zustand.equals(sucheAuswahl[0]) || zustand.equals(sucheAuswahl[1]) || zustand.equals(sucheAuswahl[2])
				|| zustand.equals(sucheAuswahl[3]) || zustand.equals(sucheAuswahl[4])) {
			if (methode == search) {
				searchAllClass();
			}

			if (methode == insert) {
				insertAllClass();
			}

			if (methode == delete) {
				removeAllClass();
			}

		}

	}
}
