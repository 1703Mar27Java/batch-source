package one.to.many;

import java.io.Serializable;

import javax.persistence.*;



@Entity
@Table(name="BEAR")
public class Bear implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1671056424943086535L;

	public Bear(String name, Cave cave) {
		super();
	
		this.name = name;
		this.cave = cave;
	}

	public Bear() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="bearSeq")
	@SequenceGenerator(allocationSize=1,name="bearSeq",sequenceName="BEAR_SEQ")
	@Column(name="BEAR_ID")
	private int id;
	
	@Column(name="BEAR_NAME")
	private String name;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="BEAR_CAVE")
	Cave cave;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Cave getCave() {
		return cave;
	}

	public void setCave(Cave cave) {
		this.cave = cave;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cave == null) ? 0 : cave.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bear other = (Bear) obj;
		if (cave == null) {
			if (other.cave != null)
				return false;
		} else if (!cave.equals(other.cave))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bear [id=" + id + ", name=" + name + ", cave=" + cave + "]";
	}
	
	

}
