package window;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameWindow extends JFrame{
	
	private Toolkit toolkit;
	private Dimension dimension;
	
	//inicializacion de parametros
	public GameWindow() {
		super();
		toolkit = Toolkit.getDefaultToolkit();
		dimension = toolkit.getScreenSize();
	}
	
	//Metodo encargado de iniciar la ventana
	public void initFrameWin(GamePanel gp) {
		int widthPant = dimension.width;
		int heigthPant = dimension.height;
		
		this.setTitle("Game Window");
		this.addPanel(gp);
		this.setLocation(widthPant/6, heigthPant/6);
		this.pack();
		this.setResizable(false);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void addPanel(JPanel panel) {
		this.add(panel);
	}

}
