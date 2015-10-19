package back;

import java.io.IOException;
import java.util.ArrayList;

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

public class LeapTest02 {

	public static void main(String[] args) {
		// Create a sample listener and controller
		listener = new SampleListener();
		controller = new Controller();

		// Have the sample listener receive events from the controller
		controller.addListener(listener);

		// Keep this process running until Enter is pressed
		// System.out.println("Press Enter to quit...");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Remove the sample listener when done
		controller.removeListener(listener);
	}

	static SampleListener listener;
	static Controller controller;

	public LeapTest02() {
		// Create a sample listener and controller
		listener = new SampleListener();
		controller = new Controller();

		// Have the sample listener receive events from the controller
		controller.addListener(listener);

		// Keep this process running until Enter is pressed
		// System.out.println("Press Enter to quit...");
		// try {
		// System.in.read();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		//
		// // Remove the sample listener when done
		// controller.removeListener(listener);
	}

	public static void initialise() {
		// Create a sample listener and controller
		listener = new SampleListener();
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

class SampleListener extends Listener {

	public void onConnect(Controller controller) {
		// System.out.println("Connected");
	}

	public void onFrame(Controller controller) {
		// System.out.println("Frame available");
		// System.out.println("onFrame");
		Frame frame = controller.frame();

		// System.out.println("Frame id: " + frame.id() + ", timestamp: "
		// + frame.timestamp() + ", hands: " + frame.hands().count()
		// + ", fingers: " + frame.fingers().count() + ", tools: "
		// + frame.tools().count() + ", gestures "
		// + frame.gestures().count());

		// System.out.println();
		// System.out.println("--- Bone info ---");

		HandList hands = frame.hands();
		// System.out.println("Hands: "+hands.count());

		ArrayList<Float> handData = new ArrayList<Float>();

		for (Hand hand : hands) {
			// System.out.println();
			// System.out.println("Hand: "+hand);
			Vector sphere_center = hand.sphereCenter();
			System.out.println("This is the sphere center vector:"
					+ sphere_center);
			float sphere_diameter = 2 * hand.sphereRadius();
			System.out.println("This is the sphere diameter value:"
					+ sphere_diameter);
			// FingerList finger_list = null;
			for (Finger finger : hand.fingers()) {

				// System.out.println("Finger: "+finger);
				// To do: The tumb is being detected and the C gesture is
				// detected, now we just need an if statement that combines both
				// of these.
				for (Bone.Type boneType : Bone.Type.values()) {
					// System.out.println("Bone");

					/*
					 * for (Finger.Type fingerType : Finger.Type.values()) {
					 * System.out.println("Finger Type"+fingerType);
					 */
					Bone bone = finger.bone(boneType);
					// ... Use the bone
					// System.out.println("The bone type is here: "+boneType);
					// System.out.println("The vector we need is here: "+bone.center().toString());

					FingerList extendedFingers = frame.fingers().extended();
					int fingerCount = extendedFingers.count();
					// System.out.println(fingerCount);
					Finger.Type finger_type = finger.type();

					// boolean hasThumb = false;
					ArrayList<Finger.Type> fingers = new ArrayList<Finger.Type>();
					// finger_list.append(frame.fingers().extended());
					for (Finger f : extendedFingers) {
						// System.out.println(">>>>>>>>>>>>>>>>>>>>>>"+f.type());
						fingers.add(f.type());
						// System.out.println("this is the bone: "+bone);

					}

					// if(fingers.contains(Type.TYPE_THUMB)){
					// System.out.println("WE HAVE A THUMB");
					// }
					// System.out.println("FingerList?????"+extendedFingers);
					// Object index_finger = index_finger_list[0];
					// System.out.println("finger list>>>>: "+hand.fingers().get(2).type());
					// System.out.println("Finger Type:"+finger_type);

					System.out.println();
					// C gesture
					if (sphere_diameter > 80 && sphere_diameter < 110
							&& fingers.contains(Type.TYPE_THUMB)) {
						// if(finger_type==Type.TYPE_THUMB){
						System.out.println("this is the C gesture");
						// else{System.out.println("Not recognising the thumb");}
						GUIv2.log("this is the C gesture");
					} else if (fingers.contains(Type.TYPE_INDEX)
							&& fingerCount == 1) {
						System.out.println("this is a 1 gesture");
						GUIv2.log("this is a 1 gesture");
					} else if (fingers.contains(Type.TYPE_INDEX)
							&& fingers.contains(Type.TYPE_MIDDLE)
							&& fingerCount == 2) {
						System.out.println("this is a 2 gesture");
						GUIv2.log("this is a 2 gesture");
					} else if (fingers.contains(Type.TYPE_INDEX)
							&& fingers.contains(Type.TYPE_MIDDLE)
							&& fingers.contains(Type.TYPE_RING)
							&& fingerCount == 3) {
						System.out.println("this is a 3 gesture");
						GUIv2.log("this is a 3 gesture");
					} else if (fingers.contains(Type.TYPE_INDEX)
							&& fingers.contains(Type.TYPE_MIDDLE)
							&& fingers.contains(Type.TYPE_RING)
							&& fingers.contains(Type.TYPE_PINKY)
							&& fingerCount == 4) {
						System.out.println("this is a 4 gesture");
						GUIv2.log("this is a 4 gesture");
					} else if (fingers.contains(Type.TYPE_INDEX)
							&& fingers.contains(Type.TYPE_MIDDLE)
							&& fingers.contains(Type.TYPE_RING)
							&& fingers.contains(Type.TYPE_PINKY)
							&& fingers.contains(Type.TYPE_THUMB)
							&& fingerCount == 5) {
						System.out.println("this is a 5 gesture");
						GUIv2.log("this is a 5 gesture");
					}

					handData.add(bone.center().getX());
					handData.add(bone.center().getY());
					handData.add(bone.center().getZ());
				}
			}
		}

		// System.out.println("Hand Data size: "+handData.size());
	}
}
