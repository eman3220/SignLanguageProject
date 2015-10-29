package front;

import javax.imageio.ImageIO;
import javax.swing.*;

import main.SignLanguageProject_Main;
import back.Sign;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class drawSearch extends JPanel implements ActionListener {

	private BufferedImage bg, boxLB, boxGB, boxMB, boxDB, back, help, title,
			hs, helpDialogue;

	File[] iList, hList;

	Color offWhite = new Color(249, 241, 252, 255);
	Color lightBlue = new Color(211, 219, 219, 255);
	Color greyBlue = new Color(121, 128, 151, 255);
	Color midBlue = new Color(72, 59, 128, 255);
	Color darkBlue = new Color(31, 27, 39, 255);

	public static int hand = 0;

	int width, height, illustration = 0, timer;
	float tY, backX, helpX, handX, comboX, filterX, scrollX, b1Y, b2Y, b3Y,
			b4Y, b5X;

	JComboBox location = makeComboBox();

	JPanel resultsPanel;

	JScrollPane sp = makeScrollPane();

	JButton helpBtn;
	boolean displayHelp = false;

	JLabel[] illustrations;

	Timer tm = new Timer(1, this);

	// public ArrayList<Sign> resultSigns = new ArrayList<Sign>();
	//
	// public void addSign(Sign s) {
	// resultSigns.add(s);
	// }
	//
	// public void clearSigns() {
	// resultSigns = new ArrayList<Sign>();
	// }

	public drawSearch(int wd, int ht) {

		this.setLayout(null);

		// resultsPanel.setBounds(width / 8 * 3 + 50, height / 4 + 50, width / 2
		// - 100, height / 8 * 5 - 100);
		resultsPanel.setBackground(Color.WHITE);

		// sp = new JScrollPane(resultsPanel);

		// this.add(sp);

		File i = new File("src/Assets/illustrations/");
		iList = i.listFiles();
		// System.out.println(iList.length);
		// System.out.println(iList[illustration].toString());

		File h = new File("src/Assets/handshapes/");
		hList = h.listFiles();
		// System.out.println(hList.length);
		// System.out.println(hList[hand].toString());

		String hsFile = hList[hand].toString();
		hsFile = hsFile.substring(22, 37);
		// System.out.println(hsFile);

		illustrations = new JLabel[iList.length];
		String ilFile;
		ilFile = iList[0].toString();
		ilFile = ilFile.substring(25, ilFile.length());

		try {
			bg = ImageIO.read(getClass().getResource(
					"/Assets/background_grain.png"));
			boxDB = ImageIO.read(getClass().getResource(
					"/Assets/button_box_darkBlue.png"));
			boxMB = ImageIO.read(getClass().getResource(
					"/Assets/button_box_midBlue.png"));
			boxGB = ImageIO.read(getClass().getResource(
					"/Assets/button_box_greyBlue.png"));
			boxLB = ImageIO.read(getClass().getResource(
					"/Assets/button_box_lightBlue.png"));
			back = ImageIO.read(getClass().getResource(
					"/Assets/button_arrow.png"));
			help = ImageIO.read(getClass().getResource(
					"/Assets/button_help.png"));
			title = ImageIO.read(getClass().getResource(
					"/Assets/title_search.png"));
			hs = ImageIO.read(getClass().getResource(
					"/Assets/handshapes/" + hsFile + ".png"));
			helpDialogue = ImageIO.read(getClass().getResource(
					"/Assets/sbs_explanation.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		tY = 0 - ht / 8;
		backX = 0 - wd / 8;
		helpX = wd;
		handX = 0 - 200;
		comboX = 0 - 200;
		filterX = 0 - wd / 4;
		scrollX = wd;

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

		repaint();
	}

	private JScrollPane makeScrollPane() {
		// create panel
		this.resultsPanel = new JPanel();

		// create sp
		this.sp = new JScrollPane(resultsPanel);

		return sp;
	}

	// Main paint method
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		width = this.getWidth();
		height = this.getHeight();

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
		g.drawImage(boxGB, (int) scrollX, height / 8, width / 16,
				height / 8 * 7, null);
		g.drawImage(boxGB, (int) filterX, height / 8, width / 4,
				height / 8 * 7, null);
		g.drawImage(boxMB, (int) handX - 106, height / 8 * 3 - 106, 212, 212,
				null);
		g.drawImage(boxMB, (int) comboX - 106, height / 4 * 3 - 106, 212, 212,
				null);
		g.drawImage(boxLB, (int) helpX, 0, width / 8, height / 8, null);
		g.drawImage(back, (int) backX, 0, width / 8, height / 8, null);
		g.drawImage(help, (int) helpX, 0, width / 8, height / 8, null);
		g.drawImage(title, width / 4 + ((width / 2 - title.getWidth()) / 2),
				(int) tY, title.getWidth(), title.getHeight(), null);
		g.drawImage(hs, (int) handX - 100, height / 8 * 3 - 100, 200, 200, null);
		g.setColor(midBlue);
		g.fillRect(width / 8 - 3, 0, 6, (int) b1Y);
		g.fillRect(width / 4 - 3, height, 6, (int) -b2Y);
		g.fillRect(width / 16 * 15 - 3, height, 6, (int) -b3Y);
		g.fillRect(width / 8 * 7 - 3, 0, 6, (int) b4Y);
		g.fillRect(0, height / 8 - 3, (int) b5X, 6);
		if (displayHelp)
			g.drawImage(helpDialogue, width / 4, height / 8, width / 16 * 11,
					height / 16 * 11, null);

		if (timer < 600) {
			//System.out.println("Drawing");

			tm.start();
			this.add(location);
			this.add(helpBtn);
			this.add(sp);
			location.setBounds((int) comboX - 100, height / 4 * 3 - 100, 200,
					200);
			sp.setBounds(width / 8 * 2 + 15, height / 6, width - (width / 3),
					height / 8 * 5);

			// add the list of signs as JPanels
			resultsPanel.setLayout(new GridLayout(5, 1));

			resultsPanel.removeAll();

			if (SignLanguageProject_Main.selected != null) {
				System.out.println(SignLanguageProject_Main.selected);
				ArrayList<Sign> resultSigns = SignLanguageProject_Main.selected
						.getAssociatedSigns();
				System.out.println(resultSigns.size());
				for (Sign sign : resultSigns) {
					System.out.println("Here is a sign "+sign.getName());
					// create JPanel
					JPanel pan = new JPanel();
					pan.setBorder(BorderFactory.createLineBorder(Color.black));
					pan.setLayout(new GridLayout(1, 1));

					// add name of sign
					//pan.add(new JLabel(sign.getName()));

					// add image of sign

					try {
						System.out.println(sign.getAssets()[0].exists());
						BufferedImage signImg = ImageIO
								.read(sign.getAssets()[0]);
						JLabel picLabel = new JLabel(new ImageIcon(signImg));
						pan.add(picLabel);

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					// JPanel pan = new JPanel();
					// pan.setBackground(Color.PINK);
					// pan.setBounds(0, 0, 100, 100);

					resultsPanel.add(pan);

					// add video of sign

					// add JPanel to resultsPanel
				}
			}

		}
	}

	public void actionPerformed(ActionEvent e) {
		if (b1Y < height / 8 + 3 && b5X > width / 8)
			b1Y += lerp((float) 0.1, (float) 2.0,
					(float) (height / 8 + 3 - b1Y) / 100);
		if (b2Y < height / 8 * 7 + 3)
			b2Y += lerp((float) 0.1, (float) 2.0,
					(float) (height / 8 * 7 + 3 - b2Y) / 100);
		if (b3Y < height / 8 * 7 + 3 && b5X > width / 2)
			b3Y += lerp((float) 0.1, (float) 2.0,
					(float) (height / 8 * 7 + 3 - b3Y) / 100);
		if (b4Y < height / 8 + 3 && b5X > width / 8 * 7)
			b4Y += lerp((float) 0.1, (float) 2.0,
					(float) (height / 8 + 3 - b4Y) / 100);
		if (b5X < width)
			b5X += lerp((float) 0.1, (float) 2.0, (float) (width - b5X) / 100);

		if (tY < 0)
			tY += lerp((float) 0.1, (float) 2.0, (float) (0 - tY) / 200);
		if (backX < 0 && tY > 0 - height / 16)
			backX += lerp((float) 0.1, (float) 2.0, (float) (0 - backX) / 200);
		if (helpX > width / 8 * 7 && backX > 0 - width / 16)
			helpX -= lerp((float) 0.1, (float) 2.0,
					(float) (helpX - width / 8 * 7) / 200);
		if (handX < width / 8 && filterX > 0 - width / 8)
			handX += lerp((float) 0.1, (float) 2.0,
					(float) (width / 8 - handX) / 200);
		if (comboX < width / 8 && filterX > 0 - width / 4)
			comboX += lerp((float) 0.1, (float) 2.0,
					(float) (width / 8 - comboX) / 200);
		if (filterX < 0 && backX > 0 - width / 16)
			filterX += lerp((float) 0.1, (float) 2.0,
					(float) (0 - filterX) / 200);
		if (scrollX > width / 16 * 15 && handX > 0)
			scrollX -= lerp((float) 0.1, (float) 2.0,
					(float) (scrollX - width / 16 * 15) / 200);

		if (timer < 600)
			timer += 1;

		repaint();
	}

	// Makes icon combobox
	public JComboBox makeComboBox() {
		JComboBox cb;
		Object[] items = {
				new ImageIcon(getClass().getResource(
						"/Assets/location_anywhere.png")),
				new ImageIcon(getClass().getResource(
						"/Assets/location_ears.png")),
				new ImageIcon(getClass().getResource(
						"/Assets/location_in_front_of_body.png")),
				new ImageIcon(getClass().getResource(
						"/Assets/location_top_of_head.png")) };
		cb = new JComboBox(items);
		return cb;
	}

	float lerp(float a, float b, float f) {
		return a + f * (b - a);
	}
}