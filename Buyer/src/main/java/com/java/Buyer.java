package com.java;

import java.sql.*;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class Buyer {
	
	private int BID;
	private String BuyerName;
	private String BuyerMail;
	private int BuyerNo;
	private String BuyerAddress;
	

	public int getBID() {
		return BID;
	}

	public void setBID(int bid) {
		BID = bid;
	}

	public String getBuyerName() {
		return BuyerName;
	}

	public void setBuyerName(String buyerName) {
		BuyerName = buyerName;
	}

	public String getBuyerMail() {
		return BuyerMail;
	}

	public void setBuyerMail(String buyerMail ) {
		BuyerMail = buyerMail;
	}

	public int getBuyerNo() {
		return BuyerNo;
	}

	public void setBuyerNo(int buyerNo) {
		BuyerNo = buyerNo;
	}

	public String getBuyerAddress() {
		return BuyerAddress;
	}

	public void setBuyerAddress(String buyeraddress) {
		BuyerAddress = buyeraddress;
	}

	

	@Override
	public String toString() {
		
		return "Buyer [bid=" +BID + " ,buyerName=" + BuyerName + ", buyerMail=" + BuyerMail + ", buyerNo=" + BuyerNo
				+ ", buyeraddress=" + BuyerAddress +"]";
	}	
	
	
	

}
