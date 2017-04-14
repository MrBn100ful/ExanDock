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
import javax.swing.JOptionPane;






public class Option {
	
	static JButton delallicon = new JButton("Deletes icons");
	static JButton closeexanlauncher = new JButton("Close ExanLauncher");
	
	static JButton left = new JButton("Put ExanLauncher on the left");
	static JButton right = new JButton("Put ExanLauncher on the right");
	
	static JButton color = new JButton("Change color of ExanLauncher");
	
	public static JFrame optionmenu = new JFrame();
	
	public static JFrame colormenu = new JFrame();
	
	public static JFrame deletemenu = new JFrame();

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
			
			optionmenu.setSize(255, 265);
			
			String configpath = "/config/config.txt";
			
			String configfile = null;
			try {
				configfile = new String(Files.readAllBytes(Paths.get(configpath)));
			} catch (IOException e2) {

				e2.printStackTrace();
			}
			
			String colorloc = configfile;
			
			if (configfile.equals("right") ){
				optionmenu.setLocation((width - 550),(height / 2) - 340);
			}else {
				
				optionmenu.setLocation(290,(height / 2) - 340);
				
			}
			
			optionmenu.setResizable(false);
			
			closeexanlauncher.setBackground(new Color(243, 243, 243, 150));
			delallicon.setBackground(new Color(243, 243, 243, 150));
			left.setBackground(new Color(243, 243, 243, 150));
			right.setBackground(new Color(243, 243, 243, 150));
			color.setBackground(new Color(243, 243, 243, 150));
			
			closeexanlauncher.setFocusPainted(false);
			delallicon.setFocusPainted(false);
			left.setFocusPainted(false);
			right.setFocusPainted(false);
			color.setFocusPainted(false);
			optionmenu.getContentPane().setLayout(null);
			
			optionmenu.setVisible(true);
			
		

			
			
			delallicon.setBounds(0, 0, 120, 90);
			closeexanlauncher.setBounds(120, 0, 129, 90);
			
			left.setBounds(0, 90, 250, 50);
			right.setBounds(0, 140, 250, 50);
			color.setBounds(0, 190, 250, 50);
			
			
			
			optionmenu.add(left);
			optionmenu.add(right);
			
			optionmenu.add(delallicon);
			optionmenu.add(closeexanlauncher);
			
			optionmenu.add(color);
			
			closeexanlauncher.addActionListener(new ActionListener() { 
				 
				public void actionPerformed(ActionEvent e) { 
						System.out.println("[Debug] :  Stop button pressed");
						
					int n = JOptionPane.showConfirmDialog(  
							optionmenu,
				                "Close ExanLauncher ?" ,
				                "Info ExanLauncher",
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
								File config = new File("/config/color.txt");
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
								File config = new File("/config/color.txt");
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
								File config = new File("/config/color.txt");
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
								File config = new File("/config/color.txt");
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
								File config = new File("/config/color.txt");
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
								File config = new File("/config/color.txt");
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
								File config = new File("/config/color.txt");
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
								File config = new File("/config/color.txt");
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
								File config = new File("/config/color.txt");
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
			
			left.addActionListener(new ActionListener() { 
				 
				@SuppressWarnings("static-access")
				public void actionPerformed(ActionEvent e) { 
						System.out.println("[Debug] :  Left button pressed");
						File config = new File("/config/config.txt");
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
				 
				@SuppressWarnings("static-access")
				public void actionPerformed(ActionEvent e) { 
						System.out.println("[Debug] :  Right button pressed");
						File config = new File("/config/config.txt");
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
			
			
			delallicon.addActionListener(new ActionListener() { 

				public void actionPerformed(ActionEvent e) { 
						System.out.println("[Debug] :  Deletes icons button pressed");
				
						deletemenu.setTitle("Program Delete icon");
						
						deletemenu.setSize(255, 578);
						
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
						
						if (colorloc.equals("right") ){
							colormenu.setLocation((width - 850),(height / 2) - 340);
						}else {
							
							colormenu.setLocation(590,(height / 2) - 340);
							
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

								File directory = new File("/icons/icon1/");

								
									try {
										delete(directory);
									} catch (IOException e2) {

										e2.printStackTrace();
									}
								
								File dir = new File("/icons/icon2");
				                File newName = new File("icons/icon1");
								dir.renameTo(newName);
								
								File dir3 = new File("/icons/icon3");
				                File newName3 = new File("icons/icon2");
				                dir3.renameTo(newName3);
								
								File dir4 = new File("/icons/icon4");
				                File newName4 = new File("icons/icon3");
				                dir4.renameTo(newName4);
								
								File dir5 = new File("/icons/icon5");
				                File newName5 = new File("icons/icon4");
				                dir5.renameTo(newName5);
								
								File dir6 = new File("/icons/icon6");
				                File newName6 = new File("icons/icon5");
				                dir6.renameTo(newName6);
								
								File dir7 = new File("/icons/icon7");
				                File newName7 = new File("icons/icon6");
				                dir7.renameTo(newName7);
								
								File dir8 = new File("/icons/icon8");
				                File newName8 = new File("icons/icon7");
				                dir8.renameTo(newName8);
								
								File dir9 = new File("/icons/icon9");
				                File newName9 = new File("icons/icon8");
				                dir9.renameTo(newName9);
								
								File dir10 = new File("/icons/icon10");
				                File newName10 = new File("icons/icon9");
				                dir10.renameTo(newName10);
								
				                new File("/icons/icon10/").mkdirs();
				                
				                File config = new File("/config/iconinfo.txt");
								FileWriter iconinfowriter = null;
								String configplace = "9";
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
						
						icon2.addActionListener(new ActionListener() { 
							 
							@SuppressWarnings("static-access")
							public void actionPerformed(ActionEvent e) { 
								File directory = new File("/icons/icon2/");

								try {
									delete(directory);
								} catch (IOException e1) {
									e1.printStackTrace();
								}
								
								File dir3 = new File("/icons/icon3");
				                File newName3 = new File("icons/icon2");
				                dir3.renameTo(newName3);
								
								File dir4 = new File("/icons/icon4");
				                File newName4 = new File("icons/icon3");
				                dir4.renameTo(newName4);
								
								File dir5 = new File("/icons/icon5");
				                File newName5 = new File("icons/icon4");
				                dir5.renameTo(newName5);
								
								File dir6 = new File("/icons/icon6");
				                File newName6 = new File("icons/icon5");
				                dir6.renameTo(newName6);
								
								File dir7 = new File("/icons/icon7");
				                File newName7 = new File("icons/icon6");
				                dir7.renameTo(newName7);
								
								File dir8 = new File("/icons/icon8");
				                File newName8 = new File("icons/icon7");
				                dir8.renameTo(newName8);
								
								File dir9 = new File("/icons/icon9");
				                File newName9 = new File("icons/icon8");
				                dir9.renameTo(newName9);
								
								File dir10 = new File("/icons/icon10");
				                File newName10 = new File("icons/icon9");
				                dir10.renameTo(newName10);
								
				                
				                new File("/icons/icon10/").mkdirs();
				                
				                File config = new File("/config/iconinfo.txt");
								FileWriter iconinfowriter = null;
								String configplace = "9";
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
						
						icon3.addActionListener(new ActionListener() { 
							 
							@SuppressWarnings("static-access")
							public void actionPerformed(ActionEvent e) { 
								File directory = new File("/icons/icon3/");

								try {
									delete(directory);
								} catch (IOException e1) {
									e1.printStackTrace();
								}
								
								File dir4 = new File("/icons/icon4");
				                File newName4 = new File("icons/icon3");
				                dir4.renameTo(newName4);
								
								File dir5 = new File("/icons/icon5");
				                File newName5 = new File("icons/icon4");
				                dir5.renameTo(newName5);
								
								File dir6 = new File("/icons/icon6");
				                File newName6 = new File("icons/icon5");
				                dir6.renameTo(newName6);
								
								File dir7 = new File("/icons/icon7");
				                File newName7 = new File("icons/icon6");
				                dir7.renameTo(newName7);
								
								File dir8 = new File("/icons/icon8");
				                File newName8 = new File("icons/icon7");
				                dir8.renameTo(newName8);
								
								File dir9 = new File("/icons/icon9");
				                File newName9 = new File("icons/icon8");
				                dir9.renameTo(newName9);
								
								File dir10 = new File("/icons/icon10");
				                File newName10 = new File("icons/icon9");
				                dir10.renameTo(newName10);
								
				                new File("/icons/icon10/").mkdirs();
				                
				                File config = new File("/config/iconinfo.txt");
								FileWriter iconinfowriter = null;
								String configplace = "9";
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
						
						icon4.addActionListener(new ActionListener() { 
							 
							@SuppressWarnings("static-access")
							public void actionPerformed(ActionEvent e) { 
								File directory = new File("/icons/icon4/");

								try {
									delete(directory);
								} catch (IOException e1) {
									e1.printStackTrace();
								}
								
								File dir5 = new File("/icons/icon5");
				                File newName5 = new File("icons/icon4");
				                dir5.renameTo(newName5);
								
								File dir6 = new File("/icons/icon6");
				                File newName6 = new File("icons/icon5");
				                dir6.renameTo(newName6);
								
								File dir7 = new File("/icons/icon7");
				                File newName7 = new File("icons/icon6");
				                dir7.renameTo(newName7);
								
								File dir8 = new File("/icons/icon8");
				                File newName8 = new File("icons/icon7");
				                dir8.renameTo(newName8);
								
								File dir9 = new File("/icons/icon9");
				                File newName9 = new File("icons/icon8");
				                dir9.renameTo(newName9);
								
								File dir10 = new File("/icons/icon10");
				                File newName10 = new File("icons/icon9");
				                dir10.renameTo(newName10);
								
				                new File("/icons/icon10/").mkdirs();
				                
				                File config = new File("/config/iconinfo.txt");
								FileWriter iconinfowriter = null;
								String configplace = "9";
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
						
						icon5.addActionListener(new ActionListener() { 
							 
							@SuppressWarnings("static-access")
							public void actionPerformed(ActionEvent e) { 
								File directory = new File("/icons/icon5/");

								try {
									delete(directory);
								} catch (IOException e1) {
									e1.printStackTrace();
								}

								
								File dir6 = new File("/icons/icon6");
				                File newName6 = new File("icons/icon5");
				                dir6.renameTo(newName6);
								
								File dir7 = new File("/icons/icon7");
				                File newName7 = new File("icons/icon6");
				                dir7.renameTo(newName7);
								
								File dir8 = new File("/icons/icon8");
				                File newName8 = new File("icons/icon7");
				                dir8.renameTo(newName8);
								
								File dir9 = new File("/icons/icon9");
				                File newName9 = new File("icons/icon8");
				                dir9.renameTo(newName9);
								
								File dir10 = new File("/icons/icon10");
				                File newName10 = new File("icons/icon9");
				                dir10.renameTo(newName10);
								
				                new File("/icons/icon10/").mkdirs();
				                
				                File config = new File("/config/iconinfo.txt");
								FileWriter iconinfowriter = null;
								String configplace = "9";
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
						
						icon6.addActionListener(new ActionListener() { 
							 
							@SuppressWarnings("static-access")
							public void actionPerformed(ActionEvent e) { 
								File directory = new File("/icons/icon6/");

								try {
									delete(directory);
								} catch (IOException e1) {
									e1.printStackTrace();
								}
								
								File dir7 = new File("/icons/icon7");
				                File newName7 = new File("icons/icon6");
				                dir7.renameTo(newName7);
								
								File dir8 = new File("/icons/icon8");
				                File newName8 = new File("icons/icon7");
				                dir8.renameTo(newName8);
								
								File dir9 = new File("/icons/icon9");
				                File newName9 = new File("icons/icon8");
				                dir9.renameTo(newName9);
								
								File dir10 = new File("/icons/icon10");
				                File newName10 = new File("icons/icon9");
				                dir10.renameTo(newName10);
								
				                new File("/icons/icon10/").mkdirs();
				                
				                File config = new File("/config/iconinfo.txt");
								FileWriter iconinfowriter = null;
								String configplace = "9";
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
						
						icon7.addActionListener(new ActionListener() { 
							 
							@SuppressWarnings("static-access")
							public void actionPerformed(ActionEvent e) { 
								File directory = new File("/icons/icon7/");

								try {
									delete(directory);
								} catch (IOException e1) {
									e1.printStackTrace();
								}
								
								File dir8 = new File("/icons/icon8");
				                File newName8 = new File("icons/icon7");
				                dir8.renameTo(newName8);
								
								File dir9 = new File("/icons/icon9");
				                File newName9 = new File("icons/icon8");
				                dir9.renameTo(newName9);
								
								File dir10 = new File("/icons/icon10");
				                File newName10 = new File("icons/icon9");
				                dir10.renameTo(newName10);
								
				                new File("/icons/icon10/").mkdirs();
				                
				                File config = new File("/config/iconinfo.txt");
								FileWriter iconinfowriter = null;
								String configplace = "9";
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
						
						icon8.addActionListener(new ActionListener() { 
							 
							@SuppressWarnings("static-access")
							public void actionPerformed(ActionEvent e) { 
								File directory = new File("/icons/icon8/");

								try {
									delete(directory);
								} catch (IOException e1) {
									e1.printStackTrace();
								}
								
								File dir9 = new File("/icons/icon9");
				                File newName9 = new File("icons/icon8");
				                dir9.renameTo(newName9);
								
								File dir10 = new File("/icons/icon10");
				                File newName10 = new File("icons/icon9");
				                dir10.renameTo(newName10);
								
				                new File("/icons/icon10/").mkdirs();
				                
				                File config = new File("/config/iconinfo.txt");
								FileWriter iconinfowriter = null;
								String configplace = "9";
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
						
						icon9.addActionListener(new ActionListener() { 
							 
							@SuppressWarnings("static-access")
							public void actionPerformed(ActionEvent e) { 
								File directory = new File("/icons/icon9/");

								try {
									delete(directory);
								} catch (IOException e1) {
									e1.printStackTrace();
								}
								
								File dir10 = new File("/icons/icon10");
				                File newName10 = new File("icons/icon9");
				                dir10.renameTo(newName10);
								
				                new File("/icons/icon10/").mkdirs();
				                
				                File config = new File("/config/iconinfo.txt");
								FileWriter iconinfowriter = null;
								String configplace = "9";
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
						
						icon10.addActionListener(new ActionListener() { 
							 
							@SuppressWarnings("static-access")
							public void actionPerformed(ActionEvent e) { 
								File directory = new File("/icons/icon10/");

								try {
									delete(directory);
								} catch (IOException e1) {
									e1.printStackTrace();
								}
								
				                new File("/icons/icon10/").mkdirs();
				                
				                File config = new File("/config/iconinfo.txt");
								FileWriter iconinfowriter = null;
								String configplace = "9";
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
						
						iconall.addActionListener(new ActionListener() { 
							 
							@SuppressWarnings("static-access")
							public void actionPerformed(ActionEvent e) { 
								while (var < 11) {
									File file = new File("/icons/icon" + var + "/icon.txt");
									file.delete();
									
									File file2 = new File("/icons/icon" + var + "/icon.png");
									file2.delete();
									
									File file2d = new File("/config/debug.txt");
									file2d.delete();
									
									File filed = new File("/icons/iconinfo.txt");
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
						});
						

				  } 
				} );
			return null;
	}
public static void style1 (){
	optionmenu.setType(javax.swing.JFrame.Type.UTILITY);
	colormenu.setType(javax.swing.JFrame.Type.UTILITY);
	deletemenu.setType(javax.swing.JFrame.Type.UTILITY);
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
}
