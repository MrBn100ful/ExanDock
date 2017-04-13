package fr.MrBn100ful.ExanLauncher;



/**
 *  Here is the program menu and the event.
 *  
 * @author MrBn100ful
 * 
 */


import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.WinDef.HWND;

import fr.MrBn100ful.ExanLauncher.Blurred.Dwmapi;
import fr.MrBn100ful.ExanLauncher.Option;;

@SuppressWarnings("serial")
public class Frame extends JPanel  {

	
	java.net.URL iconurl = getClass().getResource("/resources/icon.png");
	
	public ImageIcon icon1 = new ImageIcon(iconurl);
    
	public JButton icon = new JButton(icon1);
	

	java.net.URL abouturl = getClass().getResource("/resources/about.png");
	
	public ImageIcon about1 = new ImageIcon(abouturl);
    
	public JButton about = new JButton(about1);
	
	
	java.net.URL optionsurl = getClass().getResource("/resources/options.png");
	
	public ImageIcon options1 = new ImageIcon(optionsurl);
    
	public JButton options = new JButton(options1);
	
	
	
	java.net.URL whiteiconurl = getClass().getResource("/resources/whiteicon.png");
	
	public ImageIcon whiteicon1 = new ImageIcon(whiteiconurl);
    
	public JButton whiteicon = new JButton(whiteicon1);
	

	
	java.net.URL whiteabouturl = getClass().getResource("/resources/whiteabout.png");
	
	public ImageIcon whiteabout1 = new ImageIcon(whiteabouturl);
    
	public JButton whiteabout = new JButton(whiteabout1);
	
	
	java.net.URL whiteoptionsurl = getClass().getResource("/resources/whiteoptions.png");
	
	public ImageIcon whiteoptions1 = new ImageIcon(whiteoptionsurl);
    
	public JButton whiteoptions = new JButton(whiteoptions1);
	
	
	public boolean ProgMenuOpen = false;
	public boolean ProgMenuCreate = false;
	public boolean InfoOpen = false;
	public boolean InfoCreate = false;
	
	public JFrame programemenu = new JFrame();
	
	public JFrame infomenu = new JFrame();

	public JFrame programestyle = new JFrame();
	
	public JTextArea iconnumber;
	

	Shutdown shutdown = new Shutdown();
	GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	int width = gd.getDisplayMode().getWidth();
	int height = gd.getDisplayMode().getHeight();

	private float floatnumber = (float) 1.1555;
	private float calc = width / floatnumber;
	
	
	
	int finalcalc = (int) calc ;
	
	
	
	public Frame() {
		
		icon.setBorder(null);
		icon.setOpaque(false);
		icon.setContentAreaFilled(false);
		icon.setBorderPainted(false);
		icon.setFocusPainted(false);
	      
		about.setBorder(null);
		about.setOpaque(false);
		about.setContentAreaFilled(false);
		about.setBorderPainted(false);
		about.setFocusPainted(false);
	      
		options.setBorder(null);
		options.setOpaque(false);
		options.setContentAreaFilled(false);
		options.setBorderPainted(false);
		options.setFocusPainted(false);
	      
		whiteicon.setBorder(null);
		whiteicon.setOpaque(false);
		whiteicon.setContentAreaFilled(false);
		whiteicon.setBorderPainted(false);
		whiteicon.setFocusPainted(false);
	      
		whiteabout.setBorder(null);
		whiteabout.setOpaque(false);
		whiteabout.setContentAreaFilled(false);
		whiteabout.setBorderPainted(false);
		whiteabout.setFocusPainted(false);
	      
		whiteoptions.setBorder(null);
		whiteoptions.setOpaque(false);
		whiteoptions.setContentAreaFilled(false);
		whiteoptions.setBorderPainted(false);
		whiteoptions.setFocusPainted(false);
		
		
		
		String colorpath = "color.txt";
		
		String colorfile = null;
		try {
			colorfile = new String(Files.readAllBytes(Paths.get(colorpath)));
		} catch (IOException e2) {
			System.out.println("[Debug] :  Error");
			e2.printStackTrace();
		}
		

		icon.setFocusable(false);
		whiteicon.setFocusable(false);
		whiteicon.setBounds(0, 0, 60, 60);
		icon.setBounds(0, 0, 60, 60);
		
		if (colorfile.equals("gray")){
			
			this.add(whiteicon);
			
		
		}else if (colorfile.equals("red")) {
			
			this.add(whiteicon);


		}else if (colorfile.equals("green")) {
			
			this.add(whiteicon);


		}else if (colorfile.equals("blue")) {
			
			this.add(whiteicon);


		}else if (colorfile.equals("white")) {
			
			this.add(icon);
		

		}else if (colorfile.equals("yellow")) {
			this.add(whiteicon);


		}else if (colorfile.equals("pink")) {
			
			this.add(whiteicon);


		}else if (colorfile.equals("purple")) {
			this.add(whiteicon);


		}else if (colorfile.equals("orange")) {
			
			this.add(whiteicon);


		}
		programestyle.setUndecorated(true);
		programemenu.setUndecorated(true);
		
		this.setLayout(null);
		
		
		
		programestyle.setType(javax.swing.JFrame.Type.UTILITY);
		programemenu.setType(javax.swing.JFrame.Type.UTILITY);
	
	
		
		String configpath = "config.txt";
		
		String configfile = null;
		try {
			configfile = new String(Files.readAllBytes(Paths.get(configpath)));
		} catch (IOException e1) {
			System.out.println("[Debug] :  Error");
			e1.printStackTrace();
		}
		String configfilesafe = configfile;
		
		String colorfilesafe = colorfile;
		
		
		icon.addActionListener(new ActionListener() { 
			 
			public void actionPerformed(ActionEvent e) { 
				
				System.out.println("[Debug] :  start button press");

				if (ProgMenuOpen == false) {
					if (ProgMenuCreate == false) {
						
						
						if (configfilesafe.equals("right") ){
							programemenu.setLocation((width - 260),(height / 2) - 340);
							programestyle.setLocation((width - 260),(height / 2) - 340);
						}else {
							
							programemenu.setLocation(60, (height / 2) - 340);
							programestyle.setLocation(258, (height / 2) - 340);
							
						}
						
						programemenu.setTitle("ExanLauncher Program menu");
						programemenu.setSize(200, 60);
						
						programemenu.setLayout(null);

						programemenu.setAlwaysOnTop(true);
						programemenu.setResizable(false);

						about.setBounds(125 , 20, 52, 14);
						programemenu.add(about);
						options.setBounds(20,20, 58, 14);
						programemenu.add(options);
						
						if (colorfilesafe.equals("white")) {
							
							programemenu.setBackground(new Color(255, 255, 255, 200));
						
						}
						
						
						programestyle.setTitle("ExanLauncher Program style");
						programestyle.setSize(2, 60);
						
						programestyle.setLayout(null);
						programestyle.setAlwaysOnTop(true);
						programestyle.setResizable(false);
						programestyle.setBackground(new Color(243, 243, 243, 185));
						programestyle.setVisible(true);
						programemenu.setVisible(true);
						ProgMenuOpen = true;
						ProgMenuCreate = false;

						String sysProps = System.getProperty("os.name");
						
						if (sysProps.equals("Windows 7")){
							
							HWND hwnd = new HWND(Native.getWindowPointer(programemenu));
							Dwmapi.DWM_BLURBEHIND pBlurBehind = new Dwmapi.DWM_BLURBEHIND();
							pBlurBehind.dwFlags = Dwmapi.DWM_BB_ENABLE;
							pBlurBehind.fEnable = true;
							pBlurBehind.fTransitionOnMaximized = false;
							Dwmapi.INSTANCE.DwmEnableBlurBehindWindow(hwnd, pBlurBehind);
						}

					} else {
						
						programemenu.setUndecorated(true);

						programestyle.setVisible(true);
						programestyle.setUndecorated(true);
						programemenu.setVisible(true);

						ProgMenuOpen = true;
					}

				} else if (ProgMenuOpen == true) {
				
					programestyle.setVisible(false);
					programemenu.setVisible(false);

					ProgMenuOpen = false;

				}

			}
		});
		
		
		whiteicon.addActionListener(new ActionListener() { 
			 
			public void actionPerformed(ActionEvent e) { 
				
				System.out.println("[Debug] :  start button press");

				if (ProgMenuOpen == false) {
					if (ProgMenuCreate == false) {
						
						
						if (configfilesafe.equals("right") ){
							programemenu.setLocation((width - 260),(height / 2) - 340);
							programestyle.setLocation((width - 260),(height / 2) - 340);
						}else {
							
							programemenu.setLocation(60, (height / 2) - 340);
							programestyle.setLocation(258, (height / 2) - 340);
							
						}
						

						programemenu.setTitle("ExanLauncher Program menu");
						programemenu.setSize(200, 60);
						
						programemenu.setLayout(null);

						
						
						

						programemenu.setAlwaysOnTop(true);
						programemenu.setResizable(false);
						whiteabout.setBounds(125 , 20, 52, 14);
						
						programemenu.add(whiteabout);
						whiteoptions.setBounds(20,20, 58, 14);
						programemenu.add(whiteoptions);
						
						
						 if (colorfilesafe.equals("red")) {
						
							programemenu.setBackground(new Color(246, 44, 44, 200));

							
						}else if (colorfilesafe.equals("green")) {
							
							programemenu.setBackground(new Color(22, 205, 52, 200));

						
						}else if (colorfilesafe.equals("blue")) {
							
							programemenu.setBackground(new Color(26, 138, 212, 200));

						
						}else if (colorfilesafe.equals("yellow")) {
							
							programemenu.setBackground(new Color(255, 230, 0, 200));

						
						}else if (colorfilesafe.equals("pink")) {
							
							programemenu.setBackground(new Color(235, 35, 195, 200));

						
						}else if (colorfilesafe.equals("purple")) {
							
							programemenu.setBackground(new Color(95, 35, 235, 200));

						
						}else if (colorfilesafe.equals("orange")) {
							
							programemenu.setBackground(new Color(235, 148, 35, 200));

						
						}else if (colorfilesafe.equals("gray")){
							
							programemenu.setBackground(new Color(91, 91, 91, 200));
					
						
						}
						
						
						programestyle.setTitle("ExanLauncher Program style");
						programestyle.setSize(2, 60);
						
						programestyle.setLayout(null);
						programestyle.setAlwaysOnTop(true);
						programestyle.setResizable(false);
						programestyle.setBackground(new Color(243, 243, 243, 185));
						programestyle.setVisible(true);
						programemenu.setVisible(true);
						ProgMenuOpen = true;
						ProgMenuCreate = false;

						String sysProps = System.getProperty("os.name");
						
						if (sysProps.equals("Windows 7")){
							
							HWND hwnd = new HWND(Native.getWindowPointer(programemenu));
							Dwmapi.DWM_BLURBEHIND pBlurBehind = new Dwmapi.DWM_BLURBEHIND();
							pBlurBehind.dwFlags = Dwmapi.DWM_BB_ENABLE;
							pBlurBehind.fEnable = true;
							pBlurBehind.fTransitionOnMaximized = false;
							Dwmapi.INSTANCE.DwmEnableBlurBehindWindow(hwnd, pBlurBehind);
						}

					} else {
						
						programemenu.setUndecorated(true);

						programestyle.setVisible(true);
						programestyle.setUndecorated(true);
						programemenu.setVisible(true);

						ProgMenuOpen = true;
					}

				} else if (ProgMenuOpen == true) {
				
					programestyle.setVisible(false);
					programemenu.setVisible(false);

					ProgMenuOpen = false;

				}

			}
		});
		
		
		
		whiteabout.addActionListener(new ActionListener() { 
			 
			public void actionPerformed(ActionEvent e) { 
				System.out.println("[Debug] :  Info button pressed");
				JOptionPane.showMessageDialog(programemenu, "                      Create by MrBn100ful"
						+ "\n"
						+ "                 Version : 1.3.1  Steel Blizzard"
						+ "\n"
						+ "                                2016-2017"
						+ "\n"
						+ "https://github.com/MrBn100ful/ExanLauncher", "About ExanLauncher",
						JOptionPane.INFORMATION_MESSAGE);
			  }
		});
		
		about.addActionListener(new ActionListener() { 
			 
			public void actionPerformed(ActionEvent e) { 
				System.out.println("[Debug] :  Info button pressed");
				JOptionPane.showMessageDialog(programemenu, "                      Create by MrBn100ful"
						+ "\n"
						+ "                 Version : 1.3.1  Steel Blizzard"
						+ "\n"
						+ "                                2016-2017"
						+ "\n"
						+ "https://github.com/MrBn100ful/ExanLauncher", "About ExanLauncher",
						JOptionPane.INFORMATION_MESSAGE);
			  }
		});

		
		whiteoptions.addActionListener(new ActionListener() { 
			 
			public void actionPerformed(ActionEvent e) { 
				System.out.println("[Debug] :  Option button pressed");
				@SuppressWarnings("unused")
				String[] lists = Option.Optionframe();
			  }
		});
		
		options.addActionListener(new ActionListener() { 
			 
			public void actionPerformed(ActionEvent e) { 
				System.out.println("[Debug] :  Option button pressed");
				@SuppressWarnings("unused")
				String[] lists = Option.Optionframe();
			  }
		});
		

	}
}
