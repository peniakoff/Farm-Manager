package pl.tomaszmiller;

import java.util.Date;

/**
 * Created by Peniakoff on 17.03.2017.
 */

public class Animal implements AnimalInterface {

	private long id; // official ID number of the animal
	private String type;
	private char sex; // f - a female; m - the male
	private String birthDate;
	private Date addDate; // date added the animal to the barn
	private int barnIndex;

	public Animal(long id, String type, char sex, String birthDate, int barnIndex) {
		this.id = id;
		this.type = type;
		this.sex = sex;
		this.birthDate = birthDate;
		this.addDate = new Date();
		this.barnIndex = barnIndex;
	}

	@Override
	public void setId(long id) {
		this.id = id;
	}

	@Override
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public void setSex(char sex) {
		this.sex = sex;
	}

	@Override
	public void setBirthDate(String date) {

	}

	@Override
	public void setAddDate(Date date) {
		this.addDate = new Date();
	}

	@Override
	public void setBarnIndex(int barnIndex) {
		this.barnIndex = barnIndex;
	}

	public long getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public char getSex() {
		return sex;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public Date getAddDate() {
		return addDate;
	}

	public int getBarnIndex() {
		return barnIndex;
	}

	@Override
	public String toString() {
		return "Animal{" +
				"id=" + id +
				", type='" + type + '\'' +
				", sex=" + sex +
				", birthDate='" + birthDate + '\'' +
				", addDate=" + addDate +
				", barnIndex=" + barnIndex +
				'}';
	}
}
