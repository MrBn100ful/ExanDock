package fr.MrBn100ful.ExanDock;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JFrame;

import fr.MrBn100ful.ExanDock.Shutdown;

public class IconDeleteSystem {
	
	public static JFrame deletemenu = new JFrame();
	
	static Shutdown shutdown = new Shutdown();

	static GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	
	static int width = gd.getDisplayMode().getWidth();
	
	static int height = gd.getDisplayMode().getHeight();
	
	public static int var = 1;
	
	public static int iconinfonumber = 10;;
	
	public static int iconset = 0 ;
	
	public static boolean firsttime = false;
	
	@SuppressWarnings("unused")
	public static String[] icondel(){
		
		
		if (firsttime == false){
			
			style2();
			
			firsttime = true;
		}
		
		
		System.out.println("[Debug] :  Deletes icons button pressed");
		
		deletemenu.setTitle("Program Delete icon");
		
		deletemenu.setSize(255, 574);
		
		JButton icon1 = new JButton("Delete icon 1");
		JButton icon2 = new JButton("Delete icon 2");
		JButton icon3 = new JButton("Delete icon 3");
		JButton icon4 = new JButton("Delete icon 4");
		JButton icon5 = new JButton("Delete icon 5");
		JButton icon6 = new JButton("Delete icon 6");
		JButton icon7 = new JButton("Delete icon 7");
		JButton icon8 = new JButton("Delete icon 8");
		JButton icon9 = new JButton("Delete icon 9");
		JButton icon10 = new JButton("Delete icon 10");
		JButton iconall = new JButton("Deletes all icons");
		
		
		
		String configpath = "/exandock/config/config.txt";
		
		String configfile = null;
		
		try {
			configfile = new String(Files.readAllBytes(Paths.get(configpath)));
		} catch (IOException e2) {

			e2.printStackTrace();
		}
		
		String colorloc = configfile;
		
		if (colorloc.equals("right") ){
			deletemenu.setLocation((width - 850),(height / 2) - 340);
		}else {
			
			deletemenu.setLocation(590,(height / 2) - 340);
			
		}
		
		FileReader iconinforead;
		
		try {
			
			iconinforead = new FileReader("/exandock/icons/iconinfo.txt");
			iconinfonumber = iconinforead.read();
		
		} catch (FileNotFoundException e3) {
			
			e3.printStackTrace();
		
		} catch (IOException e1) {

			e1.printStackTrace();
		}
		
		
		if (iconinfonumber != 0){
			
			iconset = iconinfonumber - 1;
		}
				
		icon1.setBounds(0, 0, 250, 50);
		icon2.setBounds(0, 50, 250, 50);
		icon3.setBounds(0, 100, 250, 50);
		icon4.setBounds(0, 150, 250, 50);
		icon5.setBounds(0, 200, 250, 50);
		icon6.setBounds(0, 250, 250, 50);
		icon7.setBounds(0, 300, 250, 50);
		icon8.setBounds(0, 350, 250, 50);
		icon9.setBounds(0, 400, 250, 50);
		icon10.setBounds(0, 450, 250, 50);
		iconall.setBounds(0, 500, 250, 50);
		
		icon1.setFocusPainted(false);
		icon2.setFocusPainted(false);
		icon3.setFocusPainted(false);
		icon4.setFocusPainted(false);
		icon5.setFocusPainted(false);
		icon6.setFocusPainted(false);
		icon7.setFocusPainted(false);
		icon8.setFocusPainted(false);
		icon9.setFocusPainted(false);
		icon10.setFocusPainted(false);
		iconall.setFocusPainted(false);
		
		deletemenu.add(icon1);
		deletemenu.add(icon2);
		deletemenu.add(icon3);
		deletemenu.add(icon4);
		deletemenu.add(icon5);
		deletemenu.add(icon6);
		deletemenu.add(icon7);
		deletemenu.add(icon8);
		deletemenu.add(icon9);
		deletemenu.add(icon10);
		deletemenu.add(iconall);

		deletemenu.setResizable(false);
		
		deletemenu.getContentPane().setLayout(null);
		
		deletemenu.setVisible(true);
		
		icon1.addActionListener(new ActionListener() { 
			 
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) { 

				File directory = new File("/exandock/icons/icon1/");

				
					try {
						delete(directory);
					} catch (IOException e2) {

						e2.printStackTrace();
					}

				File dir = new File("/exandock/icons/icon2");
                File newName = new File("/exandock/icons/icon1");
				dir.renameTo(newName);
				
				File dir3 = new File("/exandock/icons/icon3");
                File newName3 = new File("/exandock/icons/icon2");
                dir3.renameTo(newName3);
				
				File dir4 = new File("/exandock/icons/icon4");
                File newName4 = new File("/exandock/icons/icon3");
                dir4.renameTo(newName4);
				
				File dir5 = new File("/exandock/icons/icon5");
                File newName5 = new File("/exandock/icons/icon4");
                dir5.renameTo(newName5);
				
				File dir6 = new File("/exandock/icons/icon6");
                File newName6 = new File("/exandock/icons/icon5");
                dir6.renameTo(newName6);
				
				File dir7 = new File("/exandock/icons/icon7");
                File newName7 = new File("/exandock/icons/icon6");
                dir7.renameTo(newName7);
				
				File dir8 = new File("/exandock/icons/icon8");
                File newName8 = new File("/exandock/icons/icon7");
                dir8.renameTo(newName8);
				
				File dir9 = new File("/exandock/icons/icon9");
                File newName9 = new File("/exandock/icons/icon8");
                dir9.renameTo(newName9);
				
				File dir10 = new File("/exandock/icons/icon10");
                File newName10 = new File("/exandock/icons/icon9");
                dir10.renameTo(newName10);
				
                new File("/exandock/icons/icon10/").mkdirs();
                
                File config = new File("/exandock/icons/iconinfo.txt");
				FileWriter iconinfowriter = null;
				int configplace = 10;
				try {
					iconinfowriter = new FileWriter(config);
					iconinfowriter.write(iconset);
					iconinfowriter.flush();
					iconinfowriter.close();
					shutdown.restartApplication(null);
				} catch (IOException e1) {
					System.out.println("[Debug] :  Error");
					e1.printStackTrace();
				}
               
				
			  }
		});
		
		icon2.addActionListener(new ActionListener() { 
			 
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) { 
				File directory = new File("/exandock/icons/icon2/");

				try {
					delete(directory);
				} catch (IOException e1) {
					e1.printStackTrace();
				}

				File dir3 = new File("/exandock/icons/icon3");
                File newName3 = new File("/exandock/icons/icon2");
                dir3.renameTo(newName3);
				
				File dir4 = new File("/exandock/icons/icon4");
                File newName4 = new File("/exandock/icons/icon3");
                dir4.renameTo(newName4);
				
				File dir5 = new File("/exandock/icons/icon5");
                File newName5 = new File("/exandock/icons/icon4");
                dir5.renameTo(newName5);
				
				File dir6 = new File("/exandock/icons/icon6");
                File newName6 = new File("/exandock/icons/icon5");
                dir6.renameTo(newName6);
				
				File dir7 = new File("/exandock/icons/icon7");
                File newName7 = new File("/exandock/icons/icon6");
                dir7.renameTo(newName7);
				
				File dir8 = new File("/exandock/icons/icon8");
                File newName8 = new File("/exandock/icons/icon7");
                dir8.renameTo(newName8);
				
				File dir9 = new File("/exandock/icons/icon9");
                File newName9 = new File("/exandock/icons/icon8");
                dir9.renameTo(newName9);
				
				File dir10 = new File("/exandock/icons/icon10");
                File newName10 = new File("/exandock/icons/icon9");
                dir10.renameTo(newName10);
				
                
                new File("/exandock/icons/icon10/").mkdirs();
                
                File config = new File("/exandock/icons/iconinfo.txt");
				FileWriter iconinfowriter = null;
				int configplace = 10;
				try {
					iconinfowriter = new FileWriter(config);
					iconinfowriter.write(iconset);
					iconinfowriter.flush();
					iconinfowriter.close();
					shutdown.restartApplication(null);
				} catch (IOException e1) {
					System.out.println("[Debug] :  Error");
					e1.printStackTrace();
				}
			  }
		});
		
		icon3.addActionListener(new ActionListener() { 
			 
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) { 
				File directory = new File("/exandock/icons/icon3/");

				try {
					delete(directory);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				File dir4 = new File("/exandock/icons/icon4");
                File newName4 = new File("/exandock/icons/icon3");
                dir4.renameTo(newName4);
				
				File dir5 = new File("/exandock/icons/icon5");
                File newName5 = new File("/exandock/icons/icon4");
                dir5.renameTo(newName5);
				
				File dir6 = new File("/exandock/icons/icon6");
                File newName6 = new File("/exandock/icons/icon5");
                dir6.renameTo(newName6);
				
				File dir7 = new File("/exandock/icons/icon7");
                File newName7 = new File("/exandock/icons/icon6");
                dir7.renameTo(newName7);
				
				File dir8 = new File("/exandock/icons/icon8");
                File newName8 = new File("/exandock/icons/icon7");
                dir8.renameTo(newName8);
				
				File dir9 = new File("/exandock/icons/icon9");
                File newName9 = new File("/exandock/icons/icon8");
                dir9.renameTo(newName9);
				
				File dir10 = new File("/exandock/icons/icon10");
                File newName10 = new File("/exandock/icons/icon9");
                dir10.renameTo(newName10);
				
                new File("/exandock/icons/icon10/").mkdirs();
                
                File config = new File("/exandock/icons/iconinfo.txt");
				FileWriter iconinfowriter = null;
				int configplace = 10;
				try {
					iconinfowriter = new FileWriter(config);
					iconinfowriter.write(iconset);
					iconinfowriter.flush();
					iconinfowriter.close();
					shutdown.restartApplication(null);
				} catch (IOException e1) {
					System.out.println("[Debug] :  Error");
					e1.printStackTrace();
				}
			  }
		});
		
		icon4.addActionListener(new ActionListener() { 
			 
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) { 
				File directory = new File("/exandock/icons/icon4/");

				try {
					delete(directory);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				File dir5 = new File("/exandock/icons/icon5");
                File newName5 = new File("/exandock/icons/icon4");
                dir5.renameTo(newName5);
				
				File dir6 = new File("/exandock/icons/icon6");
                File newName6 = new File("/exandock/icons/icon5");
                dir6.renameTo(newName6);
				
				File dir7 = new File("/exandock/icons/icon7");
                File newName7 = new File("/exandock/icons/icon6");
                dir7.renameTo(newName7);
				
				File dir8 = new File("/exandock/icons/icon8");
                File newName8 = new File("/exandock/icons/icon7");
                dir8.renameTo(newName8);
				
				File dir9 = new File("/exandock/icons/icon9");
                File newName9 = new File("/exandock/icons/icon8");
                dir9.renameTo(newName9);
				
				File dir10 = new File("/exandock/icons/icon10");
                File newName10 = new File("/exandock/icons/icon9");
                dir10.renameTo(newName10);
				
                new File("/exandock/icons/icon10/").mkdirs();
                
                File config = new File("/exandock/icons/iconinfo.txt");
				FileWriter iconinfowriter = null;
				int configplace = 10;
				try {
					iconinfowriter = new FileWriter(config);
					iconinfowriter.write(iconset);
					iconinfowriter.flush();
					iconinfowriter.close();
					shutdown.restartApplication(null);
				} catch (IOException e1) {
					System.out.println("[Debug] :  Error");
					e1.printStackTrace();
				}
			  }
		});
		
		icon5.addActionListener(new ActionListener() { 
			 
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) { 
				File directory = new File("/exandock/icons/icon5/");

				try {
					delete(directory);
				} catch (IOException e1) {
					e1.printStackTrace();
				}

				
				File dir6 = new File("/exandock/icons/icon6");
                File newName6 = new File("/exandock/icons/icon5");
                dir6.renameTo(newName6);
				
				File dir7 = new File("/exandock/icons/icon7");
                File newName7 = new File("/exandock/icons/icon6");
                dir7.renameTo(newName7);
				
				File dir8 = new File("/exandock/icons/icon8");
                File newName8 = new File("/exandock/icons/icon7");
                dir8.renameTo(newName8);
				
				File dir9 = new File("/exandock/icons/icon9");
                File newName9 = new File("/exandock/icons/icon8");
                dir9.renameTo(newName9);
				
				File dir10 = new File("/exandock/icons/icon10");
                File newName10 = new File("/exandock/icons/icon9");
                dir10.renameTo(newName10);
				
                new File("/exandock/icons/icon10/").mkdirs();
                
                File config = new File("/exandock/icons/iconinfo.txt");
				FileWriter iconinfowriter = null;
				int configplace = 10;
				try {
					iconinfowriter = new FileWriter(config);
					iconinfowriter.write(iconset);
					iconinfowriter.flush();
					iconinfowriter.close();
					shutdown.restartApplication(null);
				} catch (IOException e1) {
					System.out.println("[Debug] :  Error");
					e1.printStackTrace();
				}
			  }
		});
		
		icon6.addActionListener(new ActionListener() { 
			 
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) { 
				File directory = new File("/exandock/icons/icon6/");

				try {
					delete(directory);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				File dir7 = new File("/exandock/icons/icon7");
                File newName7 = new File("/exandock/icons/icon6");
                dir7.renameTo(newName7);
				
				File dir8 = new File("/exandock/icons/icon8");
                File newName8 = new File("/exandock/icons/icon7");
                dir8.renameTo(newName8);
				
				File dir9 = new File("/exandock/icons/icon9");
                File newName9 = new File("/exandock/icons/icon8");
                dir9.renameTo(newName9);
				
				File dir10 = new File("/exandock/icons/icon10");
                File newName10 = new File("/exandock/icons/icon9");
                dir10.renameTo(newName10);
				
                new File("/exandock/icons/icon10/").mkdirs();
                
                File config = new File("/exandock/icons/iconinfo.txt");
				FileWriter iconinfowriter = null;
				int configplace = 10;
				try {
					iconinfowriter = new FileWriter(config);
					iconinfowriter.write(iconset);
					iconinfowriter.flush();
					iconinfowriter.close();
					shutdown.restartApplication(null);
				} catch (IOException e1) {
					System.out.println("[Debug] :  Error");
					e1.printStackTrace();
				}
			  }
		});
		
		icon7.addActionListener(new ActionListener() { 
			 
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) { 
				File directory = new File("/exandock/icons/icon7/");

				try {
					delete(directory);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				File dir8 = new File("/exandock/icons/icon8");
                File newName8 = new File("/exandock/icons/icon7");
                dir8.renameTo(newName8);
				
				File dir9 = new File("/exandock/icons/icon9");
                File newName9 = new File("/exandock/icons/icon8");
                dir9.renameTo(newName9);
				
				File dir10 = new File("/exandock/icons/icon10");
                File newName10 = new File("/exandock/icons/icon9");
                dir10.renameTo(newName10);
				
                new File("/exandock/icons/icon10/").mkdirs();
                
                File config = new File("/exandock/icons/iconinfo.txt");
				FileWriter iconinfowriter = null;
				int configplace = 10;
				try {
					iconinfowriter = new FileWriter(config);
					iconinfowriter.write(iconset);
					iconinfowriter.flush();
					iconinfowriter.close();
					shutdown.restartApplication(null);
				} catch (IOException e1) {
					System.out.println("[Debug] :  Error");
					e1.printStackTrace();
				}
			  }
		});
		
		icon8.addActionListener(new ActionListener() { 
			 
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) { 
				File directory = new File("/exandock/icons/icon8/");

				try {
					delete(directory);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				File dir9 = new File("/exandock/icons/icon9");
                File newName9 = new File("/exandock/icons/icon8");
                dir9.renameTo(newName9);
				
				File dir10 = new File("/exandock/icons/icon10");
                File newName10 = new File("/exandock/icons/icon9");
                dir10.renameTo(newName10);
				
                new File("/exandock/icons/icon10/").mkdirs();
                
                File config = new File("/exandock/icons/iconinfo.txt");
				FileWriter iconinfowriter = null;
				int configplace = 10;
				try {
					iconinfowriter = new FileWriter(config);
					iconinfowriter.write(iconset);
					iconinfowriter.flush();
					iconinfowriter.close();
					shutdown.restartApplication(null);
				} catch (IOException e1) {
					System.out.println("[Debug] :  Error");
					e1.printStackTrace();
				}
			  }
		});
		
		icon9.addActionListener(new ActionListener() { 
			 
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) { 
				File directory = new File("/exandock/icons/icon9/");

				try {
					delete(directory);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				File dir10 = new File("/exandock/icons/icon10");
                File newName10 = new File("/exandock/icons/icon9");
                dir10.renameTo(newName10);
				
                new File("/exandock/icons/icon10/").mkdirs();
                
                File config = new File("/exandock/icons/iconinfo.txt");
				FileWriter iconinfowriter = null;
				int configplace = 10;
				try {
					iconinfowriter = new FileWriter(config);
					iconinfowriter.write(iconset);
					iconinfowriter.flush();
					iconinfowriter.close();
					shutdown.restartApplication(null);
				} catch (IOException e1) {
					System.out.println("[Debug] :  Error");
					e1.printStackTrace();
				}
			  }
		});
		
		icon10.addActionListener(new ActionListener() { 
			 
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) { 
				File directory = new File("/exandock/icons/icon10/");

				try {
					delete(directory);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
                new File("/exandock/icons/icon10/").mkdirs();
                
                File config = new File("/exandock/icons/iconinfo.txt");
				FileWriter iconinfowriter = null;
				int configplace = 10;
				try {
					iconinfowriter = new FileWriter(config);
					iconinfowriter.write(iconset);
					iconinfowriter.flush();
					iconinfowriter.close();
					shutdown.restartApplication(null);
				} catch (IOException e1) {
					System.out.println("[Debug] :  Error");
					e1.printStackTrace();
				}
			  }
		});
		
		iconall.addActionListener(new ActionListener() { 
			 
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) { 
				while (var < 11) {
					File file = new File("/exandock/icons/icon" + var + "/icon.txt");
					file.delete();
					
					File file2 = new File("/exandock/icons/icon" + var + "/icon.png");
					file2.delete();
					
					File file2d = new File("/exandock/config/debug.txt");
					file2d.delete();
					
					File filed = new File("/exandock/icons/iconinfo.txt");
					filed.delete();
					
					FileWriter iconinforead;
					try {
						iconinforead = new FileWriter("/exandock/icons/iconinfo.txt");
						int configplace = 1;
						iconinforead.write(configplace);
						iconinforead.flush();
						iconinforead.close();
					} catch (IOException e1) {
						System.out.println("[Debug] :  Reset of iconinfo.txt bug");
						e1.printStackTrace();
					}

					var = var + 1;
				}
				try {
					shutdown.restartApplication(null);
				} catch (IOException e1) {
					System.out.println("[Debug] :  Restart bug");
					e1.printStackTrace();
				}
			  }
		});
		return null;
		
	}
	
	public static void delete(File file)
	    	throws IOException{
	    	if(file.isDirectory()){
	    		if(file.list().length==0){
	    		   file.delete();
	    		}else{
	        	   String files[] = file.list();
	        	   for (String temp : files) {
	        	      File fileDelete = new File(file, temp);
	        	     delete(fileDelete);
	        	   }

	        	   if(file.list().length==0){
	           	     file.delete();
	        	   }
	    		}
	    	}else{
	    		file.delete();
	    	}
	    }
	
	public static void style2(){
		
		deletemenu.setType(javax.swing.JFrame.Type.UTILITY);
		
	}
}
