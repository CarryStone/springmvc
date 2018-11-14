package model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Fruits {

	@Size(min=1,max=10,message="{fruits.name.size}")
	@NotNull(message="{fruits.name.notnull}")
	private String name;
	private double price;
	@NotNull(message="{fruits.producing_area.notnull}")
	private String producing_area;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getProducing_area() {
		return producing_area;
	}
	public void setProducing_area(String producing_area) {
		this.producing_area = producing_area;
	}
	
	
}
