package fr.MrBn100ful.ExanLauncher;

import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

/**
 *  Option class
 *  
 * @author MrBn100ful
 * 
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JFrame;






public class Option {
	
	static JButton delallicon = new JButton("Deletes all icons");
	static JButton closeexanlauncher = new JButton("Close ExanLauncher");
	
	static JButton left = new JButton("Put ExanLauncher on the left");
	static JButton right = new JButton("Put ExanLauncher on the right");
	
	public static JFrame optionmenu = new JFrame();

	public static int var = 1;
	
	public boolean optionMenuOpen = false;
	public boolean optionMenuCreate = false;
	
	static Shutdown shutdown = new Shutdown();
	private static boolean test = false;
	
	static GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	
	static int width = gd.getDisplayMode().getWidth();
	static int height = gd.getDisplayMode().getHeight();
	
	public static String[] Optionframe(){
		
		if  ( test != true ){
			style1();
			
			test = true;
		}
			
		optionmenu.setTitle("Program Options");
			
			optionmenu.setSize(255, 215);
			
			String configpath = "config.txt";
			
			String configfile = null;
			try {
				configfile = new String(Files.readAllBytes(Paths.get(configpath)));
			} catch (IOException e2) {

				e2.printStackTrace();
			}
			
			if (configfile.equals("r") ){
				optionmenu.setLocation((width - 550),(height / 2) - 340);
			}else {
				
				optionmenu.setLocation(290,(height / 2) - 340);
				
			}
			
			optionmenu.setResizable(false);
			
			closeexanlauncher.setBackground(new Color(243, 243, 243, 150));
			delallicon.setBackground(new Color(243, 243, 243, 150));
			left.setBackground(new Color(243, 243, 243, 150));
			right.setBackground(new Color(243, 243, 243, 150));
			
			closeexanlauncher.setFocusPainted(false);
			delallicon.setFocusPainted(false);
			left.setFocusPainted(false);
			right.setFocusPainted(false);

			
			optionmenu.setVisible(true);
			
			optionmenu.getContentPane().setLayout(null);

			
			
			delallicon.setBounds(0, 0, 120, 90);
			closeexanlauncher.setBounds(120, 0, 129, 90);
			
			left.setBounds(0, 90, 250, 50);
			right.setBounds(0, 140, 250, 50);
			
			
			optionmenu.add(left);
			optionmenu.add(right);
			
			optionmenu.add(delallicon);
			optionmenu.add(closeexanlauncher);
			
			closeexanlauncher.addActionListener(new ActionListener() { 
				 
				public void actionPerformed(ActionEvent e) { 
						System.out.println("[Debug] :  Stop button pressed");
						System.exit(0);
				  }
			});
			
			left.addActionListener(new ActionListener() { 
				 
				@SuppressWarnings("static-access")
				public void actionPerformed(ActionEvent e) { 
						System.out.println("[Debug] :  Left button pressed");
						File config = new File("config.txt");
						FileWriter iconinfowriter = null;
						String configplace = "l";
						try {
							iconinfowriter = new FileWriter(config);
							iconinfowriter.write(configplace);
							iconinfowriter.flush();
							iconinfowriter.close();
							shutdown.restartApplication(null);
						} catch (IOException e1) {
							System.out.println("[Debug] :  Error");
							e1.printStackTrace();
						}
						
						
						
				  }
			});
			
			right.addActionListener(new ActionListener() { 
				 
				@SuppressWarnings("static-access")
				public void actionPerformed(ActionEvent e) { 
						System.out.println("[Debug] :  Right button pressed");
						File config = new File("config.txt");
						FileWriter iconinfowriter = null;
						String configplace = "r";
						try {
							iconinfowriter = new FileWriter(config);
							iconinfowriter.write(configplace);
							iconinfowriter.flush();
							iconinfowriter.close();
							shutdown.restartApplication(null);
						} catch (IOException e1) {
							System.out.println("[Debug] :  Error");
							e1.printStackTrace();
						}
						
						
						
				  }
			});
			
			
			delallicon.addActionListener(new ActionListener() { 
				  @SuppressWarnings("static-access")
				public void actionPerformed(ActionEvent e) { 
						System.out.println("[Debug] :  Deletes all icons button pressed");
						
						while (var < 11) {
							File file = new File("icon" + var + ".txt");
							file.delete();
							
							File file2 = new File("icon" + var + ".png");
							file2.delete();
							
							File file2d = new File("debug.txt");
							file2d.delete();
							
							File filed = new File("iconinfo.txt");
							filed.delete();
							
							FileWriter iconinforead;
							try {
								iconinforead = new FileWriter("iconinfo.txt");
								iconinforead.write("");
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
				} );
			return null;
	}
public static void style1 (){
	optionmenu.setType(javax.swing.JFrame.Type.UTILITY);
	
}
}
