package com.alphahero;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Rect {
	private int width, height;
	private int x, y, dx, dy;
	private Color color;
	private Rectangle box;
	private String bokstav;
	private boolean alive;

	// ... Images
	private Image image;
	private Image dead_image;
	private Image alive_image;

	public Rect(int x, int y, Color color, int width, int height,
			String bokstav_) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
		this.bokstav = bokstav_;
		this.alive = false;

		// ... Initiate Images
		try {
			image = ImageIO.read(this.getClass().getClassLoader()
					.getResourceAsStream("Untitled-10.png"));
		} catch (IOException ex) {
		}
		try {
			alive_image = ImageIO.read(this.getClass().getClassLoader()
					.getResourceAsStream("Untitled-12.png"));
		} catch (IOException ex) {
		}
		try {
			dead_image = ImageIO.read(this.getClass().getClassLoader()
					.getResourceAsStream("Untitled-11.png"));
		} catch (IOException ex) {
		}
	}

	public void move() {
		this.x += dx;
		this.y += dy;
	}

	public void paint(Graphics g) {
		// ... set
		g.setFont(new Font("aasd", 20, 50));
		g.setColor(Color.white);

		// .. draw
		g.drawImage(image, x, y, 104, 104, null);
		g.drawString(this.bokstav.toUpperCase(), this.x + 32, this.y + 68);

		// end
		g.finalize();
	}

	public void setVelocity(double dx, double dy) {
		this.dx = (int) dx;
		this.dy = (int) dy;
	}

	public void setBoundingBox(Rectangle box) {
		this.box = box;
	}

	public void setCurrentImage(boolean dead_or_alive) {
		if (dead_or_alive) {
			image = alive_image;
		} else if (image != alive_image) {
			image = dead_image;
		}
	}

	public void setAlive() {
		this.alive = true;
	}

	public boolean getAlive() {
		return alive;
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

	public char getLetter() {
		char temp;
		temp = this.bokstav.charAt(0);
		return temp;
	}

	public Color getColor() {
		return color;
	}

	public Rectangle getBoundingBox() {
		return box;
	}
}
