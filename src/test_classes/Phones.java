package test_classes;

import java.util.ArrayList;
import java.util.List;

public class Phones {
	public static void main (String [] args) {
		List<UserCharges> list = new ArrayList<>();
		list.add(new UserCharges(1,"0851234560",25,5,110,250));
		
		
		for (UserCharges u: list) {
			System.out.println("Call Cost: €"+u.DataCost());
		}
	}
}

class PhoneUser {
	//variables
	private Integer unique_id = 0;
	private String phone_number = "";
	
	// constructor
	PhoneUser () {}
	PhoneUser (Integer unique_id, String phone_number){
		this.unique_id = unique_id; 
		this.phone_number = phone_number;
	}
	
	// getters and setters
	// unique id
	public Integer getUniqueID() {
		return unique_id;
	}
	public void setUniqueID (Integer unique_id) {
		this.unique_id = unique_id;
	}
	// phone number
	public String getPhoneNumber () {
		return phone_number;
	}
	public void setPhoneNumber (String phone_number) {
		this.phone_number = phone_number;
	}
	
}

class UserCharges extends PhoneUser {
	// charges
	// tax
	private final Double callTax = 0.07;
	private final Double textTax = 0.05;
	private final Double dataTax = 0.08;
	
	// costs
	private final Double mobile_callCost = 0.25;
	private final Double landline_callCost = 0.55;
	private final Double textCost = 0.15;
	private final Double dataCost = 0.99;
	
	// object variables
	private Integer minutesToMobile = 0;
	private Integer minutesToLandline = 0;
	private Integer textTotal = 0;
	private Integer dataUsage = 0;
	
	// constructor
	UserCharges (Integer unique_id,String phone_number,int minutesToMobile,int minutesToLandline,int textTotal,int dataUsage) {
		super (unique_id,phone_number);
		this.minutesToMobile = minutesToMobile;
		this.minutesToLandline = minutesToLandline;
		this.textTotal = textTotal;
		this.dataUsage = dataUsage;
	}
	
	// getters and setters
	// mobile
	public Integer getMobile () {
		return this.minutesToMobile;
	}
	public void setMobile (Integer minutes) {
		this.minutesToMobile = minutes;
	}
	//land line
	public Integer getLandline () {
		return this.minutesToLandline;
	}
	public void setLandline (Integer minutes) {
		this.minutesToLandline = minutes;
	}
	//text
	public Integer getTexts () {
		return this.textTotal;
	}
	public void setTexts (Integer texts) {
		this.textTotal = texts;
	}
	//data
	public Integer getData () {
		return this.dataUsage;
	}
	public void setData (Integer data) {
		this.dataUsage = data;
	}
	
	
	// billing return
	public Double CallCost () {
		Double total_mobile = this.getLandline() * this.mobile_callCost;
		Double total_landline = this.getLandline() * this.landline_callCost;
		Double total = total_mobile + total_landline + ((total_mobile + total_landline)*callTax);
		return total;
	}
	public Double TextCost () {
		Double total = this.getTexts()*this.textCost + ((this.getTexts()*this.textCost)*textTax);
		return total;
	}
	public Double DataCost () {
		Double total = this.getData()*this.dataCost + ((this.getData()*this.dataCost)*dataTax);
		return total;
	}
	
}
