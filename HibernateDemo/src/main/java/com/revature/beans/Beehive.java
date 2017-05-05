package one.to.many;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="BEEHIVE")
public class Beehive implements Serializable {
	
	public Beehive() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Beehive(int weight) {
		super();
		this.weight = weight;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -5059958781406714282L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="hiveSeq")
	@SequenceGenerator(allocationSize=1,name="hiveSeq",sequenceName="HIVE_SEQ")
	@Column(name="BEEHIVE_ID")
	private int id;
	
	@Column(name="BEEHIVE_WEIGHT")
	private int weight;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Beehive [id=" + id + ", weight=" + weight + "]";
	}

}
