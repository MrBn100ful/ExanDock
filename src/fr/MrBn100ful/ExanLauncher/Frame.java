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

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.WinDef.HWND;

import fr.MrBn100ful.ButtonAPI.ButtonAPI;
import fr.MrBn100ful.ButtonAPI.event.ButtonAPIEvent;
import fr.MrBn100ful.ButtonAPI.event.ButtonAPIEventListener;
import fr.MrBn100ful.ButtonAPI.textured.STexturedButton;
import fr.MrBn100ful.ExanLauncher.Blurred.Dwmapi;


@SuppressWarnings("serial")
public class Frame extends JPanel implements ButtonAPIEventListener {
	private STexturedButton start = new STexturedButton(ButtonAPI.getResource("list2.png"));
	private STexturedButton restart = new STexturedButton(ButtonAPI.getResource("restart.png"));
	private STexturedButton internet = new STexturedButton(ButtonAPI.getResource("internet.png"));
	private STexturedButton multimedia = new STexturedButton(ButtonAPI.getResource("multimedia.png"));
	private STexturedButton office = new STexturedButton(ButtonAPI.getResource("office.png"));
	private STexturedButton tools = new STexturedButton(ButtonAPI.getResource("tools.png"));
	private STexturedButton other = new STexturedButton(ButtonAPI.getResource("other.png"));
	private STexturedButton stop = new STexturedButton(ButtonAPI.getResource("stop.png"));
	private STexturedButton info = new STexturedButton(ButtonAPI.getResource("info.png"));
	
	
	
	public boolean ProgMenuOpen = false;
	public boolean ProgMenuCreate = false;
	
	public boolean InfoOpen = false;
	public boolean InfoCreate = false;
	
	public JFrame programemenu = new JFrame();
	
	public JFrame infomenu = new JFrame();
	
	public JFrame programestyle = new JFrame();
	Shutdown shutdown = new Shutdown();
	GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	int width = gd.getDisplayMode().getWidth();
	int height = gd.getDisplayMode().getHeight();

	public Frame() {
		
		programemenu.setUndecorated(true);
		programestyle.setUndecorated(true);
		this.setLayout(null);
		start.setBounds(0, 0);
		start.addEventListener(this);
		this.add(start);
		
		

	}

	@Override
	public void onEvent(ButtonAPIEvent e) {
		if (e.getSource() == start) {
			System.out.println("[Debug] :  start button press");

			if (ProgMenuOpen == false) {
				if (ProgMenuCreate == false) {
					
					programemenu.setTitle("ExanLauncher Dev Programe Menu");
					programemenu.setSize(200, (height));
					programemenu.setLocation((width - 260), -(height - 690));
					programemenu.setLayout(null);

					restart.setBounds(0, (height - 85));
					restart.addEventListener(this);
					programemenu.add(restart);

					stop.setBounds(0, (height - 170));
					stop.addEventListener(this);
					programemenu.add(stop);

					internet.setBounds(0, (height - 670));
					internet.addEventListener(this);
					programemenu.add(internet);
					
					
					info.setBounds(75, (height - 685));
					info.addEventListener(this);
					programemenu.add(info);
					

					multimedia.setBounds(0, (height - 570));
					multimedia.addEventListener(this);
					programemenu.add(multimedia);

					office.setBounds(0, (height - 470));
					office.addEventListener(this);
					programemenu.add(office);

					tools.setBounds(0, (height - 370));
					tools.addEventListener(this);
					programemenu.add(tools);

					other.setBounds(0, (height - 270));
					other.addEventListener(this);
					programemenu.add(other);

					programemenu.setAlwaysOnTop(true);
					programemenu.setResizable(false);
					programemenu.setBackground(new Color(243, 243, 243, 150));
					

					programestyle.setTitle("ExanLauncher Dev Programe Style");
					programestyle.setSize(2, height);
					programestyle.setLocation((width - 260), -(height - 690));
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

		if (e.getSource() == stop) {
			System.out.println("[Debug] :  stop button press");
			try {
				shutdown.shutdown();
			} catch (RuntimeException e1) {

				e1.printStackTrace();
			} catch (IOException e1) {

				e1.printStackTrace();
			}
		}
		if (e.getSource() == restart) {
			System.out.println("[Debug] :  restart button press");
			try {
				shutdown.restart();
			} catch (RuntimeException e1) {

				e1.printStackTrace();
			} catch (IOException e1) {

				e1.printStackTrace();
			}
		}
		
		if(e.getSource() == info)
		{
			System.out.println("[Debug] :  info button press");
			JOptionPane.showMessageDialog(this, "                     Create by MrBn100ful"
					+ "\n"
					+ "                 Version : 0.0 Copper Navy"
					+ "\n"
					+ "                                  2016"
					+ "\n"
					+ "https://github.com/MrBn100ful/ExanLauncher", "About ExanLauncher",
					JOptionPane.INFORMATION_MESSAGE);
			
			
		}
	}




}
