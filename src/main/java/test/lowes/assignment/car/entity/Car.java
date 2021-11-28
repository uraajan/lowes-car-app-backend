package test.lowes.assignment.car.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "car")
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false)
	private int id;

	@Column(nullable = false)
	private String name;

	private String tagLine;

	@Column(nullable = false)
	private String type;

	@Column(nullable = false)
	private long price;

	@ManyToOne
	private Company company;

	public Car() {
		super();
	}

	public Car(int id, String name, String tagLine, String type, long price, Company company) {
		super();
		this.id = id;
		this.name = name;
		this.tagLine = tagLine;
		this.type = type;
		this.price = price;
		this.company = company;
	}

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

	public String getTagLine() {
		return tagLine;
	}

	public void setTagLine(String tagLine) {
		this.tagLine = tagLine;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", name=" + name + ", tagLine=" + tagLine + ", type=" + type + ", price=" + price + ", company=" + company + "]";
	}

}
