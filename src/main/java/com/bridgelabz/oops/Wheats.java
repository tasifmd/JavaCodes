package com.bridgelabz.oops;

/**
 * Class that contains data members and required getters and setters 
 * @author :Tasif Mohammed
 * @version :1.0
 */
public class Wheats {
	private String name;
	private double weight;
	private double price;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Wheats [name=" + name + ", weight=" + weight + ", price=" + price + "]";
	}
}
