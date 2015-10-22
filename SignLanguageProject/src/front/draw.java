package front;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class draw extends JPanel {
	
	private BufferedImage bg;
	
	public draw(){
		//bg.getClass().getResource("/Assets/Background.png");
		try{
			bg = ImageIO.read(getClass().getResource("/Assets/Background.png"));
			System.out.println("got bg");
		}catch (IOException e){
			e.printStackTrace();
		}
		
		repaint();
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		//g.setColor(Color.RED);
		//g.drawRect(100, 100, 400, 400);
		//this.setBackground(Color.RED);
		
		g.drawImage(bg, 0,0, this.getWidth(), this.getHeight(), null);
	}
}
