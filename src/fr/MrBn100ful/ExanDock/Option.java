package fr.MrBn100ful.ExanDock;

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
import javax.swing.JOptionPane;

import fr.MrBn100ful.ExanDock.Shutdown;

public class Option {
	
	static JButton delallicon = new JButton("Deletes icons");
	
	static JButton closeexandock = new JButton("Close ExanDock");
	
	static JButton position = new JButton("Change the position of ExanDock");
	
	static JButton color = new JButton("Change color of ExanDock");
	
	public static JFrame optionmenu = new JFrame();
	
	public static JFrame colormenu = new JFrame();
	
	public static JFrame positionmenu = new JFrame();
	
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
			
			optionmenu.setSize(255, 213);
			
			String configpath = "/exandock/config/config.txt";
			
			String configfile = null;
			try {
				configfile = new String(Files.readAllBytes(Paths.get(configpath)));
			} catch (IOException e2) {

				e2.printStackTrace();
			}
			
			String colorloc = configfile;
			
			if (configfile.equals("right") ){
				
				optionmenu.setLocation((width - 550),(height / 2) - 340);
			
			}else if (configfile.equals("left")){
				
				optionmenu.setLocation(290,(height / 2) - 340);
				
			}else if (configfile.equals("up")){
			
				optionmenu.setLocation(290 , 0);

			
			}else if (configfile.equals("down")){

				optionmenu.setLocation((width/ 2), height - 400);
			
			}
			
			optionmenu.setResizable(false);
			
			closeexandock.setBackground(new Color(243, 243, 243, 150));
			
			delallicon.setBackground(new Color(243, 243, 243, 150));
			
			position.setBackground(new Color(243, 243, 243, 150));
			
			color.setBackground(new Color(243, 243, 243, 150));
			
			closeexandock.setFocusPainted(false);
			
			delallicon.setFocusPainted(false);
			
			position.setFocusPainted(false);
			
			color.setFocusPainted(false);
			
			optionmenu.getContentPane().setLayout(null);
			
			optionmenu.setVisible(true);
			
			delallicon.setBounds(0, 0, 120, 90);
			
			closeexandock.setBounds(120, 0, 129, 90);
			
			position.setBounds(0, 90, 250, 50);
			
			color.setBounds(0, 140, 250, 50);
			
			optionmenu.add(position);
			
			optionmenu.add(delallicon);
			
			optionmenu.add(closeexandock);
			
			optionmenu.add(color);
			
			closeexandock.addActionListener(new ActionListener() { 
				 
				public void actionPerformed(ActionEvent e) { 
						System.out.println("[Debug] :  Stop button pressed");
						
					int n = JOptionPane.showConfirmDialog(  
							optionmenu,
				                "Close ExanDock ?" ,
				                "Info ExanDock",
				                JOptionPane.YES_NO_OPTION);

				      if(n == JOptionPane.YES_OPTION){
				    	  System.exit(0);
				      }		
				  }
			});
			
			color.addActionListener(new ActionListener() { 
				 
				public void actionPerformed(ActionEvent e) { 
	
						System.out.println("[Debug] :  Color button pressed");
						
						colormenu.setTitle("Program Color");
						
						colormenu.setSize(255, 473);
						
						JButton gray = new JButton("Change color to gray");
						JButton red = new JButton("Change color to red");
						JButton green = new JButton("Change color to green");
						JButton blue = new JButton("Change color to blue");
						JButton white = new JButton("Change color to white");
						JButton yellow = new JButton("Change color to yellow");
						JButton pink = new JButton("Change color to pink");
						JButton purple = new JButton("Change color to purple");
						JButton orange = new JButton("Change color to orange");
						
						if (colorloc.equals("right") ){
							colormenu.setLocation((width - 850),(height / 2) - 340);
						}else {
							
							colormenu.setLocation(590,(height / 2) - 340);
							
						}
						gray.setBounds(0, 0, 250, 50);
						red.setBounds(0, 50, 250, 50);
						green.setBounds(0, 100, 250, 50);
						blue.setBounds(0, 150, 250, 50);
						white.setBounds(0, 200, 250, 50);
						yellow.setBounds(0, 250, 250, 50);
						pink.setBounds(0, 300, 250, 50);
						purple.setBounds(0, 350, 250, 50);
						orange.setBounds(0, 400, 250, 50);
						
						gray.setFocusPainted(false);
						red.setFocusPainted(false);
						green.setFocusPainted(false);
						blue.setFocusPainted(false);
						white.setFocusPainted(false);
						yellow.setFocusPainted(false);
						pink.setFocusPainted(false);
						purple.setFocusPainted(false);
						orange.setFocusPainted(false);
						
						colormenu.add(gray);
						colormenu.add(red);
						colormenu.add(green);
						colormenu.add(blue);
						colormenu.add(white);
						colormenu.add(yellow);
						colormenu.add(pink);
						colormenu.add(purple);
						colormenu.add(orange);

						colormenu.setResizable(false);
						
						colormenu.getContentPane().setLayout(null);
						
						colormenu.setVisible(true);
						
						gray.addActionListener(new ActionListener() { 
							 
							
							@SuppressWarnings("static-access")
							public void actionPerformed(ActionEvent e) { 
								File config = new File("/exandock/config/color.txt");
								FileWriter iconinfowriter = null;
								String configplace = "gray";
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
						red.addActionListener(new ActionListener() { 
							@SuppressWarnings("static-access")
							public void actionPerformed(ActionEvent e) { 
								File config = new File("/exandock/config/color.txt");
								FileWriter iconinfowriter = null;
								String configplace = "red";
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
						green.addActionListener(new ActionListener() { 
							@SuppressWarnings("static-access")
							public void actionPerformed(ActionEvent e) { 
								File config = new File("/exandock/config/color.txt");
								FileWriter iconinfowriter = null;
								String configplace = "green";
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
						blue.addActionListener(new ActionListener() { 
							@SuppressWarnings("static-access")
							public void actionPerformed(ActionEvent e) { 
								File config = new File("/exandock/config/color.txt");
								FileWriter iconinfowriter = null;
								String configplace = "blue";
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
						white.addActionListener(new ActionListener() { 
							@SuppressWarnings("static-access")
							public void actionPerformed(ActionEvent e) { 
								File config = new File("/exandock/config/color.txt");
								FileWriter iconinfowriter = null;
								String configplace = "white";
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
						yellow.addActionListener(new ActionListener() { 
							@SuppressWarnings("static-access")
							public void actionPerformed(ActionEvent e) { 
								File config = new File("/exandock/config/color.txt");
								FileWriter iconinfowriter = null;
								String configplace = "yellow";
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
						pink.addActionListener(new ActionListener() { 
							@SuppressWarnings("static-access")
							public void actionPerformed(ActionEvent e) { 
								File config = new File("/exandock/config/color.txt");
								FileWriter iconinfowriter = null;
								String configplace = "pink";
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
						purple.addActionListener(new ActionListener() { 
							@SuppressWarnings("static-access")
							public void actionPerformed(ActionEvent e) { 
								File config = new File("/exandock/config/color.txt");
								FileWriter iconinfowriter = null;
								String configplace = "purple";
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
						orange.addActionListener(new ActionListener() { 
							@SuppressWarnings("static-access")
							public void actionPerformed(ActionEvent e) { 
								File config = new File("/exandock/config/color.txt");
								FileWriter iconinfowriter = null;
								String configplace = "orange";
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
						
					
						
						
				  }
			});
			
			position.addActionListener(new ActionListener() { 
				 
				@SuppressWarnings("static-access")
				public void actionPerformed(ActionEvent e) { 
						System.out.println("[Debug] :  Positon button pressed");
						
						positionmenu.setTitle("Program Position");
						
						positionmenu.setSize(255, 224);
						
						JButton up = new JButton("Put ExanDock on the top");
						JButton down = new JButton("Put ExanDock down");
						JButton left = new JButton("Put ExanDock on the left");
						JButton right = new JButton("Put ExanDock on the right");
						
						up.setBounds(0, 0, 250, 50);
						down.setBounds(0, 50, 250, 50);
						left.setBounds(0, 100, 250, 50);
						right.setBounds(0, 150, 250, 50);
						
						up.setFocusPainted(false);
						down.setFocusPainted(false);
						left.setFocusPainted(false);
						right.setFocusPainted(false);
						
						if (colorloc.equals("right") ){
							positionmenu.setLocation((width - 850),(height / 2) - 340);
						}else {
							
							positionmenu.setLocation(590,(height / 2) - 340);
							
						}
						
						positionmenu.add(up);
						positionmenu.add(down);
						positionmenu.add(left);
						positionmenu.add(right);
						
						positionmenu.setResizable(false);
						positionmenu.getContentPane().setLayout(null);
						positionmenu.setVisible(true);
						
						up.addActionListener(new ActionListener() { 
							public void actionPerformed(ActionEvent e) { 
								File config = new File("/exandock/config/config.txt");
								FileWriter iconinfowriter = null;
								String configplace = "up";
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
						
						down.addActionListener(new ActionListener() { 
							public void actionPerformed(ActionEvent e) { 
								File config = new File("/exandock/config/config.txt");
								FileWriter iconinfowriter = null;
								String configplace = "down";
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
						
						left.addActionListener(new ActionListener() { 
							public void actionPerformed(ActionEvent e) { 
								File config = new File("/exandock/config/config.txt");
								FileWriter iconinfowriter = null;
								String configplace = "left";
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
							public void actionPerformed(ActionEvent e) { 
								File config = new File("/exandock/config/config.txt");
								FileWriter iconinfowriter = null;
								String configplace = "right";
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
						
						
						
						
				  }
			});
			
			
			delallicon.addActionListener(new ActionListener() { 

				public void actionPerformed(ActionEvent e) { 
					@SuppressWarnings("unused")
					String[] lists = IconDeleteSystem.icondel();
				  } 
				} );
			return null;
	}

	public static void style1 (){
	optionmenu.setType(javax.swing.JFrame.Type.UTILITY);
	colormenu.setType(javax.swing.JFrame.Type.UTILITY);
	positionmenu.setType(javax.swing.JFrame.Type.UTILITY);
	
}
}
