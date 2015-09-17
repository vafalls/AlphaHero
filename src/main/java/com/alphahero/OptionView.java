package com.alphahero;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.*;

@SuppressWarnings("serial")
public class OptionView extends JFrame {

	private JButton setting = new JButton("Settings");

	public OptionView() {
		// UI
		JFrame frame = new JFrame("Options");
		MyTextPane3 jp = new MyTextPane3();
		frame.add(jp);

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setSize(420, 425);
		frame.setResizable(false);
		frame.setVisible(true);
	}

	void addSettingListener(ActionListener set) {
		setting.addActionListener(set);
	}

	private static class MyTextPane3 extends JTextPane {
		public MyTextPane3() {
			super();

			SimpleAttributeSet aSet = new SimpleAttributeSet();
			StyleConstants.setAlignment(aSet, StyleConstants.ALIGN_CENTER);
			StyleConstants.setUnderline(aSet, true);
			StyleConstants.setFontFamily(aSet, "sansserif");
			StyleConstants.setFontSize(aSet, 40);

			SimpleAttributeSet bSet = new SimpleAttributeSet();
			StyleConstants.setAlignment(bSet, StyleConstants.ALIGN_CENTER);
			StyleConstants.setFontFamily(bSet, "sansserif");
			StyleConstants.setFontSize(bSet, 16);

			String spelinfo = "Game Info\n\nPress the shown button in the squares to the left to score points."
					+ "\n\nA to Z - Hit\n";
			String pauseinfo = "ESC - Pause Game";

			setFont(new Font("sansserif", Font.BOLD, 16));
			setText("Options\n\n" + "" + spelinfo + pauseinfo);

			StyledDocument doc = this.getStyledDocument();
			doc.setParagraphAttributes(0, 8, aSet, false);
			doc.setParagraphAttributes(9, doc.getLength(), bSet, false);

			// Window info
			setOpaque(false);
			setEditable(false);
			setBackground(new Color(0, 0, 0, 0));

		}

		@Override
		protected void paintComponent(Graphics g) {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, getWidth(), getHeight());

			try {
				Image image = ImageIO.read(this.getClass().getClassLoader()
						.getResourceAsStream("menu-background.jpg"));
				g.drawImage(image, 0, 0, this);
			} catch (IOException io) {
				io.printStackTrace();
			}
			super.paintComponent(g);
		}
	}
}