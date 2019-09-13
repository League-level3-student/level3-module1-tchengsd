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
	int lives;
	String gameWord;
	String currentWord;

	public static void main(String[] args) {
		new HangMan().playHangman();
	}

	void playHangman() {
		String numberOfWords = JOptionPane.showInputDialog("How many words would you like to guess?");
		int wordAmt = Integer.parseInt(numberOfWords);
		lives = 10 * wordAmt;
		gameWord = "";
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		word.setText("");
		livesLeft.setText("Lives remaining: " + lives);
		frame.add(panel);
		frame.addKeyListener(this);
		panel.add(word);
		panel.add(livesLeft);
		for (int i = 0; i < wordAmt; i++) {
			String psh = Utilities.readRandomLineFromFile("dictionary.txt");
			if (!guessWords.contains(psh)) {
				guessWords.push(psh);
			}
			else {
				i--;
			}
		}
		currentWord = guessWords.pop();
		System.out.println(currentWord);
		for(int i = 0; i < currentWord.length(); i++) {
			gameWord+="_";
		}
		word.setText(gameWord);
		frame.pack();
		if(gameWord.equals(currentWord) && !guessWords.empty()) {
			getNewWord();
		}
	}
	
	void getNewWord() {
		currentWord = guessWords.pop();
		for(int i = 0; i < currentWord.length(); i++) {
			gameWord+="_";
		}
		word.setText(gameWord);
		livesLeft.setText("Lives remaining: " + lives);
		frame.pack();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		char c = e.getKeyChar();
		String str = "";
		if(gameWord != null) {
			for(int i = 0; i < currentWord.length(); i++) {
				if(currentWord.charAt(i) == c) {
					str+=c;
				}
				else {
					str+=gameWord.charAt(i);
				}
			}
			if(!currentWord.contains(String.valueOf(c))) {
				lives--;
			}
			gameWord = str;
			word.setText(gameWord);
			livesLeft.setText("Lives remaining: " + lives);
		}
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
