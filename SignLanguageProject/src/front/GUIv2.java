package front;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.Border;

import back.LeapController;
import back.LeapTest02;

public class GUIv2 {

	public JFrame frame = new JFrame("NZSL Virtual Classroom");
	int width, height;

	JPanel panelCont = new JPanel();
	JPanel baseMenu = new JPanel();
	JPanel numberMenu = new JPanel();
	JPanel exerciseMenu = new JPanel();
	JPanel searchMenu = new JPanel();

	JButton buttonNumber, buttonExercises, buttonSearch, buttonExit, buttonHomeNumber, buttonExercisesNumber,
			button0_20, button10_100, add, subtract, multiply, divide, equals, buttonHomeExercises, buttonHelpExercises,
			buttonHomeSearch, buttonHelpSearch;

	static JTextArea leapConsole = makeConsole();
	static JScrollPane sp;

	JLabel titleIcon, numberTitleIcon, exerciseTitleIcon, searchTitleIcon, bg, resultsTitleIcon, textFieldIcon,
			exerciseHelpDialogue, searchHelpDialogue;

	JComboBox refine = makeComboBox();
	int refineValue;


	Image exerciseHelp, searchHelp;

	Dimension screen;

	boolean exerciseHelpVisible = false;
	boolean searchHelpVisible = false;

	CardLayout cl = new CardLayout();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIv2 window = new GUIv2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUIv2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		panelCont.setLayout(cl);
		screen = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		if (screen.getWidth() > 1850) {
			screen = new Dimension(1920, 1080);
		}
		frame.setSize(screen);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		createBaseMenu();

		panelCont.add(baseMenu, "baseMenu");
		panelCont.add(numberMenu, "numberMenu");
		panelCont.add(exerciseMenu, "exerciseMenu");
		panelCont.add(searchMenu, "searchMenu");

		cl.show(panelCont, "baseMenu");

		frame.add(panelCont);
	}

	// Makes a blank button for navigating the menu
	public JButton makeButton(String name, int xPos, int yPos, int wid, int hei) {
		JButton jb = new JButton(name);
		jb.setLocation(xPos, yPos);
		jb.setSize(wid, hei);
		jb.setBorderPainted(false);
		jb.setFocusPainted(false);
		jb.setContentAreaFilled(false);
		return jb;
	}

	// Makes icon combobox
	public JComboBox makeComboBox() {
		JComboBox cb;
		Object[] items =
		{
				new ImageIcon(getClass().getResource("/Assets/location_anywhere.png")),
				new ImageIcon(getClass().getResource("/Assets/location_ears.png")),
				new ImageIcon(getClass().getResource("/Assets/location_in_front_of_body.png")),
				new ImageIcon(getClass().getResource("/Assets/location_top_of_head.png"))
				};
		cb = new JComboBox(items);
		return cb;
	}

	private static JTextArea makeConsole() {
		JTextArea console = new JTextArea();
		return console;
	}

	// Image scaling code from online
	// (http://stackoverflow.com/questions/6714045/how-to-resize-jlabel-imageicon)
	private Image getScaledImage(Image srcImg, int w, int h) {
		BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = resizedImg.createGraphics();

		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(srcImg, 0, 0, w, h, null);
		g2.dispose();

		return resizedImg;
	}

	// Makes the main menu panel
	public void createBaseMenu() {
		// Layout
		baseMenu.setLayout(null);
		width = frame.getWidth();
		height = frame.getHeight();
		// Buttons
		buttonNumber = makeButton(null, width / 4, height / 8 * 5, width / 4, height / 4);
		buttonExercises = makeButton(null, width / 2, height / 8 * 5, width / 4, height / 4);
		buttonSearch = makeButton(null, 0, height / 8, width / 4, height / 2);
		buttonExit = makeButton(null, width / 4 * 3, height / 2, width / 4, height / 4);
		baseMenu.add(buttonNumber);
		baseMenu.add(buttonExercises);
		baseMenu.add(buttonSearch);
		baseMenu.add(buttonExit);
		// Button functionality
		buttonNumber.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				createNumberMenu();
				cl.show(panelCont, "numberMenu");
				baseMenu.removeAll();
			}
		});
		buttonExercises.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				createExerciseMenu();
				cl.show(panelCont, "exerciseMenu");
				baseMenu.removeAll();
			}
		});
		buttonSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				createSearchMenu();
				cl.show(panelCont, "searchMenu");

				// start using leap
				Thread t = new Thread() {
					@Override
					public void run() {
						System.out.println("THREAD STARTED");
						LeapController.initialise();
						LeapController.classify();
					}
				};
				t.start();
				System.out.println("Past thread start");
				baseMenu.removeAll();

			}
		});
		buttonExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		drawMain drawObject = new drawMain(width, height);
		drawObject.setBounds(0, 0, width, height);
		baseMenu.add(drawObject);
	}

	// Makes the Number menu panel
	private void createNumberMenu() {
		// Layout
		numberMenu.setLayout(null);
		width = frame.getWidth();
		height = frame.getHeight();
		// Buttons
		buttonHomeNumber = makeButton(null, 0, 0, width / 8, height / 8);
		buttonExercisesNumber = makeButton(null, 0, height / 4 * 3, width / 4, height / 4);
		button0_20 = makeButton(null, width / 8, height / 8, width / 4, height / 8);
		button10_100 = makeButton(null, width / 8, height / 4, width / 4, height / 8);
		add = makeButton(null, width / 8, height / 8 * 3, width / 8, height / 8);
		subtract = makeButton(null, width / 4, height / 8 * 3, width / 8, height / 8);
		multiply = makeButton(null, width / 8, height / 2, width / 8, height / 8);
		divide = makeButton(null, width / 4, height / 2, width / 8, height / 8);
		equals = makeButton(null, width / 4, height / 8 * 5, width / 8, height / 8);
		numberMenu.add(buttonHomeNumber);
		numberMenu.add(buttonExercisesNumber);
		numberMenu.add(button0_20);
		numberMenu.add(button10_100);
		numberMenu.add(add);
		numberMenu.add(subtract);
		numberMenu.add(multiply);
		numberMenu.add(divide);
		numberMenu.add(equals);
		// Button functionality
		buttonHomeNumber.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				createBaseMenu();
				cl.show(panelCont, "baseMenu");
				numberMenu.removeAll();
			}
		});
		buttonExercisesNumber.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				createExerciseMenu();
				cl.show(panelCont, "exerciseMenu");
				numberMenu.removeAll();
			}
		});
		button0_20.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Display '0 - 20' video.");
			}
		});
		button10_100.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Display '10 - 100' video.");
			}
		});
		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Display 'add' video.");
			}
		});
		subtract.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Display 'subtract' video.");
			}
		});
		multiply.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Display 'multiply' video.");
			}
		});
		divide.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Display 'divide' video.");
			}
		});
		equals.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Display 'equals' video.");
			}
		});
		drawNumber drawObject = new drawNumber(width, height);
		drawObject.setBounds(0, 0, width, height);
		numberMenu.add(drawObject);
	}

	// Makes the Exercises menu panel
	private void createExerciseMenu() {
		// Layout
		exerciseMenu.setLayout(null);
		width = frame.getWidth();
		height = frame.getHeight();
		// Buttons
		buttonHomeExercises = makeButton(null, 0, 0, width / 8, height / 8);
		exerciseMenu.add(buttonHomeExercises);
		// Button functionality
		buttonHomeExercises.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				createBaseMenu();
				cl.show(panelCont, "baseMenu");
				exerciseMenu.removeAll();
			}
		});
		drawExercises drawObject = new drawExercises(width, height);
		drawObject.setBounds(0, 0, width, height);
		exerciseMenu.add(drawObject);
	}

	// Makes the Search by Sign menu panel
	private void createSearchMenu() {
		// Layout
		searchMenu.setLayout(null);
		width = frame.getWidth();
		height = frame.getHeight();
		// Buttons
		buttonHomeSearch = makeButton(null, 0, 0, width / 8, height / 8);
		searchMenu.add(buttonHomeSearch);
		// Console
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		leapConsole.setBorder(border);
		sp = new JScrollPane(leapConsole);
		sp.setBounds(width / 8 * 3 + 50, height / 4 + 50, width / 2 - 100, height / 8 * 5 - 100);
		searchMenu.add(sp);
		// Button functionality
		buttonHomeSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				createBaseMenu();
				cl.show(panelCont, "baseMenu");
				searchMenu.removeAll();
			}
		});
		log("Search by sign initialisation complete");
		log("Welcome");
		log("");
		drawSearch drawObject = new drawSearch(width, height);
		drawObject.setBounds(0, 0, width, height);
		searchMenu.add(drawObject);
	}

	public static void log(String message) {
		leapConsole.append(message);
		JScrollBar vertical = sp.getVerticalScrollBar();
		vertical.setValue(vertical.getMaximum());
	}
}
