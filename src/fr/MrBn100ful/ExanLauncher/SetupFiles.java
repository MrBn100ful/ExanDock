package fr.MrBn100ful.ExanLauncher;

import java.io.File;

public class SetupFiles {

	public static String[] setup(){
		
	File configdirectory = new File("/config/");
    if (! configdirectory.exists()){
    	configdirectory.mkdir();
    }
    
    File iconsdirectory = new File("/icons/");
    
    if (!iconsdirectory.exists()){
    	new File("/icons/icon1/").mkdirs();
    	new File("/icons/icon2/").mkdirs();
    	new File("/icons/icon3/").mkdirs();
    	new File("/icons/icon4/").mkdirs();
    	new File("/icons/icon5/").mkdirs();
    	new File("/icons/icon6/").mkdirs();
    	new File("/icons/icon7/").mkdirs();
    	new File("/icons/icon8/").mkdirs();
    	new File("/icons/icon9/").mkdirs();
    	new File("/icons/icon10/").mkdirs();
    	
    	}
	return null;
	}
}
