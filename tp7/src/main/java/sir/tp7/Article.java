package sir.tp7;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

@Entity
public class Article {

	@Id
	private ObjectId id;
	private String name;
	private int starts;
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStarts() {
		return starts;
	}
	public void setStarts(int starts) {
		this.starts = starts;
	}

}
