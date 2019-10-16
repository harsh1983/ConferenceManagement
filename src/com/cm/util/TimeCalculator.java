package com.cm.util;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeCalculator {

	private final static DateTimeFormatter df = DateTimeFormatter.ofPattern("HH:mm:ss a");

	public static String addTime(String startTime, String minutes) {
		String[] firstTimeParts = startTime.split(":");
		int hours1 = Integer.parseInt(firstTimeParts[0]);
		int minutes1 = Integer.parseInt(firstTimeParts[1]);
		LocalTime t1 = LocalTime.of(new Integer(hours1), new Integer(minutes1));
		t1 = t1.plusMinutes(new Integer(minutes));
		return t1.format(df);
	}

	public static String substractTime(String startTime, String secondTime) {
		String[] firstTimeParts = startTime.split(":");
		int hours1 = Integer.parseInt(firstTimeParts[0]);
		int minutes1 = Integer.parseInt(firstTimeParts[1]);
		LocalTime t1 = LocalTime.of(new Integer(hours1), new Integer(minutes1));
		String[] secondTimeParts = secondTime.split(":");
		int hours2 = Integer.parseInt(secondTimeParts[0]);
		int minutes2 = Integer.parseInt(secondTimeParts[1]);
		LocalTime t2 = LocalTime.of(new Integer(hours2), new Integer(minutes2));
		t1 = t2.minusHours(hours1).minusMinutes(minutes1);
		return t1.toString();
	}

	public static Integer timeInMinutes(String time) {
		String[] firstTimeParts = time.split(":");
		int hours1 = Integer.parseInt(firstTimeParts[0]);
		int minutes1 = Integer.parseInt(firstTimeParts[1]);
		return hours1 * 60 + minutes1;
	}

	public static Boolean timeIsBtween(String beforeTime , String afterTime , String bwTime){
		
		String[] firstTimeParts = beforeTime.split(":");
		int hours1 = Integer.parseInt(firstTimeParts[0]);
		int minutes1 = Integer.parseInt(firstTimeParts[1]);
		LocalTime t1 = LocalTime.of(new Integer(hours1), new Integer(minutes1));
		String[] secondTimeParts = afterTime.split(":");
		int hours2 = Integer.parseInt(secondTimeParts[0]);
		int minutes2 = Integer.parseInt(secondTimeParts[1]);
		LocalTime t2 = LocalTime.of(new Integer(hours2), new Integer(minutes2));		
		String[] testTime = bwTime.split(":");
		int hours3 = Integer.parseInt(testTime[0]);
		int minutes3 = Integer.parseInt(testTime[1]);
		LocalTime t3 = LocalTime.of(new Integer(hours3), new Integer(minutes3));		
	   return t2.compareTo(t3) >0  && t3.compareTo(t1) >0;		
		
	}
	
public static Boolean timeIsBefore(String beforeTime , String afterTime){
		
		String[] firstTimeParts = beforeTime.split(":");
		int hours1 = Integer.parseInt(firstTimeParts[0]);
		int minutes1 = Integer.parseInt(firstTimeParts[1]);
		LocalTime t1 = LocalTime.of(new Integer(hours1), new Integer(minutes1));
		String[] secondTimeParts = afterTime.split(":");
		int hours2 = Integer.parseInt(secondTimeParts[0]);
		int minutes2 = Integer.parseInt(secondTimeParts[1]);
		LocalTime t2 = LocalTime.of(new Integer(hours2), new Integer(minutes2));	
		
	   return t1.compareTo(t2) <0 ;		
		
	}
}
