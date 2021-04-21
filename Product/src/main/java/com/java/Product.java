package com.java;

import java.sql.*;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class Product {
	
	private int PID;
	private String ProductName;
	private String RpaperType;
	private Double Price;
	
	
	public int getPID() {
		return PID;
	}

	public void setPID(int pID) {
		PID = pID;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public String RpaperType() {
		return RpaperType;
	}

	public void setRpaperType(String rpaperType) {
		RpaperType = rpaperType;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(Double price) {
		Price = price;
	}

	

	@Override
	public String toString() {
		
		return "Product [pid=" +PID + " ,productName=" + ProductName + ", rpaperType=" + RpaperType + ", price=" + Price
				+ "]";
	}	
	
	
	

}
