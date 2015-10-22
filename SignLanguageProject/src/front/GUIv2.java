package front;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
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
//<<<<<<< HEAD
import javax.swing.JTextField;
import javax.swing.SwingConstants;
//=======
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
//>>>>>>> branch 'master' of https://github.com/eman3220/SignLanguageProject.git
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.Border;

import back.LeapTest02;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class GUIv2 {

	public JFrame frame = new JFrame("NZSL Virtual Classroom");

	JPanel panelCont = new JPanel();
	JPanel baseMenu = new JPanel();
	JPanel numeracyMenu = new JPanel();
	JPanel exerciseMenu = new JPanel();
	JPanel searchMenu = new JPanel();
	
	JButton buttonNumeracy = makeButton("Numeracy Basics");
	JButton buttonExercises = makeButton("Exercises");
	JButton buttonSearch = makeButton("Search by Sign");
	JButton buttonExit = makeButton("Exit");
	JButton buttonHomeNumeracy = makeBack();
	JButton buttonExercisesNumeracy = makeButton("Exercises");
	JButton add = makeBack();
	JButton subtract = makeBack();
	JButton multiply = makeBack();
	JButton divide = makeBack();
	JButton equals = makeBack();
	JButton buttonHomeExercises = makeBack();
	JButton buttonHelpExercises = makeHelp();
	JButton buttonHomeSearch = makeBack();
	JButton buttonHelpSearch = makeHelp();

	static JTextArea leapConsole = makeConsole();
	static JScrollPane sp;

	JLabel titleIcon;
	JLabel numeracyTitleIcon;
	JLabel exerciseTitleIcon;
	JLabel searchTitleIcon;
	JLabel resultsTitleIcon;
	JLabel textFieldIcon;
	JLabel helpDialogue;
	JLabel bg;

	JComboBox refine = makeComboBox();
	int refineValue;
	
	JTextField number = makeTextField();
	
	Image image;
	
	BufferedImage titleImage;
	BufferedImage background;

	Dimension screen;

	//Media media;
	//MediaPlayer mediaPlayer;

	boolean helpVisible = false;

	Color offWhite = new Color(252, 243, 255, 255);
	Color lightBlue = new Color(219, 229, 229, 255);
	Color greyBlue = new Color(108, 122, 170, 255);
	Color midBlue = new Color(51, 34, 153, 255);
	Color darkBlue = new Color(23, 18, 33, 255);

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
		frame.setSize(screen);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//BaseMenu baseMenu = new BaseMenu();
		
		createBaseMenu();
		createNumeracyMenu();
		createExerciseMenu();
		createSearchMenu();

		panelCont.add(baseMenu, "baseMenu");
		panelCont.add(numeracyMenu, "numeracyMenu");
		panelCont.add(exerciseMenu, "exerciseMenu");
		panelCont.add(searchMenu, "searchMenu");
		
		cl.show(panelCont, "baseMenu");

		frame.add(panelCont);
		
		//draw drawObject = new draw();
		//baseMenu.add(drawObject);
	}

	// Makes a blank button for navigating the menu
	public JButton makeButton(String name) {
		JButton jb = new JButton(name);
		jb.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/Assets/button_blank_dark.png")));
		jb.setHorizontalTextPosition(JButton.CENTER);
		jb.setVerticalTextPosition(JButton.CENTER);
		jb.setBorderPainted(false);
		jb.setFocusPainted(false);
		jb.setContentAreaFilled(false);
		jb.setForeground(new Color(219, 229, 229, 255)); // for whatever reason
															// referencing
															// "lightBlue" was
															// turning it grey
		jb.setFont(new Font("OREGON LDO LIGHT", Font.PLAIN, 28));
		return jb;
	}

	// Makes a button for returning to the prior screen
	public JButton makeBack() {
		JButton jb = new JButton();
		jb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/button - backV2.png")));
		jb.setBorderPainted(false);
		jb.setFocusPainted(false);
		jb.setContentAreaFilled(false);
		return jb;
	}
	
	//Makes icon combobox
    public JComboBox makeComboBox(){
    	JComboBox cb;
    	Object[] items =
    		{
    			new ImageIcon(getClass().getResource("/Assets/location_anywhere.png")),
    			new ImageIcon(getClass().getResource("/Assets/location_ears.png")),
    			new ImageIcon(getClass().getResource("/Assets/location_in_front_of_body.png")),
    			new ImageIcon(getClass().getResource("/Assets/location_top_of_head.png"))
            };
        cb = new JComboBox( items );
        return cb;
    }
    
    //Makes text input field
    public JTextField makeTextField(){
    	JTextField tf = new JTextField("0");
    	tf.setFont(new Font("OREGON LDO LIGHT", Font.PLAIN, 28));
    	tf.setOpaque(false);
    	tf.setForeground(new Color(219, 229, 229, 255));
		tf.setBackground(new Color(0, 0, 0, 0));
		tf.setBorder(null);
		return tf;
    	
    }

	// Makes a button for help
	public JButton makeHelp() {
		JButton jb = new JButton();
		jb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/button - help.png")));
		jb.setBorderPainted(false);
		jb.setFocusPainted(false);
		jb.setContentAreaFilled(false);
		return jb;
	}

	private static JTextArea makeConsole() {
		JTextArea console = new JTextArea();
		return console;
	}

	// Makes the main menu panel
	private void createBaseMenu() {
		// Layout
		baseMenu.setLayout(null);
		// Title
		titleIcon = new JLabel(new javax.swing.ImageIcon(getClass().getResource("/Assets/title_block.png")));
		baseMenu.add(titleIcon);
		titleIcon.setBounds(frame.getWidth()/2 - 512, 0, 1024, 256);
		// Buttons
		baseMenu.add(buttonNumeracy);
		buttonNumeracy.setBounds(frame.getWidth()/2 - 241, frame.getHeight()/20*7, 482, 89);
		baseMenu.add(buttonExercises);
		buttonExercises.setBounds(frame.getWidth()/2 - 241, frame.getHeight()/20*7+100, 482, 89);
		baseMenu.add(buttonSearch);
		buttonSearch.setBounds(frame.getWidth()/2 - 241, frame.getHeight()/20*7+200, 482, 89);
		baseMenu.add(buttonExit);
		buttonExit.setBounds(frame.getWidth()/2 - 241, frame.getHeight()/20*7+300, 482, 89);
		// Button functionality
		buttonNumeracy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "numeracyMenu");
			}
		});		
		buttonExercises.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0){
				cl.show(panelCont, "exerciseMenu");
			}
		});
		buttonSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "searchMenu");
				
				// start using leap
				Thread t = new Thread(){
					@Override
					public void run(){
						System.out.println("THREAD STARTED");
						LeapTest02.initialise();
						LeapTest02.classify();
					}
				};
				t.start();
				System.out.println("Past thread start");
				
			}
		});
		buttonExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		draw drawObject = new draw();
		drawObject.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		baseMenu.add(drawObject);
	}

	// Makes the Numeracy menu panel
	private void createNumeracyMenu() {
		// Layout
		numeracyMenu.setLayout(null);
		// Title
		numeracyTitleIcon = new JLabel(new javax.swing.ImageIcon(getClass()
				.getResource("/Assets/Title - Numeracy.png")));
		numeracyMenu.add(numeracyTitleIcon);
		numeracyTitleIcon.setBounds(frame.getWidth() / 2 - 290,
				frame.getHeight() / 30, 580, 90);
		// Buttons
		numeracyMenu.add(buttonHomeNumeracy);
		buttonHomeNumeracy.setBounds(frame.getHeight()/30, frame.getHeight()/30, 69, 68);
		numeracyMenu.add(buttonExercisesNumeracy);
		buttonExercisesNumeracy.setBounds(30, frame.getHeight()/2+50, 482, 89);
		numeracyMenu.add(add);
		add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/button_add.png")));
		add.setBounds(30, frame.getHeight()/2-50, 88, 88);
		numeracyMenu.add(subtract);
		subtract.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/button_subtract.png")));
		subtract.setBounds(128, frame.getHeight()/2-50, 88, 88);
		numeracyMenu.add(multiply);
		multiply.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/button_multiply.png")));
		multiply.setBounds(226, frame.getHeight()/2-50, 88, 88);
		numeracyMenu.add(divide);
		divide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/button_divide.png")));
		divide.setBounds(324, frame.getHeight()/2-50, 88, 88);
		numeracyMenu.add(equals);
		equals.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/button_equals.png")));
		equals.setBounds(422, frame.getHeight()/2-50, 88, 88);
		//Text field
    	textFieldIcon = new JLabel(new javax.swing.ImageIcon(getClass().getResource("/Assets/text input field.png")));
    	textFieldIcon.setBounds(30, frame.getHeight()/2-150, 482, 89);
		number.setBounds(50, frame.getHeight()/2-150, 442, 89);
		number.setHorizontalAlignment(SwingConstants.CENTER);
		numeracyMenu.add(number);
    	numeracyMenu.add(textFieldIcon);
		buttonHomeNumeracy.setBounds(frame.getHeight() / 30, frame.getHeight() / 30, 69, 68);
		//Media
		//media = new Media("/Assets.Videos/wellington.mp4")
		// Background
		numeracyMenu.setBackground(Color.WHITE);
		// Button functionality
		buttonHomeNumeracy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "baseMenu");
			}
		});		
		buttonExercisesNumeracy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0){
				cl.show(panelCont, "exerciseMenu");
			}
		});		
		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0){
				System.out.println("Display 'add' video.");
			}
		});	
		subtract.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0){
				System.out.println("Display 'subtract' video.");
			}
		});	
		multiply.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0){
				System.out.println("Display 'multiply' video.");
			}
		});	
		divide.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0){
				System.out.println("Display 'divide' video.");
			}
		});	
		equals.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0){
				System.out.println("Display 'equals' video.");
			}
		});	
	}
	
	//Makes the Exercises menu panel
	private void createExerciseMenu(){
		//Layout
		exerciseMenu.setLayout(null);
		//Title
		exerciseTitleIcon = new JLabel(new javax.swing.ImageIcon(getClass().getResource("/Assets/Title - Exercises.png")));
		exerciseMenu.add(exerciseTitleIcon);
		exerciseTitleIcon.setBounds(frame.getWidth()/2-290, frame.getHeight()/30, 580, 90);
		//Buttons
		exerciseMenu.add(buttonHomeExercises);
		buttonHomeExercises.setBounds(frame.getHeight()/30, frame.getHeight()/30, 69, 68);
		//Background
		exerciseMenu.setBackground(Color.WHITE);
		//Button functionality
		buttonHomeExercises.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0){
				cl.show(panelCont, "baseMenu");
			}
		});
		buttonHelpExercises.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0){
				if(!helpVisible){
					helpDialogue.setVisible(true);
					helpVisible = true;
				}
				else{
					helpDialogue.setVisible(false);
					helpVisible = false;
				}
			}
		});
	}

	// Makes the Search by Sign menu panel
	private void createSearchMenu() {
		// Layout
		searchMenu.setLayout(null);
		// Title
		searchTitleIcon = new JLabel(new javax.swing.ImageIcon(getClass()
				.getResource("/Assets/Title - Search by Sign.png")));
		searchMenu.add(searchTitleIcon);
		searchTitleIcon.setBounds(frame.getWidth() / 2 - 290,
				frame.getHeight() / 30, 580, 90);
		// Buttons
		searchMenu.add(buttonHomeSearch);
		buttonHomeSearch.setBounds(frame.getHeight() / 30,
				frame.getHeight() / 30, 69, 68);
		searchMenu.add(buttonHelpSearch);
		buttonHelpSearch.setBounds(frame.getWidth() - (frame.getWidth() / 30)
				- 84, frame.getHeight() / 30, 84, 68);
		// Help dialogue
		helpDialogue = new JLabel(new javax.swing.ImageIcon(getClass()
				.getResource("/Assets/SbS explanation.png")));
		searchMenu.add(helpDialogue);
		helpDialogue.setBounds(frame.getWidth() / 2 - 430,
				frame.getHeight() / 2 - 187, 860, 374);
		helpDialogue.setVisible(helpVisible);
		// Combobox
		searchMenu.add(refine);
		refine.setBounds(30, frame.getHeight() / 2 - 100, 200, 200);
		refineValue = refine.getSelectedIndex();
		// Console
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		leapConsole.setBorder(border);
		sp = new JScrollPane(leapConsole);
		sp.setBounds(frame.getWidth() / 4, frame.getHeight() / 4, 900, 400);
		searchMenu.add(sp);
		// Background
		searchMenu.setBackground(Color.WHITE);
		// Button functionality
		buttonHomeSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "baseMenu");
			}
		});
		buttonHelpSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (!helpVisible) {
					helpDialogue.setVisible(true);
					helpVisible = true;
				} else {
					helpDialogue.setVisible(false);
					helpVisible = false;
				}
			}
		});
		log("Search by sign initialisation complete");
		log("Welcome");
		log("");
		
	}
	
	public static void log(String message){
		leapConsole.append(message+"\n");
		JScrollBar vertical = sp.getVerticalScrollBar();
		vertical.setValue( vertical.getMaximum() );
	}
}
