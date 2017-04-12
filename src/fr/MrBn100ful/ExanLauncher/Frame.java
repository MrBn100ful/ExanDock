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
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.WinDef.HWND;

import fr.MrBn100ful.ButtonAPI.ButtonAPI;
import fr.MrBn100ful.ButtonAPI.event.ButtonAPIEvent;
import fr.MrBn100ful.ButtonAPI.event.ButtonAPIEventListener;
import fr.MrBn100ful.ButtonAPI.textured.STexturedButton;
import fr.MrBn100ful.ExanLauncher.Blurred.Dwmapi;
import fr.MrBn100ful.ExanLauncher.Option;;

@SuppressWarnings("serial")
public class Frame extends JPanel implements ButtonAPIEventListener {
	private STexturedButton icon = new STexturedButton(ButtonAPI.getResource("icon.png"));
	private STexturedButton about = new STexturedButton(ButtonAPI.getResource("about.png"));
	private STexturedButton options = new STexturedButton(ButtonAPI.getResource("options.png"));
	
	private STexturedButton whiteicon = new STexturedButton(ButtonAPI.getResource("whiteicon.png"));
	private STexturedButton whiteabout = new STexturedButton(ButtonAPI.getResource("whiteabout.png"));
	private STexturedButton whiteoptions = new STexturedButton(ButtonAPI.getResource("whiteoptions.png"));

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
		
		String colorpath = "color.txt";
		
		String colorfile = null;
		try {
			colorfile = new String(Files.readAllBytes(Paths.get(colorpath)));
		} catch (IOException e2) {
			System.out.println("[Debug] :  Error");
			e2.printStackTrace();
		}
		
		if (colorfile.equals("gray")){
			
			this.add(icon);
			icon.setBounds(0, 0);
			icon.addEventListener(this);
		
		}else if (colorfile.equals("red")) {
			
			this.add(whiteicon);
			whiteicon.setBounds(0, 0);
			whiteicon.addEventListener(this);
			
			
		}else if (colorfile.equals("green")) {
			
			this.add(whiteicon);
			whiteicon.setBounds(0, 0);
			whiteicon.addEventListener(this);
		
		}else if (colorfile.equals("blue")) {
			
			this.add(whiteicon);
			whiteicon.setBounds(0, 0);
			whiteicon.addEventListener(this);
			
		
		}else if (colorfile.equals("white")) {
			
			this.add(icon);
			icon.setBounds(0, 0);
			icon.addEventListener(this);
		}else if (colorfile.equals("yellow")) {
			this.add(whiteicon);
			whiteicon.setBounds(0, 0);
			whiteicon.addEventListener(this);
			
		
		}else if (colorfile.equals("pink")) {
			
			this.add(whiteicon);
			whiteicon.setBounds(0, 0);
			whiteicon.addEventListener(this);
		
		}else if (colorfile.equals("purple")) {
			this.add(whiteicon);
			whiteicon.setBounds(0, 0);
			whiteicon.addEventListener(this);
			
		
		}else if (colorfile.equals("orange")) {
			
			this.add(whiteicon);
			whiteicon.setBounds(0, 0);
			whiteicon.addEventListener(this);
		
		}
		programestyle.setUndecorated(true);
		programemenu.setUndecorated(true);
		
		this.setLayout(null);
		
		
		
		programestyle.setType(javax.swing.JFrame.Type.UTILITY);
		programemenu.setType(javax.swing.JFrame.Type.UTILITY);
	
	

	}

	@Override
	public void onEvent(ButtonAPIEvent e) {
		
		String colorpath = "color.txt";
		
		String colorfile = null;
		try {
			colorfile = new String(Files.readAllBytes(Paths.get(colorpath)));
		} catch (IOException e2) {
			System.out.println("[Debug] :  Error");
			e2.printStackTrace();
		}
		
		String configpath = "config.txt";
		
		String configfile = null;
		try {
			configfile = new String(Files.readAllBytes(Paths.get(configpath)));
		} catch (IOException e1) {
			System.out.println("[Debug] :  Error");
			e1.printStackTrace();
		}
		
		if ((e.getSource() == icon ) || (e.getSource() == whiteicon )) {
			System.out.println("[Debug] :  start button press");

			if (ProgMenuOpen == false) {
				if (ProgMenuCreate == false) {
					
					
					if (configfile.equals("right") ){
						programemenu.setLocation((width - 260),(height / 2) - 340);
						programestyle.setLocation((width - 260),(height / 2) - 340);
					}else {
						
						programemenu.setLocation(60, (height / 2) - 340);
						programestyle.setLocation(260, (height / 2) - 340);
						
					}
					

					programemenu.setTitle("ExanLauncher Program menu");
					programemenu.setSize(200, 60);
					
					programemenu.setLayout(null);

					
					
					

					programemenu.setAlwaysOnTop(true);
					programemenu.setResizable(false);

					
					if (colorfile.equals("gray")){
						
						programemenu.setBackground(new Color(243, 243, 243, 150));
						about.setBounds(125,20);
						about.addEventListener(this);
						programemenu.add(about);

						
						
						options.setBounds(20,20);
						options.addEventListener(this);
						programemenu.add(options);
					
					}else if (colorfile.equals("red")) {
					
						programemenu.setBackground(new Color(246, 44, 44, 150));
						whiteabout.setBounds(125,20);
						whiteabout.addEventListener(this);
						programemenu.add(whiteabout);

						
						
						whiteoptions.setBounds(20,20);
						whiteoptions.addEventListener(this);
						programemenu.add(whiteoptions);
						
					}else if (colorfile.equals("green")) {
						
						programemenu.setBackground(new Color(22, 205, 52, 150));
						whiteabout.setBounds(125,20);
						whiteabout.addEventListener(this);
						programemenu.add(whiteabout);

						
						
						whiteoptions.setBounds(20,20);
						whiteoptions.addEventListener(this);
						programemenu.add(whiteoptions);
					
					}else if (colorfile.equals("blue")) {
						
						programemenu.setBackground(new Color(26, 138, 212, 150));
						whiteabout.setBounds(125,20);
						whiteabout.addEventListener(this);
						programemenu.add(whiteabout);

						
						
						whiteoptions.setBounds(20,20);
						whiteoptions.addEventListener(this);
						programemenu.add(whiteoptions);
					
					}else if (colorfile.equals("white")) {
						
						programemenu.setBackground(new Color(255, 255, 255, 150));
						about.setBounds(125,20);
						about.addEventListener(this);
						programemenu.add(about);

						
						
						options.setBounds(20,20);
						options.addEventListener(this);
						programemenu.add(options);
					
					}else if (colorfile.equals("yellow")) {
						
						programemenu.setBackground(new Color(255, 230, 0, 150));
						whiteabout.setBounds(125,20);
						whiteabout.addEventListener(this);
						programemenu.add(whiteabout);

						
						
						whiteoptions.setBounds(20,20);
						whiteoptions.addEventListener(this);
						programemenu.add(whiteoptions);
					
					}else if (colorfile.equals("pink")) {
						
						programemenu.setBackground(new Color(235, 35, 195, 150));
						whiteabout.setBounds(125,20);
						whiteabout.addEventListener(this);
						programemenu.add(whiteabout);

						
						
						whiteoptions.setBounds(20,20);
						whiteoptions.addEventListener(this);
						programemenu.add(whiteoptions);
					
					}else if (colorfile.equals("purple")) {
						
						programemenu.setBackground(new Color(95, 35, 235, 150));
						whiteabout.setBounds(125,20);
						whiteabout.addEventListener(this);
						programemenu.add(whiteabout);

						
						
						whiteoptions.setBounds(20,20);
						whiteoptions.addEventListener(this);
						programemenu.add(whiteoptions);
					
					}else if (colorfile.equals("orange")) {
						
						programemenu.setBackground(new Color(235, 148, 35, 150));
						whiteabout.setBounds(125,20);
						whiteabout.addEventListener(this);
						programemenu.add(whiteabout);

						
						
						whiteoptions.setBounds(20,20);
						whiteoptions.addEventListener(this);
						programemenu.add(whiteoptions);
					
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

		
		if((e.getSource() == about) ||(e.getSource() == whiteabout))
		{
			System.out.println("[Debug] :  Info button pressed");
			JOptionPane.showMessageDialog(this, "                      Create by MrBn100ful"
					+ "\n"
					+ "                 Version : 1.3.0  Steel Blizzard"
					+ "\n"
					+ "                                2016-2017"
					+ "\n"
					+ "https://github.com/MrBn100ful/ExanLauncher", "About ExanLauncher",
					JOptionPane.INFORMATION_MESSAGE);
			
		}
		if((e.getSource() == options) || (e.getSource() == whiteoptions))
		{
			System.out.println("[Debug] :  Option button pressed");
			@SuppressWarnings("unused")
			String[] lists = Option.Optionframe();
		}
	}




}
