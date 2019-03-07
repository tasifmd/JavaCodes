package com.bridgelabz.oops;

public class Customer {
	private String name;
	private long mobileNumber;
	private String date;
	private int availableShares;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getAvailableShares() {
		return availableShares;
	}
	public void setAvailableShares(int availableShares) {
		this.availableShares = availableShares;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", mobileNumber=" + mobileNumber + ", date=" + date + ", availableShares="
				+ availableShares + "]";
	}
	
}
