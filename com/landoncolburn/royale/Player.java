package com.landoncolburn.royale;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObject {
	
	double velx = 0, vely = 0;
	int tickCount = 0;

	public Player(int x, int y) {
		super(x, y, 32, 32, ID.PLAYER);
	}

	@Override
	public void tick() {
		tickCount++;
		x += velx;
		y += vely;
		if(KeyInput.keys[0] == KeyState.DOWN) {
			vely = -3;
		} else if(KeyInput.keys[1] == KeyState.DOWN) {
			vely = 3;
		} else {
			vely = 0;
		}
		
		if(KeyInput.keys[2] == KeyState.DOWN) {
			velx = -3;
		} else if(KeyInput.keys[3] == KeyState.DOWN) {
			velx = 3;
		} else {
			velx = 0;
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(x, y, w, h);
	}

}
