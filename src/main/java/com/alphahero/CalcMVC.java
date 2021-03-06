package com.alphahero;

import java.awt.Dimension;
import javax.swing.*;


@SuppressWarnings("serial")
public class CalcMVC extends JFrame {
	// Create model, view, and controller. They are
	// created once here and passed to the parts that
	// need them so there is only one copy of each.
	public void startaSpelet() {
		CalcModel model = new CalcModel();
		CalcView view = new CalcView(model);
		CalcController controller = new CalcController(model, view);

		JFrame frame = new JFrame("AlphaHero");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocation(30, 150);
		// frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//frame.setUndecorated(true);
		frame.add(view);
		frame.setPreferredSize(new Dimension(model.getPanelWidth(), model
				.getPanelHeight()));
		frame.pack();

		frame.setVisible(true);
		controller.startAnimation();
	}
}