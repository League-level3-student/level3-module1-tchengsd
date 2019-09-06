package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements KeyListener {

	Stack<String> guessWords = new Stack<String>();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel word = new JLabel();
	JLabel livesLeft = new JLabel();

	public static void main(String[] args) {
		new HangMan().playHangman();
	}

	void playHangman() {
		String numberOfWords = JOptionPane.showInputDialog("How many words would you like to guess?");
		int wordAmt = Integer.parseInt(numberOfWords);
		int lives = 10 * wordAmt;
		String s = "";
		
		for (int i = 0; i < wordAmt; i++) {
			String psh = Utilities.readRandomLineFromFile("dictionary.txt");
			if (!guessWords.contains(psh)) {
				guessWords.push(psh);
			}
			else {
				psh = Utilities.readRandomLineFromFile("dictionary.txt");
				guessWords.push(psh);
			}
		}
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		word.setText("");
		livesLeft.setText("Lives remaining: " + lives);
		frame.add(panel);
		panel.add(word);
		panel.add(livesLeft);
		String pop = guessWords.pop();
		for(int i = 0; i < pop.length(); i++) {
			s+="_";
		}
		word.setText(s);
		frame.pack();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
