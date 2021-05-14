package com.lemmanet;

import java.text.DateFormatSymbols;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		
		System.out.println(findDay(1,2,2021));

		   Scanner scanner = new Scanner(System.in);
	        double payment = scanner.nextDouble();
	        scanner.close();
	        
	        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
	        String us = nf.format(payment);
	
	        nf = NumberFormat.getCurrencyInstance(new Locale("en","in"));
	        String india = nf.format(payment);
	        nf = NumberFormat.getCurrencyInstance(Locale.CHINA);
	        String china = nf.format(payment);
	        nf = NumberFormat.getCurrencyInstance(Locale.FRANCE);
	        String france= nf.format(payment);
	        
	        // Write your code here.
	        
			System.out.println("US: " + us);
			System.out.println("India: " + india);
			System.out.println("China: " + china);
			System.out.println("France: " + france);
	        System.out.print('a'+1);
	}
	 private static String capitalize(String str){
	        return (str.substring(0,0).toUpperCase()+str.substring(1));
	    }
public static String findDay(int month, int day, int year) {
        
        Calendar cal = Calendar.getInstance();
        cal.set(year,month-1,day);
        return cal.getDisplayName(Calendar.DAY_OF_WEEK, java.util.Calendar.LONG, Locale.getDefault()).toUpperCase();
        //return DateFormatSymbols.getInstance().getWeekdays()[cal.get(Calendar.DAY_OF_WEEK)].toUpperCase();




}

}
