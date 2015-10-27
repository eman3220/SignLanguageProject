package front;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class drawSearch extends JPanel {

	private BufferedImage bg, boxLB, boxGB, boxDB, back, help;

	Color offWhite = new Color(249, 241, 252, 255);
	Color lightBlue = new Color(211, 219, 219, 255);
	Color greyBlue = new Color(121, 128, 151, 255);
	Color midBlue = new Color(72, 59, 128, 255);
	Color darkBlue = new Color(31, 27, 39, 255);

	int width, height;

	public drawSearch() {
		try {
			bg = ImageIO.read(getClass().getResource("/Assets/background_grain.png"));
			boxDB = ImageIO.read(getClass().getResource("/Assets/button_box_darkBlue.png"));
			boxGB = ImageIO.read(getClass().getResource("/Assets/button_box_greyBlue.png"));
			boxLB = ImageIO.read(getClass().getResource("/Assets/button_box_lightBlue.png"));
			back = ImageIO.read(getClass().getResource("/Assets/button_arrow.png"));
			help = ImageIO.read(getClass().getResource("/Assets/button_help.png"));
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
		g.drawImage(boxDB, 0, 0, width / 8, height / 8, null);
		g.drawImage(boxDB, width / 8 * 3, height / 4, width / 2, height / 8 * 5, null);
		g.drawImage(boxGB, width / 8, height / 8 * 3, width / 4, height / 8 * 3, null);
		g.drawImage(boxLB, width / 8 * 7, 0, width / 8 + 10, height / 8, null);
		g.drawImage(back, 0, 0, width / 8, height / 8, null);
		g.drawImage(help, width / 8 * 7, 0, width / 8, height / 8, null);
		g.setColor(midBlue);
		g.fillRect(0, height / 8 - 3, width, 6);
		g.fillRect(width / 8 - 3, height / 4 - 3, width / 4 * 3, 6);
		g.fillRect(width / 8 - 3, height / 8 * 7 - 3, width / 4 * 3, 6);
		g.fillRect(width / 8 - 3, height / 8 * 3 - 3, width / 4, 6);
		g.fillRect(width / 8 - 3, height / 4 * 3 - 3, width / 4, 6);
		g.fillRect(width / 8 - 3, 0, 6, height);
		g.fillRect(width / 8 * 7 - 3, 0, 6, height);
		g.fillRect(width / 8 * 3 - 3, height / 4 - 3, 6, height / 8 * 5);
	}
}
