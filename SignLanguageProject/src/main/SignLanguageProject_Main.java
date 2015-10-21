package main;

import java.awt.EventQueue;
import java.util.ArrayList;

import back.LeapTest02;
import back.SG_C;
import back.SG_connectedHand;
import back.SG_connectedIndexMiddle;
import back.SG_five;
import back.SG_four;
import back.SG_one;
import back.SG_three;
import back.SG_two;
import back.SignGesture;
import front.GUIv2;

public class SignLanguageProject_Main {
	
	public static ArrayList<SignGesture> signGestures = new ArrayList<SignGesture>();

	public static void main(String[] args) {
		System.out.println("This is for Scotty's presentation");
		setupBack();
		setupFront();
		
	}

	private static void setupBack() {
		System.out.println("Setting up the back end...");
		
		// not doing much at the moment...
		setupSigns();
		
		System.out.println("Back end setup complete");
	}

	private static void setupSigns() {
		// create a signGesture
		// create signs related to signGesture
		
		// SG_one
		SG_one sg_one = new SG_one();
		sg_one.setName("one");
		
		// SG_two
		SG_two sg_two = new SG_two();
		sg_two.setName("two");
		
		// SG_three
		SG_three sg_three = new SG_three();
		sg_three.setName("three");
		
		// SG_four
		SG_four sg_four = new SG_four();
		sg_four.setName("four");
		
		// SG_five
		SG_five sg_five = new SG_five();
		sg_five.setName("five");
		
		// SG_C
		SG_C sg_c = new SG_C();
		sg_c.setName("Letter C");
		
		// SG_connectedHand
		SG_connectedHand sg_conHand = new SG_connectedHand();
		sg_conHand.setName("Connected Hand");
		
		// SG_connectedIndexMiddle
		SG_connectedIndexMiddle sg_conIndMid = new SG_connectedIndexMiddle();
		sg_conIndMid.setName("Connected Ind Mid");
		
		
		
		
		signGestures.add(sg_one);
		signGestures.add(sg_two);
		signGestures.add(sg_three);
		signGestures.add(sg_four);
		signGestures.add(sg_five);
		signGestures.add(sg_c);
		signGestures.add(sg_conHand);
		signGestures.add(sg_conIndMid);
	}

	private static void setupFront() {
		System.out.println("Setting up the front end...");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIv2 window = new GUIv2();
					window.frame.setVisible(true);
					System.out.println("Front end setup complete");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
