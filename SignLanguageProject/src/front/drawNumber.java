package front;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class drawNumber extends JPanel implements ActionListener {

	private BufferedImage bg, boxLB, boxGB, boxDB, add, sub, mlt, div, eql, back, title;

	Color offWhite = new Color(249, 241, 252, 255);
	Color lightBlue = new Color(211, 219, 219, 255);
	Color greyBlue = new Color(121, 128, 151, 255);
	Color midBlue = new Color(72, 59, 128, 255);
	Color darkBlue = new Color(31, 27, 39, 255);

	int width, height, timer;
	float tY, addX, subX, mltX, divX, eqlX, twentyX, hundredX, erY, backX, vidX, b1Y, b2Y, b3Y, b4X, b5X, b6X, b7X, b8X,
			b9X, b10X;

	Timer tm = new Timer(1, this);

	public drawNumber(int wd, int ht) {
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
			title = ImageIO.read(getClass().getResource("/Assets/title_number.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		tY = 0 - ht / 8;
		backX = 0 - wd / 8;
		twentyX = 0 - wd / 4;
		hundredX = 0 - wd / 4;
		vidX = wd;
		erY = ht;
		addX = 0 - wd / 4;
		subX = 0 - wd / 8;
		mltX = 0 - wd / 4;
		divX = 0 - wd / 8;
		eqlX = 0 - wd / 4;

		repaint();
	}

	// Main paint method
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		width = this.getWidth();
		height = this.getHeight();
		g.drawImage(bg, 0, 0, width, height, null);
		g.drawImage(boxGB, (int) addX, height / 8 * 3, width / 8, height / 8, null);
		g.drawImage(boxGB, (int) subX, height / 8 * 3, width / 8, height / 8, null);
		g.drawImage(boxGB, (int) mltX, height / 2, width / 8, height / 8, null);
		g.drawImage(boxGB, (int) divX, height / 2, width / 8, height / 8, null);
		g.drawImage(boxGB, (int) eqlX, height / 8 * 5, width / 8, height / 8, null);
		g.drawImage(boxLB, (int) twentyX, height / 8, width / 4, height / 8, null);
		g.drawImage(boxLB, (int) hundredX, height / 4, width / 4, height / 8, null);
		g.drawImage(boxLB, 0, (int) erY, width / 4, height / 4, null);
		g.drawImage(boxDB, (int) backX, 0, width / 8, height / 8, null);
		g.drawImage(boxDB, (int) vidX, height / 8, width / 8 * 5 + 6, height / 4 * 3, null);
		g.drawImage(add, (int) addX, height / 8 * 3, width / 8, height / 8, null);
		g.drawImage(sub, (int) subX, height / 8 * 3, width / 8, height / 8, null);
		g.drawImage(mlt, (int) mltX, height / 2, width / 8, height / 8, null);
		g.drawImage(div, (int) divX, height / 2, width / 8, height / 8, null);
		g.drawImage(eql, (int) eqlX, height / 8 * 5, width / 8, height / 8, null);
		g.drawImage(back, (int) backX, 0, width / 8, height / 8, null);
		g.drawImage(title, width / 4 + ((width / 2 - title.getWidth()) / 2), (int) tY + 5, title.getWidth(), title.getHeight(), null);

		g.setColor(darkBlue);
		g.setFont(new Font("VANI", Font.BOLD, 48));
		FontMetrics fm = g.getFontMetrics();
		Rectangle2D rect = fm.getStringBounds("Exercises", g);
		g.drawString("Exercises", (int) (width / 8 - rect.getWidth() / 2), (int) (erY + height / 8 + 6));
		g.setFont(new Font("EBRIMA", Font.BOLD, 42));
		rect = fm.getStringBounds("0 - 20", g);
		g.drawString("0 - 20", (int) (twentyX + width / 8 + 12 - rect.getWidth() / 2), (int) (height / 16 * 3 + 15));
		rect = fm.getStringBounds("10 - 100", g);
		g.drawString("10 - 100", (int) (hundredX + width / 8 + 12 - rect.getWidth() / 2), (int) (height / 16 * 5 + 15));

		g.setColor(midBlue);
		g.fillRect(width / 8 - 3, 0, 6, (int) b1Y);
		g.fillRect(width / 4 - 3, height + 3, 6, (int) -b2Y);
		g.fillRect(width / 8 * 3 - 3, height + 3, 6, (int) -b3Y);
		g.fillRect(0, height / 8 - 3, (int) b4X, 6);
		g.fillRect(width / 8 * 3 + 3, height / 4 - 3, (int) -b5X, 6);
		g.fillRect(0, height / 8 * 3 - 3, (int) b6X, 6);
		g.fillRect(width / 8 * 3 + 3, height / 2 - 3, (int) -b7X, 6);
		g.fillRect(width / 8 - 3, height / 8 * 5 - 3, (int) b8X, 6);
		g.fillRect(0, height / 4 * 3 - 3, (int) b9X, 6);
		g.fillRect(width, height / 8 * 7 - 3, (int) -b10X, 6);

		if (timer < 400) {
			tm.start();
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (b1Y < height / 8 * 5)
			b1Y += lerp((float) 0.1, (float) 2.0, (float) (height / 8 * 5 - b1Y) / 100);
		if (b2Y < height / 8 * 5 + 3 && b3Y > height / 8)
			b2Y += lerp((float) 0.1, (float) 2.0, (float) (height / 8 * 5 + 3 - b2Y) / 100);
		if (b3Y < height / 8 * 7 + 3 && b1Y > height / 8)
			b3Y += lerp((float) 0.1, (float) 2.0, (float) (height / 8 * 7 + 3 - b3Y) / 100);
		if (b4X < width && b1Y > height / 8)
			b4X += lerp((float) 0.1, (float) 2.0, (float) (width - b4X) / 100);
		if (b5X < width / 4 && b3Y > height / 4 * 3)
			b5X += lerp((float) 0.1, (float) 2.0, (float) (width / 4 - b5X) / 100);
		if (b6X < width / 8 * 3 && b1Y > height / 8 * 3)
			b6X += lerp((float) 0.1, (float) 2.0, (float) (width / 8 * 3 - b6X) / 100);
		if (b7X < width / 4 && b3Y > height / 2)
			b7X += lerp((float) 0.1, (float) 2.0, (float) (width / 4 - b7X) / 100);
		if (b8X < width / 4 && b1Y > height / 2)
			b8X += lerp((float) 0.1, (float) 2.0, (float) (width / 4 - b8X) / 100);
		if (b9X < width / 8 * 3 && b1Y > height / 2)
			b9X += lerp((float) 0.1, (float) 2.0, (float) (width / 8 * 3 - b9X) / 100);
		if (b10X < width / 8 * 5 + 3 && b1Y > height / 2)
			b10X += lerp((float) 0.1, (float) 2.0, (float) (width / 8 * 5 + 3 - b10X) / 100);

		if (addX < width / 8 && mltX > 0)
			addX += lerp((float) 0.1, (float) 2.0, (float) (width / 8 - addX) / 100);
		if (subX < width / 4)
			subX += lerp((float) 0.1, (float) 2.0, (float) (width / 4 - subX) / 100);
		if (mltX < width / 8 && eqlX > width / 8)
			mltX += lerp((float) 0.1, (float) 2.0, (float) (width / 8 - mltX) / 100);
		if (divX < width / 4 && subX > width / 8)
			divX += lerp((float) 0.1, (float) 2.0, (float) (width / 4 - divX) / 100);
		if (eqlX < width / 4 && divX > width / 8)
			eqlX += lerp((float) 0.1, (float) 2.0, (float) (width / 4 - eqlX) / 100);

		if (tY < 0)
			tY += lerp((float) 0.1, (float) 2.0, (float) (0 - tY) / 200);
		if (backX < 0)
			backX += lerp((float) 0.1, (float) 2.0, (float) (0 - backX) / 200);
		if (twentyX < width / 8)
			twentyX += lerp((float) 0.1, (float) 2.0, (float) (width / 8 - twentyX) / 200);
		if (hundredX < width / 8 && subX > 0)
			hundredX += lerp((float) 0.1, (float) 2.0, (float) (width / 8 - hundredX) / 200);
		if (vidX > width / 8 * 3)
			vidX -= lerp((float) 0.1, (float) 2.0, (float) (vidX - width / 8 * 3) / 200);
		if (erY > height / 4 * 3 && divX > 0)
			erY -= lerp((float) 0.1, (float) 2.0, (float) (erY - height / 4 * 3) / 200);

		if(timer < 400) timer += 1;
		
		repaint();
	}
	
	float lerp(float a, float b, float f)
	{
	    return a + f * (b - a);
	}
}
