package _03_IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class _02_TextUndoRedo implements KeyListener {
	JFrame frame;
	JPanel panel;
	JLabel label;
	Stack<Character> deleted = new Stack<Character>();
	/* 
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character is erased from the JLabel.
	 * Save that deleted character onto a Stack of Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed, the top Character is popped 
	 * off the Stack and added back to the JLabel.
	 * 
	 * */
	public static void main(String[] args) {
		_02_TextUndoRedo text = new _02_TextUndoRedo();
	}
	
	_02_TextUndoRedo() {
		frame = new JFrame();
		panel = new JPanel();
		label = new JLabel();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(this);
		label.setText("");
		frame.add(panel);
		panel.add(label);
		frame.pack();
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		char k = e.getKeyChar();
		if(label != null) {
		label.setText(label.getText() + k);
		frame.pack();
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int k = e.getKeyCode();
		if(k == KeyEvent.VK_BACK_SPACE) {
			String str = label.getText().substring(0,label.getText().length() - 1);
			label.setText(str);
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
