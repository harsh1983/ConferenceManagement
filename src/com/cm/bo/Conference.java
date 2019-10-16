package com.cm.bo;

import java.util.ArrayList;
import java.util.List;

public class Conference {

	   private final List<Session> session = new ArrayList<Session>(10);;
	    public Conference() {
	        
	    }


	    public void addSession(Session ses) {
	    	session.add(ses);
	    }
	   

		public List<Session> getSession() {
			return session;
		}

		@Override
		public String toString() {
			return "Conference [session=" + session + "]";
		}

		

	   
}
