package back;

public class SG_three_v2 extends SignGesture {

	@Override
	public boolean matchesCondition(String[] handData) {
		if (handData[1].equals("01110")) {
			return true;
		}
		return false;
	}

}
