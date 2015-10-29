package back;

import java.io.IOException;
import java.util.ArrayList;

import main.SignLanguageProject_Main;

import com.leapmotion.leap.Bone;
import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Finger;
import com.leapmotion.leap.Finger.Type;
import com.leapmotion.leap.FingerList;
import com.leapmotion.leap.Frame;
import com.leapmotion.leap.Hand;
import com.leapmotion.leap.HandList;
import com.leapmotion.leap.Listener;
import com.leapmotion.leap.Vector;

import front.GUIv2;
import front.drawExercises;
import front.drawSearch;

public class LeapController {

	static LeapListener listener;
	static Controller controller;

//	public static void main(String[] args) {
//		// Create a sample listener and controller
//		listener = new LeapListener();
//		controller = new Controller();
//
//		// Have the sample listener receive events from the controller
//		controller.addListener(listener);
//
//		// Keep this process running until Enter is pressed
//		// //System.out.println("Press Enter to quit...");
//		try {
//			System.in.read();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		// Remove the sample listener when done
//		controller.removeListener(listener);
//	}

	public LeapController() {
		// Create a sample listener and controller
		listener = new LeapListener();
		controller = new Controller();

		// Have the sample listener receive events from the controller
		controller.addListener(listener);
	}

	public static void initialise() {
		// Create a sample listener and controller
		listener = new LeapListener();
		controller = new Controller();

		// Have the sample listener receive events from the controller
		controller.addListener(listener);
	}

	public static void classify() {
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Remove the sample listener when done
		controller.removeListener(listener);
	}

	public static void stopLeap() {
		// Have the sample listener receive events from the controller
				controller.addListener(listener);
	}

}

class LeapListener extends Listener {

	public void onConnect(Controller controller) {
		// //System.out.println("Connected");
	}

	public void onFrame(Controller controller) {
		//System.out.println("Frame available");

		System.out.print("");

		Frame frame = controller.frame();

		// get all hands
		HandList hands = frame.hands();

		// only look at the first hand
		Hand hand = hands.get(0);

		// initialise handData array
		// 0 - sphere diameter
		// 1 - extended fingers
		// 2 - finger spacing
		String[] handInfo = new String[3];

		// get the sphere diameter of the hand
		Vector sphere_center = hand.sphereCenter();
		// //System.out.println("This is the sphere center vector:" +
		// sphere_center);
		float sphere_diameter = 2 * hand.sphereRadius();
		// //System.out.println("This is the sphere diameter value:"
		// + sphere_diameter);
		handInfo[0] = sphere_diameter + "";

		// get list of fingers
		FingerList fingers = hand.fingers();

		// initialize stringbuilders
		StringBuilder fingersPresent = new StringBuilder();
		StringBuilder fingersSpaced = new StringBuilder();

		////System.out.println("HELLO?");

		for (int i = 0; i < fingers.count(); i++) {
			Finger finger = fingers.get(i);

			// finger extension
			if (finger.isExtended()) {
				fingersPresent.append("1");
			} else {
				fingersPresent.append("0");
			}

			// finger spaced
			if ((i + 1) < fingers.count()) {
				Finger nextFinger = fingers.get(i + 1);
				Bone currentDistal = finger.bone(Bone.Type.TYPE_DISTAL);
				Bone nextDistal = nextFinger.bone(Bone.Type.TYPE_DISTAL);

				Vector currentVector = currentDistal.center();
				Vector nextVector = nextDistal.center();

				// get distance
				double distance = getDistanceBetween(currentVector, nextVector);
				// //System.out.println("Distance between: "+distance);

				// establish threshold
				////System.out.println("Establish threshold");
				if (nextFinger.type().toString().equals("TYPE_INDEX")) {
					// //System.out.println("Looking at index");
					if (distance < 70) {
						fingersSpaced.append("0");
					} else {
						fingersSpaced.append("1");
					}
				} else if (nextFinger.type().toString().equals("TYPE_MIDDLE")) {
					// //System.out.println("Looking at middle");
					if (distance < 25) {
						fingersSpaced.append("0");
					} else {
						fingersSpaced.append("1");
					}
				} else if (nextFinger.type().toString().equals("TYPE_RING")) {
					// //System.out.println("Looking at ring");
					if (distance < 25) {
						fingersSpaced.append("0");
					} else {
						fingersSpaced.append("1");
					}
				} else if (nextFinger.type().toString().equals("TYPE_PINKY")) {
					// //System.out.println("Looking at pinky");
					if (distance < 35) {
						fingersSpaced.append("0");
					} else {
						fingersSpaced.append("1");
					}
				}
			} else {
				continue;
			}
		}

		////System.out.println("Loop end");

		// set data
		handInfo[0] = sphere_diameter + "";
		handInfo[1] = fingersPresent.toString();
		handInfo[2] = fingersSpaced.toString();
		// //System.out.println("Finger spacing: "+fingersSpaced.toString());
		// classification
		// //System.out.println("Classifying");

		////System.out.println(handInfo[1] + " ");
		////System.out.println(handInfo[2] + " ");



		SG_zero_v1 zero_v1 = (SG_zero_v1) SignLanguageProject_Main.signGestures
				.get(0);

		SG_zero_v2 zero_v2 = (SG_zero_v2) SignLanguageProject_Main.signGestures
				.get(1);

		SG_one one = (SG_one) SignLanguageProject_Main.signGestures.get(2);
		// GUIv2.log(one.matchesCondition(handInfo) + " ");

		SG_two two = (SG_two) SignLanguageProject_Main.signGestures.get(3);
		// GUIv2.log(two.matchesCondition(handInfo) + " ");

		SG_three_v1 three_v1 = (SG_three_v1) SignLanguageProject_Main.signGestures
				.get(4);
		// GUIv2.log(three_v1.matchesCondition(handInfo) + " ");

		SG_three_v2 three_v2 = (SG_three_v2) SignLanguageProject_Main.signGestures
				.get(5);
		// GUIv2.log(three_v2.matchesCondition(handInfo) + " ");

		SG_three_v3 three_v3 = (SG_three_v3) SignLanguageProject_Main.signGestures
				.get(6);
		// GUIv2.log(three_v3.matchesCondition(handInfo) + " ");

		SG_four four = (SG_four) SignLanguageProject_Main.signGestures.get(7);
		// GUIv2.log(four.matchesCondition(handInfo) + " ");

		SG_five five = (SG_five) SignLanguageProject_Main.signGestures.get(8);
		// GUIv2.log(five.matchesCondition(handInfo)+" ");

		SG_six six = (SG_six) SignLanguageProject_Main.signGestures.get(9);

		SG_seven seven = (SG_seven) SignLanguageProject_Main.signGestures
				.get(10);

		SG_nine nine = (SG_nine) SignLanguageProject_Main.signGestures.get(11);

		SG_C letterC = (SG_C) SignLanguageProject_Main.signGestures.get(12);

		SG_connectedHand connectedHand = (SG_connectedHand) SignLanguageProject_Main.signGestures
				.get(13);

		SG_connectedIndexMiddle connectedIndexMiddle = (SG_connectedIndexMiddle) SignLanguageProject_Main.signGestures
				.get(14);

		////System.out.println("Got here");

		if (letterC.matchesCondition(handInfo)) {
			//GUIv2.log("This is the C gesture");


			SignLanguageProject_Main.selected = (SignGesture)letterC;


			drawSearch.hand = 4;
			drawExercises.hand = 4;

		} else if (connectedHand.matchesCondition(handInfo)) {
			//System.out.println("This is the birthday gesture");
			SignLanguageProject_Main.selected = (SignGesture) connectedHand;
			drawSearch.hand = 11;
			drawExercises.hand = 11;
		} else if (connectedIndexMiddle.matchesCondition(handInfo)) {
			//System.out.println("This is the father gesture");
			SignLanguageProject_Main.selected = (SignGesture) connectedIndexMiddle;

			drawSearch.hand = 6;
			drawExercises.hand = 6;

		} else if (one.matchesCondition(handInfo)) {
			//System.out.println("This is the 1 gesture");
			SignLanguageProject_Main.selected = (SignGesture)one;
			drawSearch.hand = 1;
			drawExercises.hand = 1;

		} else if (two.matchesCondition(handInfo)) {
			//System.out.println("This is the 2 gesture");
			SignLanguageProject_Main.selected = (SignGesture)two;

			drawSearch.hand = 7;
			drawExercises.hand = 7;

		} else if (three_v1.matchesCondition(handInfo)) {
			//System.out.println("This is the 3v1 gesture");
			SignLanguageProject_Main.selected = (SignGesture)three_v1;

			drawSearch.hand = 9;
			drawExercises.hand = 9;
		} else if (three_v2.matchesCondition(handInfo)) {
			//System.out.println("This is the 3v2 gesture");
			SignLanguageProject_Main.selected = (SignGesture)three_v2;


			drawSearch.hand = 3;
			drawSearch.hand = 5;
			drawExercises.hand = 5;

		} else if (three_v3.matchesCondition(handInfo)) {
			//System.out.println("This is the 3v3 gesture");
			SignLanguageProject_Main.selected = (SignGesture)three_v3;



		} else if (four.matchesCondition(handInfo)) {
			//System.out.println("This is the 4 gesture");
			SignLanguageProject_Main.selected = (SignGesture)four;


			drawSearch.hand = 14;
			drawExercises.hand = 14;

		} else if (five.matchesCondition(handInfo)) {
			//System.out.println("This is the 5 gesture");
			SignLanguageProject_Main.selected = (SignGesture)five;

			// correct
			drawSearch.hand = 2;
			drawExercises.hand = 2;

		} else if (six.matchesCondition(handInfo)) {
			//System.out.println("This is the 6 gesture");
			SignLanguageProject_Main.selected = (SignGesture)six;



			drawSearch.hand = 8;
			drawExercises.hand = 8;
		} else if (seven.matchesCondition(handInfo)) {
			//System.out.println("This is the 7 gesture");
			SignLanguageProject_Main.selected = (SignGesture)seven;

			drawSearch.hand = 12;
			drawExercises.hand = 12;


		} else if (nine.matchesCondition(handInfo)) {
			//System.out.println("This is the 9 gesture");
			SignLanguageProject_Main.selected = (SignGesture)nine;



		} else if (zero_v1.matchesCondition(handInfo)) {
			//System.out.println("This is the 0v1 gesture");
			//SignLanguageProject_Main.selected = (SignGesture)

			drawSearch.hand = 10;

			drawSearch.hand = 13;
			drawSearch.hand = 0;
			drawExercises.hand = 0;
		} else if (zero_v2.matchesCondition(handInfo)) {
			//System.out.println("This is the 0v2 gesture");
			//SignLanguageProject_Main.selected = (SignGesture)


			drawSearch.hand = 0;
			drawExercises.hand = 0;
		} else {
			// unused
		}

		// //System.out.println("end");
	}

	private double getDistanceBetween(Vector currentVector, Vector nextVector) {
		float x = nextVector.getX() - currentVector.getX();
		float y = nextVector.getY() - currentVector.getY();
		float z = nextVector.getZ() - currentVector.getZ();

		return Math.sqrt(Math.pow((double) x, 2) + Math.pow((double) y, 2)
				+ Math.pow((double) z, 2));
	}
}
