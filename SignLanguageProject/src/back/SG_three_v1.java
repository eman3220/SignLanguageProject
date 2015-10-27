package back;

public class SG_three_v1 extends SignGesture {

	@Override
	public boolean matchesCondition(String[] handData) {
		if (handData[1].equals("11100")){
			return true;
		}
		return false;
	}

}
