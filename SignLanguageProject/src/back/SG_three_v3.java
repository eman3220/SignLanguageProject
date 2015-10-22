package back;

public class SG_three_v3 extends SignGesture {

	@Override
	public boolean matchesCondition(String[] handData) {
		if (handData[1].equals("00111")) {
			return true;
		}
		return false;
	}

}
