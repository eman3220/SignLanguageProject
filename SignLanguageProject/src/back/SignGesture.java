package back;

import java.util.ArrayList;

public abstract class SignGesture {
	private ArrayList<Sign> associatedSigns;
	
	/**
	 * Needs to have the following information.
	 * Finger count
	 * thumb presented
	 * index presented
	 * middle presented
	 * ring presented
	 * pinky presented
	 * thumb-index distal distance
	 * index-middle distal distance
	 * middle-ring distal distance
	 * ring-pinky distal distance
	 * @return
	 */
	public abstract boolean matchesCondition(String[] handData);
}
