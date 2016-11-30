package com.alphahero;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;
import javax.imageio.ImageIO;

public class CheckRect {
	private int width, height;
	private int x, y;
	private Color color;
	private Rectangle box;
	private Image image;

	public CheckRect(int x, int y, Color color, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;

		try {
			image = ImageIO.read(this.getClass().getClassLoader()
					.getResourceAsStream("Untitled-9.png"));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public void paint(Graphics g) {
		// g.setColor(color);
		// g.drawRect(x, y, width, height);
		// g.drawImage(image, x, y, null);
		g.drawImage(image, x, y, 104, 104, null);
	}

	public void setBoundingBox(Rectangle box) {
		this.box = box;
	}

	public Color getColor() {
		return color;
	}

	public Rectangle getBoundingBox() {
		return box;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
}