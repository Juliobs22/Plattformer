package main;

import java.io.IOException;

import javax.swing.JOptionPane;

import window.GamePanel;
import window.GameWindow;

public class GameLog implements Runnable{
	private GameWindow gw;
	private GamePanel gp;
	private Thread gameThread;
	
	private final double FRAMES_MAX = 120.0;
	private final double NANO_SECOND = 1000000000.0;
	
	public GameLog() {
		try {
			gp = new GamePanel();
			gw = new GameWindow();
			
			gw.initFrameWin(gp);
			gw.setVisible(true);
			gp.requestFocus();
			
			this.initGameLoop();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "No se han cargado algunos recursos", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		double timeFrames = NANO_SECOND / FRAMES_MAX;
		long lastFrame = System.nanoTime();
		int frames = 0;
		long lastCheck = System.currentTimeMillis();
		
		while (true) {
			if (System.nanoTime() - lastFrame >= timeFrames) {
				gp.repaint();
				lastFrame = System.nanoTime();
				frames++;
			}
			
			if (System.currentTimeMillis() - lastCheck >= 1000) {
				lastCheck = System.currentTimeMillis();
				System.out.println("Frames: "+ frames);
				frames = 0;
			}
		}
	}
	
	private void initGameLoop() {
		gameThread = new Thread(this);
		gameThread.start();
	}

}
