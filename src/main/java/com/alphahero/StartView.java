package com.alphahero;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

@SuppressWarnings("serial")
class StartView extends JFrame {
	// ... Components
	private JButton m_newGameBtn = new JButton("New Game");
	private JButton m_highscoreBtn = new JButton("Highscore");
	private JButton m_optionBtn = new JButton("Options");

	StartView() {
		// ... Set up the logic
		final MyTextPane textPane = new MyTextPane();
		this.add(textPane);
		this.pack();
		this.setSize(420, 425);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	void showError(String errMessage) {
		JOptionPane.showMessageDialog(this, errMessage);
	}

	void addNewGameListener(ActionListener yo) {
		m_newGameBtn.addActionListener(yo);
	}

	void addHighscoreListener(ActionListener mal) {
		m_highscoreBtn.addActionListener(mal);
	}

	void addOptionListener(ActionListener cal) {
		m_optionBtn.addActionListener(cal);
	}

	class MyTextPane extends JPanel {
		public MyTextPane() {
			super();
			setLayout(new GridLayout(5, 1));

			// CREATE COMPONENTS
			JLabel rubrik = new JLabel("          Alpha Hero");
			rubrik.setFont(new Font("sansserif", Font.BOLD, 40));

			// SETTINGS FOR COMPONENTS
			m_newGameBtn.setContentAreaFilled(false);
			m_highscoreBtn.setContentAreaFilled(false);
			m_optionBtn.setContentAreaFilled(false);

			// ADD COMPONENTS
			add(rubrik);
			add(m_newGameBtn);
			add(m_highscoreBtn);
			add(m_optionBtn);

			// window info
			setOpaque(false);
			// setEditable( false );
			setBackground(new Color(0, 0, 0, 0));
		}

		@Override
		protected void paintComponent(Graphics g) {
			// set background color- but can draw image here too
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, getWidth(), getHeight());

			// draws an image
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