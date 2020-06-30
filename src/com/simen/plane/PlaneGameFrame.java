package com.simen.plane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;

import com.simen.util.Constant;
import com.simen.util.GameUtil;
import com.simen.util.MyFrame;

public class PlaneGameFrame extends MyFrame{
	
	Image bg = GameUtil.getImage("images/backgrounds/GalaxyUno.bmp");
	Plane plane = new Plane("images/spaceShips/ra9.png", 50, 50);
	
	Date startTime;
	Date finishTime;
	
	Explosion explosion;
	
	ArrayList<Bullet> bulletList = new ArrayList();
	
	public void paint(Graphics g) {
		g.drawImage(bg, 0, 0, null);
		plane.draw(g);
		for(int i=0;i<bulletList.size();i++) {
			Bullet b = bulletList.get(i);
			b.draw(g);
			
			//collision test
			boolean collide = b.getHitbox().intersects(plane.getHitbox());
			if(collide) {
				plane.setAlive(false);
				if(explosion==null) {
					finishTime = new Date();
					explosion = new Explosion(plane.x, plane.y);
				}
				
				explosion.draw(g);
				break;
			}
		}
		if(!plane.isAlive()) {
			//set end time to now
			double surviveTime = (double)(finishTime.getTime() - startTime.getTime())/1000;
			showRank(g, surviveTime);
			printWord(g, "time: "+surviveTime+" seconds",30, 300, 590, Color.red);
			printWord(g, "press Enter to restart", 30, 300, 700, Color.red);
		}
	}
	
	public void printWord(Graphics g, String str, int size, int x, int y, Color color) {
		Color c = g.getColor();
		g.setColor(color);
		Font f = new Font("Georgia", Font.BOLD, size);
		g.setFont(f);
		g.drawString(str, x, y);
		g.setColor(c);
	}
	
	public void showRank(Graphics g, double gameTime) {
		Image img;
		if(gameTime <=10) {
			img = GameUtil.getImage("images/ranks/WEBull.png");
			printWord(g, "Your Rank: Webull", 40, 300, 450, Color.red);
		}else if(gameTime<=20) {
			img = GameUtil.getImage("images/ranks/alita.jpg");
			printWord(g, "Your Rank: Alita", 40, 300, 450, Color.red);
		}else if(gameTime<=30) {
			img = GameUtil.getImage("images/backgrounds/Simen.JPG");
			printWord(g, "Your Rank: Simen", 40, 300, 480, Color.red);
		}else if(gameTime<=40) {
			img = GameUtil.getImage("images/backgrounds/Angel.JPG");
			printWord(g, "Your Rank: Della", 40, 300, 480, Color.red);
		}else {
			img = GameUtil.getImage("images/backgrounds/Simen.JPG");
			//just for my love Della
			Image love = GameUtil.getImage("images/backgrounds/love.png");
			Image della = GameUtil.getImage("images/backgrounds/Angel.JPG");
			g.drawImage(love, 705, 0, null);
			g.drawImage(della, 1144, 0, null);
			printWord(g, "Your Rank: Eternity", 40, 300, 480, Color.red);
		}
		g.drawImage(img, 0, 0, null);
	}
	
	public static void main(String[] args) {
		new PlaneGameFrame().launchFrame();
	}
	
	//overriding launchFrame() method to add key listener
	public void launchFrame() {
		super.launchFrame();
		addKeyListener(new KeyMonitor());
		//create bullets
		for(int i=0;i<25;i++) {
			Bullet b = new Bullet();
			bulletList.add(b);
			System.out.println(b.degree);
		}
		//set start time to now
		startTime = new Date();
	}
	
	//constructing this as insider class to better utilize the fields
	//of the outer class.
	class KeyMonitor extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			System.out.println("x: " + plane.x + " y: " + plane.y);
			//press ENTER to restart
			if(e.getKeyCode() == '\n') {
				new PlaneGameFrame().launchFrame();
			}
			plane.directionStart(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			System.out.println("x: " + plane.x + " y: " + plane.y);
			plane.directionStop(e);
		}
		
	}

}
