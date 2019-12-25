package com.simen.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;


/**
 * Game uitities
 * 
 * @author xinmianhuang
 *
 */
public class GameUtil {

	private GameUtil() {
	}
	

	public static Image getImage(String path) {
		System.out.println(path);
		URL u = GameUtil.class.getClassLoader().getResource(path);
		System.out.println(u);
		BufferedImage img = null;
		try {
			img = ImageIO.read(u);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return img;
	}
}
