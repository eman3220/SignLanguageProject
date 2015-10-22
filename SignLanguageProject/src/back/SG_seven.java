package back;

public class SG_seven extends SignGesture {

	@Override
	public boolean matchesCondition(String[] handData) {
		if (handData[1].equals("11000")) {
			return true;
		}
		return false;
	}

}
