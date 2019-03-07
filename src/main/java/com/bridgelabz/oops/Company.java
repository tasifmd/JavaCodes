package com.bridgelabz.oops;

public class Company {
	private String name;
	private int totalShares;
	private int stockPrice;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTotalShares() {
		return totalShares;
	}
	public void setTotalShares(int totalShares) {
		this.totalShares = totalShares;
	}
	public int getStockPrice() {
		return stockPrice;
	}
	public void setStockPrice(int stockPrice) {
		this.stockPrice = stockPrice;
	}
	@Override
	public String toString() {
		return "Company [name=" + name + ", totalShares=" + totalShares + ", stockPrice=" + stockPrice + "]";
	}
	
}
