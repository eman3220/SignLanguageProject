package front;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class drawMain extends JPanel implements ActionListener {

	private BufferedImage bg, boxLB, boxGB, boxDB, title;

	Color offWhite = new Color(249, 241, 252, 255);
	Color lightBlue = new Color(211, 219, 219, 255);
	Color greyBlue = new Color(121, 128, 151, 255);
	Color midBlue = new Color(72, 59, 128, 255);
	Color darkBlue = new Color(31, 27, 39, 255);

	int width, height;
	float tY, sbsX, nY, erY, etX, b1Y, b2Y, b3Y, b4X, b5X, b6X, b7X, b8X;

	Timer tm = new Timer(1, this);

	public drawMain(int wd, int ht) {
		try {
			bg = ImageIO.read(getClass().getResource("/Assets/background_grain.png"));
			boxDB = ImageIO.read(getClass().getResource("/Assets/button_box_darkBlue.png"));
			boxGB = ImageIO.read(getClass().getResource("/Assets/button_box_greyBlue.png"));
			boxLB = ImageIO.read(getClass().getResource("/Assets/button_box_lightBlue.png"));
			title = ImageIO.read(getClass().getResource("/Assets/title_block_v4.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		tY = 0 - ht / 2;
		sbsX = 0 - wd / 4;
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
		g.drawImage(boxGB, (int) sbsX, height / 8, width / 4, height / 2, null);
		g.drawImage(boxLB, width / 4, (int) nY, width / 4, height / 8 * 3, null);
		g.drawImage(boxGB, width / 2, (int) erY, width / 4, height / 4, null);
		g.drawImage(boxLB, (int) etX, height / 2, width / 4 + 3, height / 4, null);
		g.drawImage(boxDB, width / 4, (int) tY - 1, width / 2, height / 2, null);
		g.drawImage(title,  width / 4 + ((width / 2 - title.getWidth()) / 2), (int) tY + 50, title.getWidth(), title.getHeight(), null);
		g.setFont(new Font("VANI", Font.BOLD, 48));
		g.setColor(darkBlue);
		FontMetrics fm = g.getFontMetrics();
	    Rectangle2D rect = fm.getStringBounds("Search", g);
	    g.drawString("Search", (int)(sbsX + width / 8 - rect.getWidth()/2), (int)(height / 4 + 6));
	    rect = fm.getStringBounds("by", g);
	    g.drawString("by", (int)(sbsX + width / 8 - rect.getWidth()/2), (int)(height / 8 * 3 + 6));
	    rect = fm.getStringBounds("Sign", g);
	    g.drawString("Sign", (int)(sbsX + width / 8 - rect.getWidth()/2), (int)(height / 2 + 6));
	    rect = fm.getStringBounds("Number", g);
		g.drawString("Number", (int) (width / 8 * 3 - rect.getWidth()/2), (int)(nY + height / 8 + 6));
	    rect = fm.getStringBounds("Exercises", g);
	    g.drawString("Exercises", (int) (width / 8 * 5 - rect.getWidth()/2), (int) (erY + height / 8 + 6));
	    rect = fm.getStringBounds("Exit", g);
	    g.drawString("Exit", (int) (etX + width / 8 - rect.getWidth()/2), (int) (height / 8 * 5 + 6));
		g.setColor(midBlue);
		g.fillRect(width / 4 - 3, 0, 6, (int) b1Y);
		g.fillRect(width / 4 * 3 - 3, height, 6, (int) -b2Y);
		g.fillRect(width / 2 - 3, height / 8 * 5, 6, (int) b3Y);
		g.fillRect(width, height / 2 - 3, (int) -b4X, 6);
		g.fillRect(width / 2, height / 8 * 7 - 3, (int) b5X, 6);
		g.fillRect(width, height / 4 * 3 - 3, (int) -b6X, 6);
		g.fillRect(0, height / 8 - 3, (int) b7X, 6);
		g.fillRect(0, height / 8 * 5 - 3, (int) b8X, 6);

		tm.start();
	}

	public void actionPerformed(ActionEvent e) {
		if (b1Y < height)
			b1Y += lerp((float) 0.1, (float) 2.0, (float) (height - b1Y) / 100);
		if (b2Y < height)
			b2Y += lerp((float) 0.1, (float) 2.0, (float) (height - b2Y) / 100);
		if (b3Y < height / 2 + 3 && b8X > width / 2)
			b3Y += lerp((float) 0.1, (float) 2.0, (float) (height / 2 + 3 - b3Y) / 100);
		if (b4X < width / 4 * 3 + 3)
			b4X += lerp((float) 0.1, (float) 2.0, (float) (width / 4 * 3 + 3 - b4X) / 100);
		if (b5X < width / 4 && b3Y > height / 4)
			b5X += lerp((float) 0.1, (float) 2.0, (float) (width / 4 - b5X) / 100);
		if (b6X <  width / 4 + 3 && b4X > width / 8)
			b6X += lerp((float) 0.1, (float) 2.0, (float) (width / 4 + 3 - b6X) / 100);
		if (b7X < width / 4 + 3 && b8X > width / 8)
			b7X += lerp((float) 0.1, (float) 2.0, (float) (width / 4 + 3 - b7X) / 100);
		if (b8X < width / 4 * 3 + 3)
			b8X += lerp((float) 0.1, (float) 2.0, (float) (width / 4 * 3 + 3 - b8X) / 100);
		
		if (tY < 0)
			tY += lerp((float) 0.1, (float) 2.0, (float) (0 - tY) / 200);
		if (sbsX < 0 && tY > 0 - height / 4)
			sbsX += lerp((float) 0.1, (float) 2.0, (float) (0 - sbsX) / 200);
		if (nY > height / 8 * 5 && tY > 0 - height / 8)
			nY -= lerp((float) 0.1, (float) 2.0, (float) (nY - height / 8 * 5) / 200);
		if (erY > height / 8 * 5 && nY < height / 8 * 7)
			erY -= lerp((float) 0.1, (float) 2.0, (float) (erY - height / 8 * 5) / 200);
		if (etX > width / 4 * 3 && sbsX > 0 - width / 8)
			etX -= lerp((float) 0.1, (float) 2.0, (float) (etX - width / 4 * 3) / 200);

		repaint();
	}
	
	float lerp(float a, float b, float f)
	{
	    return a + f * (b - a);
	}
}
