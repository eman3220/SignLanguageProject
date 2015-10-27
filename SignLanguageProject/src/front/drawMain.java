package front;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class drawMain extends JPanel implements ActionListener {

	private BufferedImage bg, boxLB, boxGB, boxDB;

	Color offWhite = new Color(249, 241, 252, 255);
	Color lightBlue = new Color(211, 219, 219, 255);
	Color greyBlue = new Color(121, 128, 151, 255);
	Color midBlue = new Color(72, 59, 128, 255);
	Color darkBlue = new Color(31, 27, 39, 255);

	int width, height;
	int tY, sbsX, nY, erY, etX, b1Y, b2Y, b3Y, b4X, b5X, b6X, b7X, b8X;
	int vel = 1;

	Timer tm = new Timer(10, this);

	public drawMain(int wd, int ht) {
		try {
			bg = ImageIO.read(getClass().getResource("/Assets/background_grain.png"));
			boxDB = ImageIO.read(getClass().getResource("/Assets/button_box_darkBlue.png"));
			boxGB = ImageIO.read(getClass().getResource("/Assets/button_box_greyBlue.png"));
			boxLB = ImageIO.read(getClass().getResource("/Assets/button_box_lightBlue.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		tY = 0 - (ht / 2);
		sbsX = 0 - (wd / 4);
		nY = ht;
		erY = ht;
		etX = wd;

		repaint();
	}

	// Main paint method
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		width = this.getWidth();
		height = this.getHeight();
		g.drawImage(bg, 0, 0, width, height, null);
		g.drawImage(boxGB, sbsX, height / 8, width / 4, height / 2, null);
		g.drawImage(boxLB, width / 4, nY, width / 4, height / 8 * 3, null);
		g.drawImage(boxGB, width / 2, erY, width / 4, height / 4, null);
		g.drawImage(boxLB, etX, height / 2, width / 4 + 3, height / 4, null);
		g.drawImage(boxDB, width / 4, tY - 1, width / 2, height / 2, null);
		g.setColor(midBlue);
		g.fillRect(width / 4 - 3, 0, 6, b1Y);
		g.fillRect(width / 4 * 3 - 3, height, 6, -b2Y);
		g.fillRect(width / 2 - 3, height / 8 * 5, 6, b3Y);
		g.fillRect(width, height / 2 - 3, -b4X, 6);
		g.fillRect(width / 2, height / 8 * 7 - 3, b5X, 6);
		g.fillRect(width, height / 4 * 3 - 3, -b6X, 6);
		g.fillRect(0, height / 8 - 3, b7X, 6);
		g.fillRect(0, height / 8 * 5 - 3, b8X, 6);

		tm.start();
	}

	public void actionPerformed(ActionEvent e) {
		if (b1Y < height)
			b1Y += 2 * vel;
		if (b2Y < height)
			b2Y += 2 * vel;
		if (b3Y < height / 2)
			b3Y += 2 * vel;
		if (b4X < width / 4 * 3 + 3)
			b4X += 2 * vel;
		if (b5X < width / 4)
			b5X += 2 * vel;
		if (b6X <  width / 4 + 3)
			b6X += 2 * vel;
		if (b7X < width / 4 + 3)
			b7X += 2 * vel;
		if (b8X < width / 4 * 3 + 3)
			b8X += 2 * vel;
		
		if (tY < 0)
			tY += vel;
		if (sbsX < 0)
			sbsX += vel;
		if (nY > height / 8 * 5)
			nY -= vel;
		if (erY > height / 8 * 5)
			erY -= vel;
		if (etX > width / 4 * 3)
			etX -= vel;

		repaint();
	}
}
