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
//		// System.out.println("Press Enter to quit...");
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

}

class LeapListener extends Listener {

	public void onConnect(Controller controller) {
		// System.out.println("Connected");
	}

	public void onFrame(Controller controller) {
		// System.out.println("Frame available");

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
		// System.out.println("This is the sphere center vector:" +
		// sphere_center);
		float sphere_diameter = 2 * hand.sphereRadius();
		// System.out.println("This is the sphere diameter value:"
		// + sphere_diameter);
		handInfo[0] = sphere_diameter + "";

		// get list of fingers
		FingerList fingers = hand.fingers();

		// initialize stringbuilders
		StringBuilder fingersPresent = new StringBuilder();
		StringBuilder fingersSpaced = new StringBuilder();

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
				// System.out.println("Distance between: "+distance);

				// establish threshold
				//System.out.println("Establish threshold");
				if (nextFinger.type().toString().equals("TYPE_INDEX")) {
					// System.out.println("Looking at index");
					if (distance < 70) {
						fingersSpaced.append("0");
					} else {
						fingersSpaced.append("1");
					}
				} else if (nextFinger.type().toString().equals("TYPE_MIDDLE")) {
					// System.out.println("Looking at middle");
					if (distance < 25) {
						fingersSpaced.append("0");
					} else {
						fingersSpaced.append("1");
					}
				} else if (nextFinger.type().toString().equals("TYPE_RING")) {
					// System.out.println("Looking at ring");
					if (distance < 25) {
						fingersSpaced.append("0");
					} else {
						fingersSpaced.append("1");
					}
				} else if (nextFinger.type().toString().equals("TYPE_PINKY")) {
					// System.out.println("Looking at pinky");
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

		// set GUI indicator thing
		// extension

//		char t = fingersPresent.charAt(0);
//		if (t == '1') {
//			GUIv2.THUMB.setForeground(Color.RED);
//		} else {
//			GUIv2.THUMB.setForeground(Color.BLACK);
//		}
//
//		char i = fingersPresent.charAt(1);
//		if (i == '1') {
//			GUIv2.INDEX.setForeground(Color.RED);
//		} else {
//			GUIv2.INDEX.setForeground(Color.BLACK);
//		}
//
//		char m = fingersPresent.charAt(2);
//		if (m == '1') {
//			GUIv2.MIDDLE.setForeground(Color.RED);
//		} else {
//			GUIv2.MIDDLE.setForeground(Color.BLACK);
//		}
//		char r = fingersPresent.charAt(3);
//		if (r == '1') {
//			GUIv2.RING.setForeground(Color.RED);
//		} else {
//			GUIv2.RING.setForeground(Color.BLACK);
//		}
//		char p = fingersPresent.charAt(4);
//		if (p == '1') {
//			GUIv2.PINKY.setForeground(Color.RED);
//		} else {
//			GUIv2.PINKY.setForeground(Color.BLACK);
//		}
//
//		// spacing
//		char t_i = fingersSpaced.charAt(0);
//		if (t_i == '1') {
//			GUIv2.T_I.setForeground(Color.RED);
//		} else {
//			GUIv2.T_I.setForeground(Color.BLACK);
//		}
//
//		char i_m = fingersSpaced.charAt(1);
//		if (i_m == '1') {
//			GUIv2.I_M.setForeground(Color.RED);
//		} else {
//			GUIv2.I_M.setForeground(Color.BLACK);
//		}
//
//		char m_r = fingersSpaced.charAt(2);
//		if (m_r == '1') {
//			GUIv2.M_R.setForeground(Color.RED);
//		} else {
//			GUIv2.M_R.setForeground(Color.BLACK);
//		}
//		char r_p = fingersSpaced.charAt(3);
//		if (r_p == '1') {
//			GUIv2.R_P.setForeground(Color.RED);
//		} else {
//			GUIv2.R_P.setForeground(Color.BLACK);
//		}

		// set data
		handInfo[0] = sphere_diameter + "";
		handInfo[1] = fingersPresent.toString();
		handInfo[2] = fingersSpaced.toString();
		// System.out.println("Finger spacing: "+fingersSpaced.toString());
		// classification
		// System.out.println("Classifying");

		GUIv2.log(handInfo[1] + " ");
		GUIv2.log(handInfo[2] + " ");

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

		if (letterC.matchesCondition(handInfo)) {
			GUIv2.log("This is the C gesture");
		} else if (connectedHand.matchesCondition(handInfo)) {
			GUIv2.log("This is the birthday gesture");
		} else if (connectedIndexMiddle.matchesCondition(handInfo)) {
			GUIv2.log("This is the father gesture");
		} else if (one.matchesCondition(handInfo)) {
			GUIv2.log("This is the 1 gesture");
		} else if (two.matchesCondition(handInfo)) {
			GUIv2.log("This is the 2 gesture");
		} else if (three_v1.matchesCondition(handInfo)) {
			GUIv2.log("This is the 3v1 gesture");
		} else if (three_v2.matchesCondition(handInfo)) {
			GUIv2.log("This is the 3v2 gesture");
		} else if (three_v3.matchesCondition(handInfo)) {
			GUIv2.log("This is the 3v3 gesture");
		} else if (four.matchesCondition(handInfo)) {
			GUIv2.log("This is the 4 gesture");
		} else if (five.matchesCondition(handInfo)) {
			GUIv2.log("This is the 5 gesture");
		} else if (six.matchesCondition(handInfo)) {
			GUIv2.log("This is the 6 gesture");
		} else if (seven.matchesCondition(handInfo)) {
			GUIv2.log("This is the 7 gesture");
		} else if (nine.matchesCondition(handInfo)) {
			GUIv2.log("This is the 9 gesture");
		} else if (zero_v1.matchesCondition(handInfo)) {
			GUIv2.log("This is the 0v1 gesture");
		} else if (zero_v2.matchesCondition(handInfo)) {
			GUIv2.log("This is the 0v2 gesture");
		} else {
			// unused
		}

		GUIv2.log("\n");

		// System.out.println("end");
	}

	private double getDistanceBetween(Vector currentVector, Vector nextVector) {
		float x = nextVector.getX() - currentVector.getX();
		float y = nextVector.getY() - currentVector.getY();
		float z = nextVector.getZ() - currentVector.getZ();

		return Math.sqrt(Math.pow((double) x, 2) + Math.pow((double) y, 2)
				+ Math.pow((double) z, 2));
	}
}
