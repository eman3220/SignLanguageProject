package front;

import javax.imageio.ImageIO;
import javax.swing.*;

import back.SG_five;
import main.SignLanguageProject_Main;
import tests.Test_Player;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class drawExercises extends JPanel implements ActionListener {

	private BufferedImage bg, boxLB, boxGB, boxDB, back, help, title,
			helpDialogue, hs, correctImage;

	public static boolean correct = false;
	private int correctInARow = 0;

	File[] iList, hList;
	public static int hand = 0;

	Color offWhite = new Color(249, 241, 252, 255);
	Color lightBlue = new Color(211, 219, 219, 255);
	Color greyBlue = new Color(121, 128, 151, 255);
	Color midBlue = new Color(72, 59, 128, 255);
	Color darkBlue = new Color(31, 27, 39, 255);

	int width, height, timer;
	float tY, helpX, backX, vidX, inX, b1X, b2X, b3X, b4Y, b5Y, b6Y;

	JButton helpBtn;
	boolean displayHelp = false;

	Timer tm = new Timer(1, this);

	public drawExercises(int wd, int ht) {
		try {
			bg = ImageIO.read(getClass().getResource(
					"/Assets/background_grain.png"));
			boxDB = ImageIO.read(getClass().getResource(
					"/Assets/button_box_darkBlue.png"));
			boxGB = ImageIO.read(getClass().getResource(
					"/Assets/button_box_greyBlue.png"));
			boxLB = ImageIO.read(getClass().getResource(
					"/Assets/button_box_lightBlue.png"));
			back = ImageIO.read(getClass().getResource(
					"/Assets/button_arrow.png"));
			help = ImageIO.read(getClass().getResource(
					"/Assets/button_help.png"));
			title = ImageIO.read(getClass().getResource(
					"/Assets/title_exercises.png"));
			helpDialogue = ImageIO.read(getClass().getResource(
					"/Assets/exercises_explanation.png"));
			correctImage = ImageIO.read(getClass().getResource(
					"/Assets/answers/answers_correct.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		tY = 0 - ht / 8;
		backX = 0 - wd / 8;
		helpX = wd;
		vidX = wd;
		inX = 0 - wd / 2;

		helpBtn = new JButton();
		helpBtn.setText(null);
		helpBtn.setBounds(wd / 8 * 7, 0, wd / 8, ht / 8);
		helpBtn.setBorderPainted(false);
		helpBtn.setFocusPainted(false);
		helpBtn.setContentAreaFilled(false);
		helpBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				displayHelp = !displayHelp;
				repaint();
			}
		});

		File h = new File("src/Assets/handshapes/");
		hList = h.listFiles();
		// System.out.println(hList.length);
		// System.out.println(hList[hand].toString());

		String hsFile = hList[hand].toString();
		hsFile = hsFile.substring(22, 37);

		repaint();
	}

	// Main paint method
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		width = this.getWidth();
		height = this.getHeight();

		if(correct){
			return;
		}

		String hsFile = hList[hand].toString();
		hsFile = hsFile.substring(22, 37);

		try {
			hs = ImageIO.read(getClass().getResource(
					"/Assets/handshapes/" + hsFile + ".png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		g.drawImage(bg, 0, 0, width, height, null);
		g.drawImage(boxDB, (int) backX, 0, width / 8, height / 8, null);
		g.drawImage(boxDB, (int) vidX, height / 4, width / 2, height / 8 * 5,
				null);
		g.drawImage(boxGB, (int) inX, height / 4, width / 2, height / 8 * 5,
				null);
		g.drawImage(boxLB, (int) helpX, 0, width / 8 + 10, height / 8, null);
		g.drawImage(back, (int) backX, 0, width / 8, height / 8, null);
		g.drawImage(help, (int) helpX, 0, width / 8, height / 8, null);
		g.drawImage(title, width / 4 + ((width / 2 - title.getWidth()) / 2),
				(int) tY + 5, title.getWidth(), title.getHeight(), null);
		g.drawImage(hs, (int) (width / 12), (height / 3), (width / 3),
				(height / 3) + 100, null);
		g.setColor(midBlue);
		g.fillRect(0, height / 8 - 3, (int) b1X, 6);
		g.fillRect(width - 3, height / 4 - 3, (int) -b2X, 6);
		g.fillRect(0, height / 8 * 7 - 3, (int) b3X, 6);
		g.fillRect(width / 8 - 3, 0, 6, (int) b4Y);
		g.fillRect(width / 8 * 7 - 3, 0, 6, (int) b5Y);
		g.fillRect(width / 2 - 3, height, 6, (int) -b6Y);
		if (displayHelp)
			g.drawImage(helpDialogue, width / 8 + 3, height / 8 + 3,
					width / 4 * 3 - 9, height / 4 * 3 - 6, null);

		if (timer < 400) {
			this.removeAll();

			tm.start();
			this.add(helpBtn);

		}

		if (timer < 1000) {
			//System.out.println("TIMER");
			if (!Test_Player.working) {
				Test_Player.working = true;
				Test_Player.initialise();
				Test_Player.showVideo((int) width / 2 + (width / 13),
						height / 4 + 100, width / 3 + 100,
						height / 8 * 5 - 200,
						"src/Assets/videos/addition_5.mov");

			}

			if(SignLanguageProject_Main.selected instanceof SG_five){
				correctInARow++;
			}else{
				correctInARow = 0;
			}


			if(correctInARow>=500){
				correct = true;
				correctInARow = 0;
				g.drawImage(correctImage, (int) (width / 12), (height / 3),
						(width / 3), (height / 3) + 100, null);

			}

		}
	}

	public void actionPerformed(ActionEvent e) {
		if (b1X < width)
			b1X += lerp((float) 0.1, (float) 2.0, (float) (width - b1X) / 100);
		if (b2X < width)
			b2X += lerp((float) 0.1, (float) 2.0, (float) (width - b2X) / 100);
		if (b3X < width)
			b3X += lerp((float) 0.1, (float) 2.0, (float) (width - b3X) / 100);
		if (b4Y < height / 4 && b1X > width / 8)
			b4Y += lerp((float) 0.1, (float) 2.0,
					(float) (height / 4 - b4Y) / 100);
		if (b5Y < height / 4)
			b5Y += lerp((float) 0.1, (float) 2.0,
					(float) (height / 4 - b5Y) / 100);
		if (b6Y < height / 8 * 7 && b1X > width / 4)
			b6Y += lerp((float) 0.1, (float) 2.0,
					(float) (height / 8 * 7 - b6Y) / 100);

		if (tY < 0)
			tY += lerp((float) 0.1, (float) 2.0, (float) (0 - tY) / 200);
		if (backX < 0 && tY > 0 - height / 16)
			backX += lerp((float) 0.1, (float) 2.0, (float) (0 - backX) / 200);
		if (helpX > width / 8 * 7 && backX > 0 - width / 16)
			helpX -= lerp((float) 0.1, (float) 2.0,
					(float) (helpX - width / 8 * 7) / 200);
		if (vidX > width / 2 && backX > 0 - width / 16)
			vidX -= lerp((float) 0.1, (float) 2.0,
					(float) (vidX - width / 2) / 200);
		if (inX < 0 && backX > 0 - width / 16)
			inX += lerp((float) 0.1, (float) 2.0, (float) (0 - inX) / 200);

		if (timer < 400)
			timer += 1;

		repaint();
	}

	float lerp(float a, float b, float f) {
		return a + f * (b - a);
	}
}
