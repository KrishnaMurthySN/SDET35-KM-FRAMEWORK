package com.crm.comcast.generic_utilities;

import java.util.Date;
import java.util.Random;
//jllib up
public class Java_Utilities {
	
	public int randumNum(int rnum)
	{
		Random random = new Random();
		return rnum = random.nextInt(1000);
	
		
	}

	public String  getSystemDateInIST() {
		Date date = new Date();
		String currentDate = date.toString();
		System.out.println(currentDate);
		String[] arr = currentDate.split(" ");
		
		String yyyy = arr[5];
		String dd = arr[2];
		int mm = date.getMonth()+1;
	
			String formate = dd+"-"+mm+"-"+yyyy;
			return formate;
	}

}
