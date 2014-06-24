package twn.test;

import java.awt.Dimension;

import javax.swing.JFrame;

import twn.ui.searchField.SearchField;

public class UITest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setPreferredSize(new Dimension(250, 250));
		frame.add(new SearchField());
		frame.pack();
		frame.setVisible(true);
	}

}
