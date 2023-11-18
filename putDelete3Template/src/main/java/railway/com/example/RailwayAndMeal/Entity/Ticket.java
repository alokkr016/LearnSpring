package railway.com.example.RailwayAndMeal.Entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public class Ticket {

	@Min(1) // Annotation for restricting the pnr to have a minimum value of 1
	public long pnr;

	@Size(min = 3, max = 20) // Annotation for name to have a minimum of 3 and maximum of 20 length of
								// characters.
	public String name;

	public long age;
	public String birth;
	
	public Ticket(String name, long age, long pnr, String birth) {
		super();
		this.pnr = pnr;
		this.name = name;
		this.age = age;
		this.birth = birth;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getAge() {
		return age;
	}
	public void setAge(long age) {
		this.age = age;
	}
	public long getPnr() {
		return pnr;
	}
	public void setPnr(long pnr) {
		this.pnr = pnr;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}

	public Ticket() {
	}
}
