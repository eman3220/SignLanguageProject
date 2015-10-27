package front;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class drawNumber extends JPanel {

	private BufferedImage bg, boxLB, boxGB, boxDB, add, sub, mlt, div, eql, back;

	Color offWhite = new Color(249, 241, 252, 255);
	Color lightBlue = new Color(211, 219, 219, 255);
	Color greyBlue = new Color(121, 128, 151, 255);
	Color midBlue = new Color(72, 59, 128, 255);
	Color darkBlue = new Color(31, 27, 39, 255);

	int width, height;

	public drawNumber() {
		try {
			bg = ImageIO.read(getClass().getResource("/Assets/background_grain.png"));
			boxDB = ImageIO.read(getClass().getResource("/Assets/button_box_darkBlue.png"));
			boxGB = ImageIO.read(getClass().getResource("/Assets/button_box_greyBlue.png"));
			boxLB = ImageIO.read(getClass().getResource("/Assets/button_box_lightBlue.png"));
			add = ImageIO.read(getClass().getResource("/Assets/button_add.png"));
			sub = ImageIO.read(getClass().getResource("/Assets/button_subtract.png"));
			mlt = ImageIO.read(getClass().getResource("/Assets/button_multiply.png"));
			div = ImageIO.read(getClass().getResource("/Assets/button_divide.png"));
			eql = ImageIO.read(getClass().getResource("/Assets/button_equals.png"));
			back = ImageIO.read(getClass().getResource("/Assets/button_arrow.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		repaint();
	}

	// Main paint method
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		width = this.getWidth();
		height = this.getHeight();
		g.drawImage(bg, 0, 0, width, height, null);
		g.drawImage(boxGB, width / 8, height / 8 * 3, width / 8, height / 8, null);
		g.drawImage(boxGB, width / 4, height / 8 * 3, width / 8, height / 8, null);
		g.drawImage(boxGB, width / 8, height / 2, width / 8, height / 8, null);
		g.drawImage(boxGB, width / 4, height / 2, width / 8, height / 8, null);
		g.drawImage(boxGB, width / 4, height / 8 * 5, width / 8, height / 8, null);
		g.drawImage(boxLB, width / 8, height / 8, width / 4, height / 8, null);
		g.drawImage(boxLB, width / 8, height / 4, width / 4, height / 8, null);
		g.drawImage(boxLB, 0, height / 4 * 3, width / 4, height / 4, null);
		g.drawImage(boxDB, 0, 0, width / 8, height / 8, null);
		g.drawImage(boxDB, width / 8 * 3, height / 8, width / 8 * 5 + 6, height / 4 * 3, null);
		g.drawImage(add, width / 8, height / 8 * 3, width / 8, height / 8, null);
		g.drawImage(sub, width / 4, height / 8 * 3, width / 8, height / 8, null);
		g.drawImage(mlt, width / 8, height / 2, width / 8, height / 8, null);
		g.drawImage(div, width / 4, height / 2, width / 8, height / 8, null);
		g.drawImage(eql, width / 4, height / 8 * 5, width / 8, height / 8, null);
		g.drawImage(back,  0, 0, width / 8, height / 8, null);
		g.setColor(midBlue);
		g.fillRect(width / 8 - 3, 0, 6, height / 8 * 5);
		g.fillRect(width / 4 - 3, height / 8 * 3 - 3, 6, height / 4 * 3);
		g.fillRect(width / 8 * 3 - 3, height / 8 - 3, 6, height);
		g.fillRect(0, height / 8 - 3, width, 6);
		g.fillRect(width / 8 - 3, height / 4 - 3, width / 4, 6);
		g.fillRect(0, height / 8 * 3 - 3, width / 8 * 3, 6);
		g.fillRect(width / 8 - 3, height / 2 - 3, width / 4, 6);
		g.fillRect(width / 8 - 3, height / 8 * 5 - 3, width / 4, 6);
		g.fillRect(0, height / 4 * 3 - 3, width / 8 * 3, 6);
		g.fillRect(width / 8 * 3 - 3, height / 8 * 7 - 3, width / 4 * 3, 6);
	}
}
