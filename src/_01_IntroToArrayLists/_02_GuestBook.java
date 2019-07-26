package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_GuestBook implements ActionListener {
	JFrame frame;
	JPanel panel;
	JButton add;
	JButton show;
	ArrayList<String> guests = new ArrayList<String>();

	// Create a GUI with two buttons. One button reads "Add Name" and the other
	// button reads "View Names".
	// When the add name button is clicked, display an input dialog that asks the
	// user to enter a name. Add
	// that name to an ArrayList. When the "View Names" button is clicked, display a
	// message dialog that displays
	// all the names added to the list. Format the list as follows:
	// Guest #1: Bob Banders
	// Guest #2: Sandy Summers
	// Guest #3: Greg Ganders
	// Guest #4: Donny Doners
	public static void main(String[] args) {
		new _02_GuestBook().makeButtons();
	}

	void makeButtons() {
		frame = new JFrame();
		panel = new JPanel();
		add = new JButton();
		show = new JButton();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add.setText("Add Name");
		add.addActionListener(this);
		show.setText("View Names");
		show.addActionListener(this);
		frame.add(panel);
		panel.add(add);
		panel.add(show);
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == add) {
			guests.add(JOptionPane.showInputDialog("Enter a name."));
		} else if (e.getSource() == show) {
			int num = 1;
			String message = "";
			for (String name : guests) {
				System.out.println(name);
				message += "Guest #";
				message += num;
				message += ": ";
				message += name;
				message += "\n";
				num++;
			}
			JOptionPane.showMessageDialog(null, message);
		}
	}
}