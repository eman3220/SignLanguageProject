package main;

import java.awt.EventQueue;
import java.util.ArrayList;

import back.SG_C;
import back.SG_connectedHand;
import back.SG_connectedIndexMiddle;
import back.SG_five;
import back.SG_four;
import back.SG_nine;
import back.SG_one;
import back.SG_seven;
import back.SG_six;
import back.SG_three_v1;
import back.SG_three_v2;
import back.SG_three_v3;
import back.SG_two;
import back.SG_zero_v1;
import back.SG_zero_v2;
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
		SG_three_v1 sg_three_v1 = new SG_three_v1();
		sg_three_v1.setName("three_v1");

		SG_three_v2 sg_three_v2 = new SG_three_v2();
		sg_three_v2.setName("three_v2");

		SG_three_v3 sg_three_v3 = new SG_three_v3();
		sg_three_v3.setName("three_v3");

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

		SG_six sg_six = new SG_six();
		sg_six.setName("six");

		SG_seven sg_seven = new SG_seven();
		sg_seven.setName("seven");

		SG_nine sg_nine = new SG_nine();
		sg_nine.setName("nine");

		SG_zero_v1 sg_zero_v1 = new SG_zero_v1();
		sg_zero_v1.setName("zero_v1");

		SG_zero_v2 sg_zero_v2 = new SG_zero_v2();
		sg_zero_v2.setName("zero_v2");


		signGestures.add(sg_zero_v1);
		signGestures.add(sg_zero_v2);
		signGestures.add(sg_one);
		signGestures.add(sg_two);
		signGestures.add(sg_three_v1);
		signGestures.add(sg_three_v2);
		signGestures.add(sg_three_v3);
		signGestures.add(sg_four);
		signGestures.add(sg_five);
		signGestures.add(sg_six);
		signGestures.add(sg_seven);
		signGestures.add(sg_nine);
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
