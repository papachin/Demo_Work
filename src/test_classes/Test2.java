package test_classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test2 {
	
	public static void main (String [] args) {
		List<PhoneKeeper> lst = new ArrayList<>();
		
		int pay1 = 3;
		int pay2 = 150;
		int amount = 0;
		
		String values = "00:01:07,400-234-090 00:05:01,701-080-080 00:05:00,400-234-090";
		String[] array = values.split("\\s+");
		Integer duration;
		
		for (String i: array) {			
			String[] temp = i.split("\\,");
			
			String[] units = temp[0].split(":");
			Integer hours = Integer.parseInt(units[0]);
			Integer minutes = Integer.parseInt(units[1]);
			Integer seconds = Integer.parseInt(units[2]);
			duration = (hours/3600) + (minutes*60) + seconds;
			
			lst.add(new PhoneKeeper(temp[1],duration));
		}
		
		PhoneKeeper maxPhone = Collections.max(lst, new PhoneComp());
			
		if (maxPhone.getTime() < 300) {
		    amount = maxPhone.getTime() *pay1;	    
		} else if (maxPhone.getTime() >= 300){
			amount = (int) (Math.ceil(maxPhone.getTime() / 60.0) * pay2);
		}
		
		System.out.println(amount);
	}
}


class PhoneComp implements Comparator<PhoneKeeper>{
	public int compare(PhoneKeeper p1, PhoneKeeper p2) {
		return p1.getTime().compareTo(p2.getTime());
	}
}

class PhoneKeeper {
    // variables
    String number;
    int time;
    
    PhoneKeeper () {/*defautl*/}
    PhoneKeeper (String num, Integer time){
        this.number = num;
        this.time = time;
    }
    
    // getters setters
    public void setNumber (String num) {
        this.number = num;
    }
    public String getNumber () {
        return this.number;
    }
    public void setTime (int time) {
        this.time = time;
    }
    public Integer getTime () {
        return this.time;
    }
    @Override
    public boolean equals (Object ob) {
    	return this == ob;
    }
}