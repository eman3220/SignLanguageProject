package back;

public class SG_connectedIndexMiddle extends SignGesture{

	@Override
	public boolean matchesCondition(String[] handData) {
		if (handData[1].equals("01100") && handData[2].split("")[2].equals("0")) {
			return true;
		}
		return false;
	}


}
