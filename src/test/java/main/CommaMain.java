package main;

import java.util.Arrays;

public class CommaMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    String s = "Sachin,,M,\"Maths,Science,English\",Need to improve in these subjects.";
	    String[] splitted = s.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");

	    for (int i=0; i < splitted.length; i++) {
	    	if(splitted[i].contains("\"")) {
	    		System.out.println(">>>");
	    		splitted[i] = splitted[i].replace("\"", "");
	    	}
	    	System.out.println(splitted[i]);
	    }
	    
	    
	}

}
