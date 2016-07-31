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
import java.awt.dnd.DropTarget;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.UIManager;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.WinDef.HWND;

import fr.MrBn100ful.ButtonAPI.ButtonAPI;
import fr.MrBn100ful.ButtonAPI.event.ButtonAPIEvent;
import fr.MrBn100ful.ButtonAPI.event.ButtonAPIEventListener;
import fr.MrBn100ful.ButtonAPI.textured.STexturedButton;
import fr.MrBn100ful.ExanLauncher.Blurred.Dwmapi;


@SuppressWarnings("serial")
public class Main extends JFrame implements ButtonAPIEventListener {
	@SuppressWarnings("unused")
	private static Main instance;
	@SuppressWarnings("unused")
	private Frame frame;
	public JTextArea clock;
	public JLabel dropicon;
	public JFrame style = new JFrame();

	private STexturedButton app1 = new STexturedButton(ButtonAPI.getResource("app.png"));
	private STexturedButton app2 = new STexturedButton(ButtonAPI.getResource("app.png"));
	private STexturedButton app3 = new STexturedButton(ButtonAPI.getResource("app.png"));
	private STexturedButton app4 = new STexturedButton(ButtonAPI.getResource("app.png"));
	private STexturedButton app5 = new STexturedButton(ButtonAPI.getResource("app.png"));

	public Main(Component c) {
		this.setTitle("ExanLauncher Dev Main");
		this.setSize(60, 1080);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocation(1860, 0);
		this.setUndecorated(true);
		this.setAlwaysOnTop(true);
		this.setResizable(false);
		this.setContentPane(frame = new Frame());
		this.setBackground(new Color(243, 243, 243, 185));

		dropicon = new JLabel();
		dropicon.setBounds(0, 0, 60, 1080);
		this.add(dropicon);
		DragAndDropIcon DropIcon = new DragAndDropIcon();
		new DropTarget(dropicon, DropIcon);

		app1.setBounds(0, 70);
		app1.addEventListener(this);

		app2.setBounds(0, 140);
		app2.addEventListener(this);

		app3.setBounds(0, 210);
		app3.addEventListener(this);

		app4.setBounds(0, 280);
		app4.addEventListener(this);

		app5.setBounds(0, 350);
		app5.addEventListener(this);

		this.add(app1);
		this.add(app2);
		this.add(app3);
		this.add(app4);
		this.add(app5);

		clock = new JTextArea();
		clock.setBounds(0, 1020, 60, 1080);
		clock.setFont(UIManager.getFont("Label.font").deriveFont(Font.BOLD, 16f));
		clock.setForeground(new Color(55, 55, 55));
		clock.setLineWrap(true);
		clock.setEditable(false);
		clock.setOpaque(false);
		tickTock();
		this.add(clock);

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
		this.setVisible(true);

		style.setTitle("ExanLauncher Dev style");
		style.setSize(2, 1080);
		style.setLocation(1860, 0);
		style.setUndecorated(true);
		style.setAlwaysOnTop(true);
		style.setResizable(false);
		style.setBackground(new Color(243, 243, 243, 185));
		style.setVisible(true);

		HWND hwnd = new HWND(Native.getWindowPointer(this));
		Dwmapi.DWM_BLURBEHIND pBlurBehind = new Dwmapi.DWM_BLURBEHIND();
		pBlurBehind.dwFlags = Dwmapi.DWM_BB_ENABLE;
		pBlurBehind.fEnable = true;
		pBlurBehind.fTransitionOnMaximized = false;
		Dwmapi.INSTANCE.DwmEnableBlurBehindWindow(hwnd, pBlurBehind);

	}

	public static void main(String[] args) {
		ButtonAPI.setSystemLookNFeel();
		ButtonAPI.setResourcePath("/fr/MrBn100ful/ExanLauncher/rescources");
		instance = new Main(null);
	}

	public void tickTock() {
		clock.setText(DateFormat.getDateTimeInstance().format(new Date()));
	}

	@Override
	public void onEvent(ButtonAPIEvent e) {

	}

}
