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
	
	static JButton color = new JButton("Change color of ExanLauncher");
	
	public static JFrame optionmenu = new JFrame();
	
	public static JFrame colormenu = new JFrame();

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
			
		colormenu.setType(javax.swing.JFrame.Type.UTILITY);
		optionmenu.setTitle("Program Options");
			
			optionmenu.setSize(255, 265);
			
			String configpath = "config.txt";
			
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
						System.exit(0);
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
								File config = new File("color.txt");
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
								File config = new File("color.txt");
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
								File config = new File("color.txt");
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
								File config = new File("color.txt");
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
								File config = new File("color.txt");
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
								File config = new File("color.txt");
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
								File config = new File("color.txt");
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
								File config = new File("color.txt");
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
								File config = new File("color.txt");
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
						File config = new File("config.txt");
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
						File config = new File("config.txt");
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
