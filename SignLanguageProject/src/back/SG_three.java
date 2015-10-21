package back;

public class SG_three extends SignGesture {

	@Override
	public boolean matchesCondition(String[] handData) {
		if ((handData[1].equals("11100"))
				|| (handData[1].equals("01110"))
				|| (handData[1].equals("00111"))) {
			return true;
		}
		return false;
	}

}
