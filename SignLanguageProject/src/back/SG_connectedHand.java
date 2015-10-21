package back;

public class SG_connectedHand extends SignGesture{

	@Override
	public boolean matchesCondition(String[] handData) {
		if(handData[1].equals("11111") && handData[2].equals("1000")){
			return true;
		}
		return false;
	}

}
