package com.landoncolburn.royale;

import java.awt.Color;
import java.awt.Graphics;

public class Enemy extends GameObject {
	
	double velx = 0, vely = 0;
	int tickCount = 0;

	public Enemy(int x, int y) {
		super(x, y, 32, 32, ID.PLAYER);
	}

	@Override
	public void tick() {
		tickCount++;
		x += velx;
		y += vely;
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(x, y, w, h);
	}

}
