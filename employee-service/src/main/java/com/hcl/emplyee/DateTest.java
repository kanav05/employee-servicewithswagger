package com.hcl.emplyee;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DateTest {

	public static void main(String[] args) {

		LocalDate currentDate = LocalDate.now();
		LocalDate payToDate = LocalDate.now().plusDays(1);
		
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(" localDateTime "+localDateTime);
		
		LocalDate previousDate = LocalDate.now().minusDays(2);
		System.out.println("Current Date " + currentDate);
		
		if(payToDate.isAfter(currentDate)){
			System.out.println("Feature Date");
			System.out.println("Future Date " + currentDate.plusDays(1));
		}else {
			System.out.println("previous Date");
			
		}
		
		if(previousDate.isBefore(currentDate)){
			System.out.println("previous Date");
			System.out.println("previous date " + currentDate.minusDays(1));
		}else {
			System.out.println("Feature Date");
			
		}
		
		//
		
		//System.out.println("Future Date " + currentDate.plusDays(1));


	}

}
