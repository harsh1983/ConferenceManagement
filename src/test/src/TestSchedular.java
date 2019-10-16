package test.src;


import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.cm.ScheduleConference;
import com.cm.bo.Conference;
import com.cm.bo.Talks;


public class TestSchedular {

	
	@Test
	public void test_scheduleMeeting() {
		ScheduleConference sc = new ScheduleConference();
		List<Talks> talk = new ArrayList<>(25);
		talk.add(new Talks("Writing Fast Tests Against Enterprise Rails",60));
		talk.add(new Talks("Overdoing it in Python",45));
		talk.add(new Talks("Lua for the Masses",30));
		talk.add(new Talks("Ruby Errors from Mismatched Gem Versions",45));
		talk.add(new Talks("Common Ruby Errors",45));
		talk.add(new Talks("Rails for Python Developers lightning",60));
		talk.add(new Talks("Communicating Over Distance",60));
		talk.add(new Talks("Accounting-Driven Development",45));
		talk.add(new Talks("Woah",30));
		talk.add(new Talks("Pair Programming vs Noise",45));
		talk.add(new Talks("Rails Magic",60));
		talk.add(new Talks("Ruby on Rails: Why We Should Move On",60));
		talk.add(new Talks("Clojure Ate Scala (on my project)",45));
		talk.add(new Talks("Programming in the Boondocks of Seattle",30));
		talk.add(new Talks("Ruby vs. Clojure for Back-End Development",30));
		talk.add(new Talks("Ruby on Rails Legacy App Maintenance",60));
		talk.add(new Talks("A World Without HackerNews",30));
		talk.add(new Talks("User Interface CSS in Rails Apps",30));
		Conference cf = sc.scheduleConference(talk);
		
		
		System.out.println(cf.getSession().toString());
    	Assert.assertEquals(4, cf.getSession().size());
	}
}
