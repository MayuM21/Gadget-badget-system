package com.java;

public class Card {
	private int CID;
	private double Price;
	private int PRID;
	private int BID;
	
	public int getCID() {
		return CID;
	}
	public void setCID(int cID) {
		CID = cID;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	public int getPRID() {
		return PRID;
	}
	public void setPRID(int pRID) {
		PRID = pRID;
	}
	public int getBID() {
		return BID;
	}
	public void setBID(int bID) {
		BID = bID;
	}
	
	@Override
	public String toString() {
		
		return "Card [cid=" +CID + " ,price=" + Price + ", prid=" + PRID +", bid=" + BID + "]";
	}
	

}

