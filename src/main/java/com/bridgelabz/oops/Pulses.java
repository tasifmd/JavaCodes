package com.bridgelabz.oops;

public class Pulses {
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
		return "Pulses [name=" + name + ", weight=" + weight + ", price=" + price + "]";
	}
}
