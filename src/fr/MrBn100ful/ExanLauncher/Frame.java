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
	private STexturedButton option = new STexturedButton(ButtonAPI.getResource("option.png"));
	
	

	
	
	
	
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

	public Frame() {
		
		programemenu.setUndecorated(true);
		programestyle.setUndecorated(true);
		this.setLayout(null);
		icon.setBounds(0, 0);
		icon.addEventListener(this);
		this.add(icon);
		programemenu.setType(javax.swing.JFrame.Type.UTILITY);
		programestyle.setType(javax.swing.JFrame.Type.UTILITY);

	}

	@Override
	public void onEvent(ButtonAPIEvent e) {
		if (e.getSource() == icon) {
			System.out.println("[Debug] :  start button press");

			if (ProgMenuOpen == false) {
				if (ProgMenuCreate == false) {
					
					

					programemenu.setTitle("ExanLauncher Dev Programe Menu");
					programemenu.setSize(200, 60);
					programemenu.setLocation((width - 260),(height - 880));
					programemenu.setLayout(null);

					
					about.setBounds(125,20);
					about.addEventListener(this);
					programemenu.add(about);

					
					
					option.setBounds(20,20);
					option.addEventListener(this);
					programemenu.add(option);
					

					programemenu.setAlwaysOnTop(true);
					programemenu.setResizable(false);
					programemenu.setBackground(new Color(243, 243, 243, 150));
					
					
					programestyle.setTitle("ExanLauncher Dev Programe Style");
					programestyle.setSize(2, 60);
					programestyle.setLocation((width - 260),(height - 880));
					programestyle.setLayout(null);
					programestyle.setAlwaysOnTop(true);
					programestyle.setResizable(false);
					programestyle.setBackground(new Color(243, 243, 243, 185));
					programestyle.setVisible(true);
					programemenu.setVisible(true);
					ProgMenuOpen = true;
					ProgMenuCreate = false;

					HWND hwnd = new HWND(Native.getWindowPointer(programemenu));
					Dwmapi.DWM_BLURBEHIND pBlurBehind = new Dwmapi.DWM_BLURBEHIND();
					pBlurBehind.dwFlags = Dwmapi.DWM_BB_ENABLE;
					pBlurBehind.fEnable = true;
					pBlurBehind.fTransitionOnMaximized = false;
					Dwmapi.INSTANCE.DwmEnableBlurBehindWindow(hwnd, pBlurBehind);

				} else {
					
					programemenu.setUndecorated(true);

					programestyle.setVisible(true);
					programestyle.setUndecorated(true);
					programemenu.setVisible(true);

					ProgMenuOpen = true;
				}

			} else if (ProgMenuOpen == true) {
				programemenu.setVisible(false);
				programestyle.setVisible(false);

				ProgMenuOpen = false;

			}

		}

		
		if(e.getSource() == about)
		{
			System.out.println("[Debug] :  info button press");
			JOptionPane.showMessageDialog(this, "                     Create by MrBn100ful"
					+ "\n"
					+ "                 Version : 1.0  Steel Blizzard"
					+ "\n"
					+ "                                2016-2017"
					+ "\n"
					+ "https://github.com/MrBn100ful/ExanLauncher", "About ExanLauncher",
					JOptionPane.INFORMATION_MESSAGE);
			
		}
		if(e.getSource() == option)
		{
			System.out.println("[Debug] :  option button press");
			@SuppressWarnings("unused")
			String[] lists = Option.Optionframe();
		}
	}




}
