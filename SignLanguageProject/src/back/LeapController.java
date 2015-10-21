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
					//System.out.println("Looking at index");
					if (distance < 70) {
						fingersSpaced.append("0");
					} else {
						fingersSpaced.append("1");
					}
				} else if (nextFinger.type().toString().equals("TYPE_MIDDLE")) {
					//System.out.println("Looking at middle");
					if (distance < 25) {
						fingersSpaced.append("0");
					} else {
						fingersSpaced.append("1");
					}
				} else if (nextFinger.type().toString().equals("TYPE_RING")) {
					//System.out.println("Looking at ring");
					if (distance < 25) {
						fingersSpaced.append("0");
					} else {
						fingersSpaced.append("1");
					}
				} else if (nextFinger.type().toString().equals("TYPE_PINKY")) {
					//System.out.println("Looking at pinky");
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

		handInfo[0] = sphere_diameter + "";
		handInfo[1] = fingersPresent.toString();
		handInfo[2] = fingersSpaced.toString();
		//System.out.println("Finger spacing: "+fingersSpaced.toString());
		// classification
		//System.out.println("Classifying");
		
		GUIv2.log(handInfo[1]+" ");
		GUIv2.log(handInfo[2]+" ");
		
		SG_C letterC = (SG_C) SignLanguageProject_Main.signGestures.get(5);
		GUIv2.log(letterC.matchesCondition(handInfo)+" ");
		
		SG_connectedHand connectedHand = (SG_connectedHand) SignLanguageProject_Main.signGestures
				.get(6);
		GUIv2.log(connectedHand.matchesCondition(handInfo)+" ");
		
		SG_connectedIndexMiddle connectedIndexMiddle = (SG_connectedIndexMiddle) SignLanguageProject_Main.signGestures
				.get(7);
		GUIv2.log(connectedIndexMiddle.matchesCondition(handInfo)+" ");
		
		SG_one one = (SG_one) SignLanguageProject_Main.signGestures.get(0);
		GUIv2.log(one.matchesCondition(handInfo) + " ");

		SG_two two = (SG_two) SignLanguageProject_Main.signGestures.get(1);
		GUIv2.log(two.matchesCondition(handInfo) + " ");

		SG_three three = (SG_three) SignLanguageProject_Main.signGestures
				.get(2);
		GUIv2.log(three.matchesCondition(handInfo) + " ");

		SG_four four = (SG_four) SignLanguageProject_Main.signGestures.get(3);
		GUIv2.log(four.matchesCondition(handInfo) + " ");

		SG_five five = (SG_five) SignLanguageProject_Main.signGestures.get(4);
		GUIv2.log(five.matchesCondition(handInfo)+" ");

		GUIv2.log("\n");
		
		//System.out.println("end");
	}

	private double getDistanceBetween(Vector currentVector, Vector nextVector) {
		float x = nextVector.getX() - currentVector.getX();
		float y = nextVector.getY() - currentVector.getY();
		float z = nextVector.getZ() - currentVector.getZ();

		return Math.sqrt(Math.pow((double) x, 2) + Math.pow((double) y, 2)
				+ Math.pow((double) z, 2));
	}
}
