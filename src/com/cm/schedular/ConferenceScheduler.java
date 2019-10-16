package com.cm.schedular;


import java.util.Iterator;
import java.util.List;
import static  com.cm.util.TimeCalculator.addTime;
import static  com.cm.util.TimeCalculator.timeIsBtween;
import com.cm.bo.Conference;
import static  com.cm.util.TimeCalculator.timeIsBefore;
import com.cm.bo.Session;
import com.cm.bo.Talks;
import com.cm.util.SessionType;
public final class ConferenceScheduler {

	
	public static Conference schedule(List<Talks> talkList) {
  	  Conference conference = new Conference();    	  
     if(talkList!=null && talkList.size()>0){
			Session morningSession = new Session(SessionType.MORNING_TALK, "Morning Talk Time", "09:00", "12:00");
			scheduleTalks(morningSession, talkList);
			conference.addSession(morningSession);
			Session lunchSession = new Session(SessionType.LUNCH_TIME, "Lunch", "12:00", "13:00");
			Talks lc = new Talks("Lunch", 60);
			lc.setStartTime("12:00");
			lunchSession.addTalks(lc);
			conference.addSession(lunchSession);
			Session afterNoonSession = new Session(SessionType.AFTERNOON_TALK, "Afternoon Talk Time", "13:00", "16:00");
			scheduleTalks(afterNoonSession, talkList);
			conference.addSession(afterNoonSession);

			Session networkSession = new Session(SessionType.NETWORKING, "Networking Event", "16:00", "17:00");
			Talks nw =new Talks("Networking Event", 60);
			nw.setStartTime(afterNoonSession.getEndTime());
			networkSession.addTalks(nw);
			conference.addSession(networkSession);

		}

     return conference;

  }



//TODO Can use knapsack algorithm to schedule the talks
	 private static void scheduleTalks(Session session, List<Talks> talkList) {
	        for (Iterator<Talks> iter = talkList.iterator(); iter.hasNext();) {
	        	Talks talk = iter.next();
	            if (session.hasTimeForNextTalk(talk) &&  isValidTalk(session,talk)) {
	            	String time = addTime(session.getLastTaskTime(), talk.getDuration().toString());
	            	talk.setStartTime(session.getLastTaskTime());
	            	session.addTalks(talk);
	            	session.setLastTaskTime(time);
	                iter.remove();
	            }
	        }
	    }

	 private static boolean isValidTalk(Session session, Talks talk){
		 String time = addTime(session.getLastTaskTime(), talk.getDuration().toString());
		 if(session.getSessionType()== SessionType.MORNING_TALK){
			 return  "12:00".equals(time) || timeIsBefore(time , "12:00");
			 
		 }else if(session.getSessionType()== SessionType.AFTERNOON_TALK){
			 if(timeIsBefore("1:00",time ) || timeIsBtween("16:00" , "17:00" ,  time)){
				 return true;
			 }else return false;
		 }
		 
		 return true;
	 }
	  
	 

}
