package fr.MrBn100ful.ExanLauncher;

/**
 *  Here is the program menu and some event.
 *  
 * @author MrBn100ful
 * 
 */


import java.awt.Color;
import java.io.IOException;

import javax.swing.JFrame;
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
	private STexturedButton start = new STexturedButton(ButtonAPI.getResource("list.png"));
	private STexturedButton restart = new STexturedButton(ButtonAPI.getResource("restart.png"));
	private STexturedButton internet = new STexturedButton(ButtonAPI.getResource("internet.png"));
	private STexturedButton multimedia = new STexturedButton(ButtonAPI.getResource("multimedia.png"));
	private STexturedButton office = new STexturedButton(ButtonAPI.getResource("office.png"));
	private STexturedButton tools = new STexturedButton(ButtonAPI.getResource("tools.png"));
	private STexturedButton other = new STexturedButton(ButtonAPI.getResource("other.png"));
	private STexturedButton stop = new STexturedButton(ButtonAPI.getResource("stop.png"));
	public boolean ProgMenuOpen = false;
	public boolean ProgMenuCreate = false;
	public JFrame programemenu = new JFrame();
	public JFrame programestyle = new JFrame();

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
			System.out.println("Debug start button press");

			if (ProgMenuOpen == false) {
				if (ProgMenuCreate == false) {

					programemenu.setTitle("ExanLauncher Dev Programe Menu");
					programemenu.setSize(200, 1080);
					programemenu.setLocation(1660, 0);
					programemenu.setLayout(null);

					restart.setBounds(0, 980);
					restart.addEventListener(this);
					programemenu.add(restart);

					stop.setBounds(0, 900);
					stop.addEventListener(this);
					programemenu.add(stop);

					internet.setBounds(0, 100);
					internet.addEventListener(this);
					programemenu.add(internet);

					multimedia.setBounds(0, 250);
					multimedia.addEventListener(this);
					programemenu.add(multimedia);

					office.setBounds(0, 400);
					office.addEventListener(this);
					programemenu.add(office);

					tools.setBounds(0, 550);
					tools.addEventListener(this);
					programemenu.add(tools);

					other.setBounds(0, 700);
					other.addEventListener(this);
					programemenu.add(other);

					programemenu.setAlwaysOnTop(true);
					programemenu.setResizable(false);
					programemenu.setBackground(new Color(243, 243, 243, 185));
					programemenu.setVisible(true);

					programestyle.setTitle("ExanLauncher Dev Programe Style");
					programestyle.setSize(2, 1080);
					programestyle.setLocation(1660, 0);
					programestyle.setLayout(null);
					programestyle.setAlwaysOnTop(true);
					programestyle.setResizable(false);
					programestyle.setBackground(new Color(243, 243, 243, 185));
					programestyle.setVisible(true);

					ProgMenuOpen = true;
					ProgMenuCreate = false;

					HWND hwnd = new HWND(Native.getWindowPointer(programemenu));
					Dwmapi.DWM_BLURBEHIND pBlurBehind = new Dwmapi.DWM_BLURBEHIND();
					pBlurBehind.dwFlags = Dwmapi.DWM_BB_ENABLE;
					pBlurBehind.fEnable = true;
					pBlurBehind.fTransitionOnMaximized = false;
					Dwmapi.INSTANCE.DwmEnableBlurBehindWindow(hwnd, pBlurBehind);

				} else {
					programemenu.setVisible(true);
					programemenu.setUndecorated(true);

					programestyle.setVisible(true);
					programestyle.setUndecorated(true);

					ProgMenuOpen = true;
				}

			} else if (ProgMenuOpen == true) {
				programemenu.setVisible(false);
				programestyle.setVisible(false);

				ProgMenuOpen = false;

			}

		}

		if (e.getSource() == stop) {
			System.out.println("Debug stop button press");
			try {
				shutdown();
			} catch (RuntimeException e1) {

				e1.printStackTrace();
			} catch (IOException e1) {

				e1.printStackTrace();
			}
		}
		if (e.getSource() == restart) {
			System.out.println("Debug restart button press");

		}

	}

	public static void shutdown() throws RuntimeException, IOException {
		String shutdownCommand;
		String operatingSystem = System.getProperty("os.name");

		if ("Linux".equals(operatingSystem) || "Mac OS X".equals(operatingSystem)) {
			shutdownCommand = "shutdown -h now";
		} else if ("Windows".equals(operatingSystem)) {
			shutdownCommand = "shutdown.exe -s -t 0";
		} else {
			throw new RuntimeException("Unsupported operating system.");
		}

		Runtime.getRuntime().exec(shutdownCommand);
		System.exit(0);
	}

	public static void restart() throws RuntimeException, IOException {
		String shutdownCommand;
		String operatingSystem = System.getProperty("os.name");

		if ("Linux".equals(operatingSystem) || "Mac OS X".equals(operatingSystem)) {
			shutdownCommand = "shutdown -r now";
		} else if ("Windows".equals(operatingSystem)) {
			shutdownCommand = "shutdown.exe -r -t 0";
		} else {
			throw new RuntimeException("Unsupported operating system.");
		}

		Runtime.getRuntime().exec(shutdownCommand);
		System.exit(0);
	}

}
