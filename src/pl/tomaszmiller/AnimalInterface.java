package pl.tomaszmiller;

import java.util.Date;

/**
 * Created by Peniakoff on 17.03.2017.
 */

public interface AnimalInterface {

	void setId(long id);
	void setType(String type);
	void setSex(char sex);
	void setBirthDate(String date);
	void setAddDate(Date date);
	void setBarnIndex(int barnIndex);

}
