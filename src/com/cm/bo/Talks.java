package com.cm.bo;

import java.util.Objects;

public class Talks {

	
	private final String description;
    private final Integer duration;
    private  String startTime;
    
    
	public Talks(String description, Integer duration) {
		super();		
		 Objects.requireNonNull(description);
		 //All talk lengths are either in minutes (not hours) or lightning (5 minutes) , so any duration<5 throws exception
		 //Need lunch and break sessions so max interval is between 9am-12pm ie 120 so no sinlgesession can be scheduled for time more than 120 minutes
    	 if(duration>120 || duration<5) throw new RuntimeException("Incorrect duration");
		this.description = description;
		this.duration = duration;
	}
	
	public String getDescription() {
		return description;
	}
	public Integer getDuration() {
		return duration;
	}
	
	

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	@Override
	public String toString() {
//		return "Talks [ startTime=" + startTime +" description=" + description + ", duration=" + duration +  "]";
		return " startTime=" + startTime +" description=" + description + ", duration=" + duration ;
	}

    
}
