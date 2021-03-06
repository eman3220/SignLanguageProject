package back;

import java.awt.Component;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;

public class Sign {
	private String id;
	private String name;
	private String position;
	private File[] assets;

	public Sign(String id, String name, String position, File[] assets) {
		super();
		this.id = id;
		this.name = name;
		this.position = position;
		this.assets = assets;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public File[] getAssets() {
		return assets;
	}
	public void setAssets(File[] assets) {
		this.assets = assets;
	}
	public Image getImage() {
		Image i = new ImageIcon(this.assets[0].getAbsolutePath()).getImage();
		return i;
	}


}
