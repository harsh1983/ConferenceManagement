package com.cm;

import java.util.List;

import com.cm.bo.Conference;
import com.cm.bo.Session;
import com.cm.bo.Talks;
import com.cm.schedular.ConferenceScheduler;

public class ScheduleConference {
	
	
	public ScheduleConference() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Can read the list of talks from any feed or we can directly invoke this method bleow
	 */

	public Conference scheduleConference(List<Talks> talkList){
		 Conference cf =ConferenceScheduler.schedule(talkList);
		 List<Session>  session = cf.getSession();
		 for(int i=0; i< session.size(); i++){
			 List<Talks> tk = session.get(i).getTalks();
			 System.out.println("Track " + i);
			 for(int k=0 ; k<tk.size() ;k++){
				 System.out.println(tk.get(k));
			 }
		 }
		 return cf;
	}
}
