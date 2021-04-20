package com.java;

import java.sql.*;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class Funder {
	
	private int FID;
	private String FunderName;
	private String FunderMail;
	private int PhoneNo;
	private String Address;
	private double Amount;

	public int getFID() {
		return FID;
	}

	public void setFID(int fID) {
		FID = fID;
	}

	public String getFunderName() {
		return FunderName;
	}

	public void setFunderName(String funderName) {
		FunderName = funderName;
	}

	public String getFunderMail() {
		return FunderMail;
	}

	public void setFunderMail(String funderMail ) {
		FunderMail = funderMail;
	}

	public int getPhoneNo() {
		return PhoneNo;
	}

	public void setPhoneNo(int phoneNo) {
		PhoneNo = phoneNo;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public double getAmount() {
		return Amount;
	}

	public void setAmount(double amount) {
		Amount = amount;
	}

	@Override
	public String toString() {
		
		return "Funder [fid=" +FID + " ,funderName=" + FunderName + ", funderMail=" + FunderMail + ", phoneNo=" + PhoneNo
				+ ", address=" + Address +", amount=" + Amount + "]";
	}	
	
	
	

}
