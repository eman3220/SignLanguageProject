package back;

public class SG_one extends SignGesture{

	@Override
	public boolean matchesCondition(String[] handData) {
		if (handData[1].equals("01000")) {
			return true;
		}
		return false;
	}

}
