package com.landoncolburn.royale;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

	public static KeyState[] keys = new KeyState[4];
	public static int UP = KeyEvent.VK_W,
			DOWN = KeyEvent.VK_S,
			LEFT = KeyEvent.VK_A,
			RIGHT = KeyEvent.VK_D;

	public KeyInput() {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == UP) {
			keys[0] = KeyState.DOWN;
		} else if(key == DOWN) {
			keys[1] = KeyState.DOWN;
		} else if(key == LEFT) {
			keys[2] = KeyState.DOWN;
		} else if(key == RIGHT) {
			keys[3] = KeyState.DOWN;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == UP) {
			keys[0] = KeyState.UP;
		} else if(key == DOWN) {
			keys[1] = KeyState.UP;
		} else if(key == LEFT) {
			keys[2] = KeyState.UP;
		} else if(key == RIGHT) {
			keys[3] = KeyState.UP;
		}
	}
}
