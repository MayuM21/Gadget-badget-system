package com.java;

import java.sql.*;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class Payment {
	
	private int PID;
	private String CardName;
	private int CardNo;
	private int ZipCode;
	private int BID;
	private int CID;
	
	public int getPID() {
		return PID;
	}

	public void setPID(int pID) {
		PID = pID;
	}

	public String getCardName() {
		return CardName;
	}

	public void setCardName(String cardName) {
		CardName = cardName;
	}

	public int getCardNo() {
		return CardNo;
	}

	public void setCardNo(int cardNo) {
		CardNo = cardNo;
	}

	public int getZipCode() {
		return ZipCode;
	}

	public void setZipCode(int zipCode) {
		ZipCode = zipCode;
	}

	public int getBID() {
		return BID;
	}

	public void setBID(int bID) {
		BID = bID;
	}

	public int getCID() {
		return CID;
	}

	public void setCID(int cID) {
		CID = cID;
	}

	@Override
	public String toString() {
		
		return "Payment [pid=" +PID + " ,cardName=" + CardName + ", cardNo=" + CardNo + ", zipCode=" + ZipCode
				+ ", bid=" + BID +", cid=" + CID + "]";
	}	
	
	
	

}
