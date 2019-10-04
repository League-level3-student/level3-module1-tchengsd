package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class _02_LogSearch implements ActionListener {
	/* 
	 * Crate a HashMap of Integers for the keys and Strings for the values.
	 * Create a GUI with three buttons. 
	 * Button 1: Add Entry
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				After an ID is entered, use another input dialog to ask the user to enter a name.
	 * 				Add this information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				If that ID exists, display that name to the user.
	 * 				Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List
	 * 				When this button is clicked, display the entire list in a message dialog in the following format:
	 * 				ID: 123  Name: Harry Howard
	 * 				ID: 245  Name: Polly Powers
	 * 				ID: 433  Name: Oliver Ortega
	 * 				etc...
	 * 
	 * When this is complete, add a fourth button to your window.
	 * Button 4: Remove Entry
	 * 				When this button is clicked, prompt the user to enter an ID using an input dialog.
	 * 				If this ID exists in the HashMap, remove it. Otherwise, notify the user that the ID
	 * 				is not in the list. 
	 *
	 * */
	HashMap<Integer, String> hash = new HashMap<Integer, String>();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton addEntry = new JButton();
	JButton search = new JButton();
	JButton view = new JButton();
	JButton remove = new JButton();
	JTextArea text = new JTextArea();
	String nameList = "";
	
	public static void main(String[] args) {
		new _02_LogSearch().makeProgram();
	}
	void makeProgram() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		addEntry.addActionListener(this);
		addEntry.setText("Add Entry");
		search.addActionListener(this);
		search.setText("Search by ID");
		view.addActionListener(this);
		view.setText("View List");
		remove.addActionListener(this);
		remove.setText("Remove Entry");
		text.setText(nameList);
		panel.add(addEntry);
		panel.add(search);
		panel.add(view);
		panel.add(remove);
		panel.add(text);
		frame.pack();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object a = e.getSource();
		if (a == addEntry) {
			String keyWord = JOptionPane.showInputDialog("Enter an ID number.");
			int key = Integer.parseInt(keyWord);
			String value = JOptionPane.showInputDialog("Enter a name.");
			hash.put(key, value);
			nameList += "ID: " + key + "  Name: " + value + "\n";
		}
		if (a == search) {
			String idSearch = JOptionPane.showInputDialog("Enter an ID to search for.");
			int id = Integer.parseInt(idSearch);
			if(hash.containsKey(id)) {
				JOptionPane.showMessageDialog(null, hash.get(id));
			}
			else {
				JOptionPane.showMessageDialog(null, "There is no name there.");
			}
		}
		if (a == view) {
			text.setText(nameList.substring(0,nameList.length() - 1));
			frame.pack();
		}
	}

}
