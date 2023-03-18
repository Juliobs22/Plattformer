package character;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Sprites {
	public static final int SPRITE_WIDHT = 64;
	public static final int SPRITE_HEIGHT = 40;
	public static final int ANIM_STATIC = 0;
	public static final int ANIM_WALKING = 1;
	public static final int ANIM_JUMP = 2;
	public static final int ANIM_REGENERETE = 3;
	public static final int ANIM_GROUND = 4;
	public static final int ANIM_HIT = 5;
	public static final int ANIM_ATTACK = 6;
	public static final int ANIM_JUMP_ATTACK1 = 7;
	public static final int ANIM_JUMP_ATTACK2 = 8;
	public static final int DIR_LEFT = 0;
	public static final int DIR_RIGHT = 2;
	public static final int DIR_UP = 3;
	public static final int DIR_DOWN = 4;
	
	private BufferedImage image;
	private BufferedImage[][] listSprites;
	private int aniTrick;
	private int aniSpeed;
	private int animIndex;
	
	public Sprites() {
		this.importImage();
		this.aniSpeed = 15;
		
	}
	
	public void importImage() {
		InputStream istm = getClass().getResourceAsStream("/player_sprites.png");
		
		try {
			image = ImageIO.read(istm);
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "No se han cargado algunos recursos", "Error", JOptionPane.ERROR_MESSAGE);
		} finally {
			try {
				istm.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public BufferedImage getSprite(int x, int y, int width, int height) {
		return this.image.getSubimage(x, y, width, height);
	}
	
	public void loadAnimation() {
		this.listSprites = new BufferedImage[9][6];
		for (int i=0; i<9; i++) {
			for (int j=0; j<6; j++) {
				listSprites[i][j] = image.getSubimage(j*SPRITE_WIDHT, i*SPRITE_HEIGHT, SPRITE_WIDHT, SPRITE_HEIGHT);
			}
		}
	}
	
	public int getAnimIndex() {
		return animIndex;
	}

	public void animate(int typeAnimation) {
		this.aniTrick++;
		if(aniTrick >= aniSpeed) {
			this.aniTrick = 0;
			this.animIndex++;
			if(animIndex >= calculateFramerate(typeAnimation))
				this.animIndex = 0;
		}
	}
	

	public BufferedImage getSpriteFragment(int typeAnimation) {
		return listSprites[typeAnimation][this.animIndex];
	}
	
	public int calculateFramerate(int type) {
		switch (type) {
		case ANIM_STATIC:
			return 5;
		case ANIM_WALKING:
			return 6;
		case ANIM_JUMP:
			return 3;
		case ANIM_REGENERETE:
			return 1;
		case ANIM_GROUND:
			return 2;
		case ANIM_HIT:
			return 4;
		case ANIM_ATTACK:
			return 3;
		case ANIM_JUMP_ATTACK1:
			return 3;
		case  ANIM_JUMP_ATTACK2:
			return 3;
		default:
			break;
		}
		
		return 0;
	}
}
