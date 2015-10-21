package back;

public class SG_five extends SignGesture{

	@Override
	public boolean matchesCondition(String[] handData) {
		if (handData[1].equals("11111")) {
			return true;
		}
		return false;
	}


}
