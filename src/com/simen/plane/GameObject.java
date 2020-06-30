package com.simen.plane;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class GameObject {
	Image img;
	double x,y;
	double speed;
	int width,height;
	
	public Rectangle getHitbox() {
		return new Rectangle((int)x, (int)y, width, height);
	}

	public GameObject(Image img, double x, double y, double speed, int width, int height) {
		super();
		this.img = img;
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.width = width;
		this.height = height;
	}
	
	public GameObject() {
	}
}
