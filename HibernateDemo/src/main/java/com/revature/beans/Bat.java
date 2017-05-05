package one.to.many;

import javax.persistence.*;

@Entity
@Table(name="BAT")
@AttributeOverrides({
	@AttributeOverride(name="id",column=@Column(name="BAT_ID")),
	@AttributeOverride(name="name",column=@Column(name="BAT_NAME")),
	@AttributeOverride(name="cave",column=@Column(name="BAT_CAVE"))
})
public class Bat extends Animal{
	
	public Bat(String name, int wingspan, Cave cave) {
		super();
		this.name=name;
		this.cave = cave;
		this.wingspan = wingspan;
	}

	public Bat() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Column(name="WING_SPAN")
	private int wingspan;

	public int getWingspan() {
		return wingspan;
	}

	public void setWingspan(int wingspan) {
		this.wingspan = wingspan;
	}
	

}
