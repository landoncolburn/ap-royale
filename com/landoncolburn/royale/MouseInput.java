package com.landoncolburn.royale;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Point;

public class MouseInput extends MouseAdapter {

	private Point mousePos;

	public MouseInput() {
	}

	public void mousePressed(MouseEvent e) {
		
	}

	public void mouseClicked(MouseEvent e) {
		mousePos = e.getPoint();
	}

	public Point getPoint() {
		return mousePos;
	}

}
