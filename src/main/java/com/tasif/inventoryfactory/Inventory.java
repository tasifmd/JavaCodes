package com.tasif.inventoryfactory;

/**
 * Inventory class that contains private members and required getters and setters 
 * @author : Tasif Mohammed
 * @version : 1.0
 */
public class Inventory {
	private String product;
    private double inventoryPrice;
    private int numberofinventory;
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public double getInventoryPrice() {
		return inventoryPrice;
	}
	public void setInventoryPrice(double inventoryPrice) {
		this.inventoryPrice = inventoryPrice;
	}
	public int getNumberofinventory() {
		return numberofinventory;
	}
	public void setNumberofinventory(int numberofinventory) {
		this.numberofinventory = numberofinventory;
	}
	@Override
	public String toString() {
		return "Inventory [product=" + product + ", inventoryPrice=" + inventoryPrice + ", numberofinventory="
				+ numberofinventory + "]";
	}
}
