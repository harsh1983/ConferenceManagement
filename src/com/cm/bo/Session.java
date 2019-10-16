package com.cm.bo;

import java.util.ArrayList;
import java.util.List;
import static  com.cm.util.TimeCalculator.substractTime;
import static  com.cm.util.TimeCalculator.timeInMinutes;
import com.cm.util.SessionType;

public class Session {

	    private final List<Talks> talks = new ArrayList<>(15);
	    private int remainingTime;
	    private final String startTime;
	    private final String endTime;
	    private String lastTaskTime ;
        private final SessionType sessionType ;
        private final String description ;
//        private final Integer priority ;
	    /*
	     * I am assuming the startTime and endTime in 0-24 hr format
	     * so startTime cannot be before 9 am and not after 5 pm ie 17 
	     * similarly end time cannot be before 9:05 
	     */
	    public Session(SessionType sessionType,String description ,String startTime,String endTime) {
			super();
			// if((startTime>17  || startTime<9) && endTime<startTime ) throw new RuntimeException("Incorrect Time");			
			this.startTime = startTime;
			this.endTime =endTime;
			this.remainingTime = timeInMinutes(substractTime(startTime, endTime)) ;// converting hour time in minutes
			this.sessionType = sessionType;
			this.description =  description;
			this.lastTaskTime = startTime;
			
		}

	    public void addTalks(Talks talk) {
	        if (remainingTime < talk.getDuration()) {
	            throw new RuntimeException("No time left for talk " + talk.getDescription() + " in this session");
	        }
	        talks.add(talk);
	        remainingTime -= talk.getDuration();
	    }

	    public boolean hasTimeForNextTalk(Talks talk) {
	        return remainingTime >= talk.getDuration();
	    }

		public SessionType getSessionType() {
			return sessionType;
		}

		public int getRemainingTime() {
			return remainingTime;
		}

		public String getStartTime() {
			return startTime;
		}

		public String getEndTime() {
			return endTime;
		}
		

		public String getDescription() {
			return description;
		}
		


		public String getLastTaskTime() {
			return lastTaskTime;
		}

		public void setLastTaskTime(String lastTaskTime) {
			this.lastTaskTime = lastTaskTime;
		}

		/*@Override
		public String toString() {
			return "Session [talks=" + talks + ", remainingTime=" + remainingTime + ", startTime=" + startTime
					+ ", endTime=" + endTime + ", sessionType=" + sessionType + ", description=" + description + "]";
		}*/

		public List<Talks> getTalks() {
			return talks;
		}

		
		
	
}
