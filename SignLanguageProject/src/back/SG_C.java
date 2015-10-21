package back;

import com.leapmotion.leap.Finger.Type;

import front.GUIv2;

public class SG_C extends SignGesture{

	@Override
	public boolean matchesCondition(String[] handData) {
		float sphere_diameter = Float.parseFloat(handData[0]);
		
		if (sphere_diameter > 80 && sphere_diameter < 110
				&& (handData[1].split("")[1].equals("1"))) {
			return true;
		}
		return false;
	}

}
