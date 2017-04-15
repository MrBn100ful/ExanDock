package fr.MrBn100ful.ExanLauncher;

import java.io.File;

public class SetupFiles {

	public static String[] setup(){
		
    
    File iconsdirectory = new File("/exanlauncher/");
    
    if (!iconsdirectory.exists()){
    	new File("/exanlauncher/config/").mkdirs();
    	new File("/exanlauncher/icons/icon1/").mkdirs();
    	new File("/exanlauncher/icons/icon2/").mkdirs();
    	new File("/exanlauncher/icons/icon3/").mkdirs();
    	new File("/exanlauncher/icons/icon4/").mkdirs();
    	new File("/exanlauncher/icons/icon5/").mkdirs();
    	new File("/exanlauncher/icons/icon6/").mkdirs();
    	new File("/exanlauncher/icons/icon7/").mkdirs();
    	new File("/exanlauncher/icons/icon8/").mkdirs();
    	new File("/exanlauncher/icons/icon9/").mkdirs();
    	new File("/exanlauncher/icons/icon10/").mkdirs();
    	
    	}
	return null;
	}
}
