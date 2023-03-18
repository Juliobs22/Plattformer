package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.net.ssl.KeyManager;

import window.GamePanel;

public class keyManager implements KeyListener {
	private GamePanel gPanel;
	
	public keyManager(GamePanel gPanel) {
		this.gPanel = gPanel;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int kc = e.getKeyCode();
		
		switch (kc) {
		case KeyEvent.VK_A:
			this.gPanel.moveChangeX(-5);
			break;
		case KeyEvent.VK_D:
			this.gPanel.moveChangeX(5);
			break;
		case KeyEvent.VK_W:
			this.gPanel.moveChangeY(-5);
			break;
		case KeyEvent.VK_S:
			this.gPanel.moveChangeY(5);
			break;
		default:
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
