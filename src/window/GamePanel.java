package window;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JPanel;

import character.Sprites;
import inputs.MouseInput;
import inputs.keyManager;

public class GamePanel extends JPanel {
	private keyManager km;
	private MouseInput mouIn;
	private Sprites sprites;
	private int xMov;
	private int yMov;
	private int direction;
	
	public GamePanel() throws IOException {
		super();
		this.km = new keyManager(this);
		this.mouIn = new MouseInput(this);
		this.xMov = 100;
		this.yMov = 100;
		this.sprites = new Sprites();
		this.sprites.loadAnimation();
		
		this.setSizing();
		this.addKeyListener(km);
		this.addMouseListener(mouIn);
		this.addMouseMotionListener(mouIn);
	}
	
	public void setSizing() {
		Dimension size = new Dimension(1280, 800);
		setPreferredSize(size);
	}
	
	public void moveChangeX(int val) {
		// TODO Auto-generated method stub
		this.xMov += val;
	}
	
	public void moveChangeY(int val) {
		// TODO Auto-generated method stub
		this.yMov += val;
	}
	
	public void setDirection(int actionMov) {
		switch (actionMov) {
		case Sprites.DIR_LEFT:
			this.xMov -= 5;
			break;
		case Sprites.DIR_RIGHT:
			this.xMov += 5;
			break;
		case Sprites.DIR_UP:
			this.yMov -= 5;
			break;
		case Sprites.DIR_DOWN:
			this.yMov += 5;
			break;
		default:
			break;
		}
	}

	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//BufferedImage sprite = sprites.getSprite(0, 0, Sprites.SPRITE_WIDHT, Sprites.SPRITE_HEIGHT);
		sprites.animate(Sprites.ANIM_WALKING);
		g.drawImage(sprites.getSpriteFragment(Sprites.ANIM_WALKING), this.xMov, this.yMov, Sprites.SPRITE_WIDHT*3, Sprites.SPRITE_HEIGHT*3, null);
		
	}
	
	/*public void updateRectangle() {
		xMov += xDelta;
		if(xMov > 400 || xMov < 0) {
			xDelta *= -1;
			colorBg = generateColor();
		}
		yMov += yDelta;
		if(yMov > 400 || yMov < 0) {
			yDelta *= -1;
			colorBg = generateColor();
		}
	}
	
	private Color generateColor() {
		Random rand = new Random();
		int red = rand.nextInt(255);
		int green = rand.nextInt(255);
		int blue = rand.nextInt(255);
		
		return new Color(red, green, blue);
	}*/

}
