package com.simen.plane;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.simen.util.Constant;

public class Bullet extends GameObject{

	double degree;
	
	public Rectangle getHitbox() {
		return new Rectangle((int)x, (int)y, width, height);
	}
	
	public Bullet() {
		degree = Math.random()*Math.PI*2;
		x = Constant.frameWidth/2;
		y = Constant.frameHight/2;
		speed = 8;
		width = 10;
		height = 10;
	}                                       
	
	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.yellow);
		g.fillOval((int)x, (int)y, width, height);
		
		x += speed*Math.cos(degree);
		y += speed*Math.sin(degree);
		
		if(y>Constant.frameHight-height||y<30) {
			degree = -degree;
		}
		
		if(x<0||x>Constant.frameWidth-width) {
			degree = Math.PI-degree;
		}
		
		g.setColor(c);
	}
}
