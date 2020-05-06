package com.landoncolburn.royale;

import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;

public class BufferedImageLoader {

	public static BufferedImage loadImage(String path) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}

}
