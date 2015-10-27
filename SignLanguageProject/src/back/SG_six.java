package back;

public class SG_six extends SignGesture{

	@Override
	public boolean matchesCondition(String[] handData) {
		if (handData[1].equals("10000")) {
			return true;
		}
		return false;
	}

}
