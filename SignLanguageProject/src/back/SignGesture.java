package back;

import java.util.ArrayList;

public abstract class SignGesture {
	private String name;
	private ArrayList<Sign> associatedSigns = new ArrayList<Sign>();

	/**
	 * Needs to have the following information.
	 * fingers presented
	 * thumb-index distal distance
	 * index-middle distal distance
	 * middle-ring distal distance
	 * ring-pinky distal distance
	 * @return
	 */
	public abstract boolean matchesCondition(String[] handData);

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Sign> getAssociatedSigns() {
		return associatedSigns;
	}

	public void setAssociatedSigns(ArrayList<Sign> associatedSigns) {
		this.associatedSigns = associatedSigns;
	}


}
