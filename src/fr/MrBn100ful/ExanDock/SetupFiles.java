package fr.MrBn100ful.ExanDock;

import java.io.File;

public class SetupFiles {

	public static String[] setup(){
		
    
    File iconsdirectory = new File("/exandock/");
    
    if (!iconsdirectory.exists()){
    	new File("/exandock/config/").mkdirs();
    	new File("/exandock/icons/icon1/").mkdirs();
    	new File("/exandock/icons/icon2/").mkdirs();
    	new File("/exandock/icons/icon3/").mkdirs();
    	new File("/exandock/icons/icon4/").mkdirs();
    	new File("/exandock/icons/icon5/").mkdirs();
    	new File("/exandock/icons/icon6/").mkdirs();
    	new File("/exandock/icons/icon7/").mkdirs();
    	new File("/exandock/icons/icon8/").mkdirs();
    	new File("/exandock/icons/icon9/").mkdirs();
    	new File("/exandock/icons/icon10/").mkdirs();
    	
    	}
	return null;
	}
}
