package pl.tomaszmiller;

/**
 * Created by Peniakoff on 17.03.2017.
 */

public class Barn {

	private int barnId;
	private String barnName;
	private int capacity;

	public Barn(int barnId, String barnName, int capacity) {
		this.barnId = barnId;
		this.barnName = barnName;
		this.capacity = capacity;
	}

	public int getBarnId() {
		return barnId;
	}

	public void setBarnId(int barnId) {
		this.barnId = barnId;
	}

	public String getBarnName() {
		return barnName;
	}

	public void setBarnName(String barnName) {
		this.barnName = barnName;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

}
