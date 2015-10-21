package back;

public class SG_four extends SignGesture{

	@Override
	public boolean matchesCondition(String[] handData) {
		if (handData[1].equals("01111")) {
			return true;
		}
		return false;
	}


}
