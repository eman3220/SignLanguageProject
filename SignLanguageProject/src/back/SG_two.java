package back;

public class SG_two extends SignGesture{

	@Override
	public boolean matchesCondition(String[] handData) {
		if (handData[1].equals("01100") && handData[2].split("")[2].equals("1")) {
			return true;
		}
		return false;
	}


}
