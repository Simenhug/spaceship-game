package com.simen.plane;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import com.simen.util.Constant;
import com.simen.util.GameUtil;

public class Plane extends GameObject{
	//dimensions: width 90, height 52
	
	boolean left,up,right,down;
	private boolean alive = true;
	
	
	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public void draw(Graphics g) {
		if(alive) {
			g.drawImage(img, (int)x, (int)y, null);
			move();
		}
	}
	
	public Rectangle getHitbox() {
		return new Rectangle((int)x, (int)y, width, height);
	}
	
	public void move() {
		if(left) {
			if(x>=-30) {
				x -= speed;
			}
		}
		if(up) {
			if(y>=0) {
				y -= speed;
			}
		}
		if(right) {
			if(x<=Constant.frameWidth-90) {
				x += speed;
			}
		}
		if(down) {
			if(y<=Constant.frameHight-69) {
				y += speed;
			}
		}
	}
	
	public void directionStart(KeyEvent e) {
		switch(e.getKeyCode()) {
		//left key
		case 37:
			left = true;
			break;
		//up key
		case 38:
			up = true;
			break;
		//right key
		case 39:
			right = true;
			break;
		//down key
		case 40:
			down = true;
			break;
			
		default:
			break;
		}
	}
	
	public void directionStop(KeyEvent e) {
		switch(e.getKeyCode()) {
		//left key
		case 37:
			left = false;
			break;
		//up key
		case 38:
			up = false;
			break;
		//right key
		case 39:
			right = false;
			break;
		//down key
		case 40:
			down = false;
			break;
			
		default:
			break;
		}
	}

	public Plane(String imgPath, double x, double y) {
		super();
		this.img = GameUtil.getImage(imgPath);
		this.x = x;
		this.y = y;
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
		this.speed = 20;
	}
	
	

}
