package com.landoncolburn.royale;

import java.awt.*;
import java.awt.image.*;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 42l;

	public static Game gameInstance;
	public Handler handler;
	public GUIHandler gui;

	private Thread thread;
	private boolean isRunning = false;

	public Dimension size;
	public MouseMotionInput mmi;
	public KeyInput ki;
	public MouseInput mi;
	public Camera camera;
	
	public Player screenPlayer;

	public Game() {
		size = new Dimension(1000, 600);
		new Window("Game", size, this);
		start();

		handler = new Handler();
		gui = new GUIHandler();
		gameInstance = this;

		mmi = new MouseMotionInput();
		mi = new MouseInput();
		ki = new KeyInput();
		
		camera = new Camera(0, 0);

		this.addMouseListener(mi);
		this.addMouseMotionListener(mmi);
		this.addKeyListener(ki);

		createWorld();
	}

	public void start() {
		isRunning = true;
		thread = new Thread(this);
		thread.start();
	}

	public void stop() {
		isRunning = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		while (isRunning) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				render();
				delta--;
			}
			long endTime = System.nanoTime();
			long elapsedTime = endTime - now;
			try {
				Thread.sleep((Math.abs(16666666 - elapsedTime)) / 1000000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		stop();
	}

	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
	    Graphics2D g2d = (Graphics2D) g;
	    //////////////////////////////////

	    g.setColor(Color.red);
	    g.fillRect(0, 0, 1000, 600);

	    g2d.translate(-camera.getX(), -camera.getY());

	    handler.render(g);

	    g2d.translate(camera.getX(), camera.getY());

	    //////////////////////////////////
	    g.dispose();
		bs.show();
	}

	// Runs every frame
	public void tick() {
		camera.tick(screenPlayer);
		handler.tick();
		gui.tick();
	}

	// Runs before first tick method
	public void createWorld() {
		screenPlayer = new Player(0, 0);
		handler.addObject(screenPlayer);
		handler.addObject(new Enemy(100, 100));
	}

	public static void main(String[] args) {
		new Game();
	}
}
