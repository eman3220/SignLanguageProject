package back;

public class SG_nine extends SignGesture {

	@Override
	public boolean matchesCondition(String[] handData) {
		if (handData[1].equals("11110")) {
			return true;
		}
		return false;
	}

}
