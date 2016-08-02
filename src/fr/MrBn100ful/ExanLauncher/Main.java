package fr.MrBn100ful.ExanLauncher;
/**
 *  Main of the program.
 *  
 * @author MrBn100ful
 * 
 */




import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.dnd.DropTarget;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.UIManager;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.WinDef.HWND;

import fr.MrBn100ful.ButtonAPI.ButtonAPI;
import fr.MrBn100ful.ExanLauncher.Blurred.Dwmapi;


@SuppressWarnings("serial")
public class Main extends JFrame {
	@SuppressWarnings("unused")
	private static Main instance;
	@SuppressWarnings("unused")
	private Frame frame;
	public JTextArea clock;
	public JLabel dropicon;
	public JFrame style = new JFrame();
	public JFrame main = new JFrame();
	@SuppressWarnings("unused")
	private DragAndDropIcon DragAndDropIcon;


	@SuppressWarnings("resource")
	public Main(Component c) throws IOException {
		
		File iconinfo = new File("iconinfo.txt");
		System.out.println("Debug program launch");
		if(iconinfo.exists() && !iconinfo.isDirectory()) { 
			FileReader iconinforead = new FileReader("iconinfo.txt");
			int iconinfonumber = iconinforead.read();
			System.out.println("Debug " + (iconinfonumber - 1) + " icon create");
		}
		
		
		
		
		
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();
		
		main.setTitle("ExanLauncher Dev Main");
		main.setSize(60, height);
		main.setDefaultCloseOperation(EXIT_ON_CLOSE);
		main.setLocation((width - 60), 0);
		main.setUndecorated(true);
		main.setAlwaysOnTop(true);
		main.setResizable(false);
		main.setContentPane(frame = new Frame());
		//main.setContentPane(DragAndDropIcon = new DragAndDropIcon());
		
		
		main.setBackground(new Color(243, 243, 243, 150));

		dropicon = new JLabel();
		dropicon.setBounds(0, 0, 60, height);
		main.add(dropicon);
		DragAndDropIcon DropIcon = new DragAndDropIcon();
		new DropTarget(dropicon, DropIcon);
        
		clock = new JTextArea();
		clock.setBounds(0, (height - 28), 60, height);
		clock.setFont(UIManager.getFont("Label.font").deriveFont(Font.BOLD, 16f));
		clock.setForeground(new Color(55, 55, 55));
		clock.setLineWrap(true);
		clock.setEditable(false);
		clock.setOpaque(false);
		tickTock();
		main.add(clock);

		Timer timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tickTock();
			}
		});
		timer.setRepeats(true);
		timer.setCoalesce(true);
		timer.setInitialDelay(0);
		timer.start();
		

		style.setTitle("ExanLauncher Dev style");
		style.setSize(2, height);
		style.setLocation((width - 60), 0);
		style.setUndecorated(true);
		style.setAlwaysOnTop(true);
		style.setResizable(false);
		style.setBackground(new Color(243, 243, 243, 185));
		style.setVisible(true);
		main.setVisible(true);
		HWND hwnd = new HWND(Native.getWindowPointer(main));
		Dwmapi.DWM_BLURBEHIND pBlurBehind = new Dwmapi.DWM_BLURBEHIND();
		pBlurBehind.dwFlags = Dwmapi.DWM_BB_ENABLE;
		pBlurBehind.fEnable = true;
		pBlurBehind.fTransitionOnMaximized = false;
		Dwmapi.INSTANCE.DwmEnableBlurBehindWindow(hwnd, pBlurBehind);

	}

	public static void main(String[] args) throws IOException {
		ButtonAPI.setSystemLookNFeel();
		ButtonAPI.setResourcePath("/fr/MrBn100ful/ExanLauncher/Rescources");
		instance = new Main(null);
		
	}
	public void tickTock() {
		int hourint = LocalDateTime.now().getHour();
		int minuteint = LocalDateTime.now().getMinute();
		
		if (((minuteint == 1)||(minuteint == 2)||(minuteint == 3)||(minuteint == 4)||(minuteint == 5)||(minuteint == 6)||(minuteint == 7)||(minuteint == 8)||(minuteint == 9))) {
			if (((hourint == 1)||(hourint == 2)||(hourint == 3)||(hourint == 4)||(hourint == 5)||(hourint == 6)||(hourint == 7)||(hourint == 8)||(hourint == 9))){
				String hour = "0" + hourint;
				String minute = " : "+ "0" + minuteint;
				clock.setText(hour + minute);
				
			}else{
				String hour = "" + hourint;
				String minute = " : "+ "0" + minuteint;
				clock.setText(hour + minute);
				
			}
				
			
			String hour = "0" + hourint;
			String minute = " : "+ "0" + minuteint;
			clock.setText(hour + minute);
			
			
			
		}else if (((hourint == 1)||(hourint == 2)||(hourint == 3)||(hourint == 4)||(hourint == 5)||(hourint == 6)||(hourint == 7)||(hourint == 8)||(hourint == 9))){
			String hour = "0" + hourint;
			String minute = " : "+ "" + minuteint;
			clock.setText(hour + minute);
			
		}else {
			String hour = "" + hourint;
			String minute = " : "+ minuteint;
			clock.setText(hour + minute);
			
		}
	
		
	}

}
