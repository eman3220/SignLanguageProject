package back;

import com.leapmotion.leap.Finger.Type;

import front.GUIv2;

public class SG_C extends SignGesture{

	@Override
	public boolean matchesCondition(String[] handData) {
		int sphere_diameter = Integer.parseInt(handData[0]);
		boolean thumb = Boolean.parseBoolean(handData[1].split("")[0]);
		boolean index = Boolean.parseBoolean(handData[1].split("")[1]);
		boolean middle = Boolean.parseBoolean(handData[1].split("")[2]);
		boolean ring = Boolean.parseBoolean(handData[1].split("")[3]);
		boolean pinky = Boolean.parseBoolean(handData[1].split("")[4]);

		if (sphere_diameter > 80 && sphere_diameter < 110
				&& thumb) {
			return true;
		}
		return false;
	}


}
