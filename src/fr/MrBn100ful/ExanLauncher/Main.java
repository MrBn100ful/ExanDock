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
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
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
		File file = new File("debug.txt");
		FileOutputStream fos = new FileOutputStream(file);
		PrintStream ps = new PrintStream(fos);
		System.setOut(ps);
		
		File iconinfo = new File("iconinfo.txt");
		System.out.println("[Debug] :  program launch");
		if(iconinfo.exists() && !iconinfo.isDirectory()) { 
			FileReader iconinforead = new FileReader("iconinfo.txt");
			int iconinfonumber = iconinforead.read();
			System.out.println("[Debug] :  " + (iconinfonumber - 1) + " icon create");
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
		Icon1();
		Icon2();
		Icon3();
		Icon4();
		Icon5();
		Icon6();
		Icon7();
		Icon8();
		Icon9();
		Icon10();
		Icon11();
		Icon12();
		Icon13();
		Icon14();
		Icon15();
		Icon16();
	}

	public static void main(String[] args) throws IOException {
		ButtonAPI.setSystemLookNFeel();
		ButtonAPI.setResourcePath("/fr/MrBn100ful/ExanLauncher/rescources");
		instance = new Main(null);
		
	}
	public void tickTock() {
		int hourint = LocalDateTime.now().getHour();
		int minuteint = LocalDateTime.now().getMinute();
		
		if ((((minuteint == 1)||(minuteint == 2)||(minuteint == 3)||(minuteint == 4)||(minuteint == 5)||(minuteint == 6)||(minuteint == 7)||(minuteint == 8)||(minuteint == 9))) & (((hourint == 1)||(hourint == 2)||(hourint == 3)||(hourint == 4)||(hourint == 5)||(hourint == 6)||(hourint == 7)||(hourint == 8)||(hourint == 9)))) {
				String hour = "0" + hourint;
				String minute = " : "+ "0" + minuteint;
				clock.setText(hour + minute);
			
			}else if (((hourint == 1)||(hourint == 2)||(hourint == 3)||(hourint == 4)||(hourint == 5)||(hourint == 6)||(hourint == 7)||(hourint == 8)||(hourint == 9))){
				String hour = "0" + hourint;
				String minute = " : "+ "" + minuteint;
				clock.setText(hour + minute);
				
			}else if (((minuteint == 1)||(minuteint == 2)||(minuteint == 3)||(minuteint == 4)||(minuteint == 5)||(minuteint == 6)||(minuteint == 7)||(minuteint == 8)||(minuteint == 9))) {
				String hour = "" + hourint;
				String minute = " : "+ "0" + minuteint;
				clock.setText(hour + minute);
			}else{
				String hour = "" + hourint;
				String minute = " : "+ "" + minuteint;
				clock.setText(hour + minute);
				
			}
			
		}
	
	public void Icon1 () {
		
		 try {
             UIManager.setLookAndFeel(
                     UIManager.getSystemLookAndFeelClassName());
         } catch (Exception e) {
             e.printStackTrace();
         }
		
		
		ImageIcon icon1 = new ImageIcon("icon1.png");
        JButton buttonicon1 = new JButton(icon1);
        buttonicon1.setBounds(0, 70, 60, 60);
        buttonicon1.setBorder(null);
        buttonicon1.setOpaque(false);
        buttonicon1.setContentAreaFilled(false);
        buttonicon1.setBorderPainted(false);
        main.add(buttonicon1);
        buttonicon1.addActionListener(new ActionListener()
        {
          @SuppressWarnings("unused")
		public void actionPerformed(ActionEvent e)
          {
        	 
        	  File iconinfo = new File("icon1.txt");
        	  try {
        		 if(iconinfo.exists() && !iconinfo.isDirectory()) { 
        			String filepath = "icon1.txt";
        			String iconfile = new String(Files.readAllBytes(Paths.get(filepath)));
     				Process process = new ProcessBuilder(iconfile).start();
     				System.out.println("[Debug] :  launch program");
        			
        			}else {
        				System.out.println("[Debug] :  Icon not created");
        				
        			}
        		
			} catch (IOException e2) {
				System.out.println("[Debug] :  launch program error");
				e2.printStackTrace();
			}
          }
        });
        System.out.println("[Debug] :  Drag And Drop Icon active");
        SwingUtilities.updateComponentTreeUI(main);
	}
	public void Icon2 () {
		
		 try {
           UIManager.setLookAndFeel(
                   UIManager.getSystemLookAndFeelClassName());
       } catch (Exception e) {
           e.printStackTrace();
       }
		
		
		ImageIcon icon1 = new ImageIcon("icon2.png");
      JButton buttonicon1 = new JButton(icon1);
      buttonicon1.setBounds(0, 130, 60, 60);
      buttonicon1.setBorder(null);
      buttonicon1.setOpaque(false);
      buttonicon1.setContentAreaFilled(false);
      buttonicon1.setBorderPainted(false);
      main.add(buttonicon1);
      buttonicon1.addActionListener(new ActionListener()
      {
        @SuppressWarnings("unused")
		public void actionPerformed(ActionEvent e)
        {
      	 
      	  File iconinfo = new File("icon2.txt");
      	  try {
      		 if(iconinfo.exists() && !iconinfo.isDirectory()) { 
      			String filepath = "icon2.txt";
      			String iconfile = new String(Files.readAllBytes(Paths.get(filepath)));
   				Process process = new ProcessBuilder(iconfile).start();
   				System.out.println("[Debug] :  launch program");
      			
      			}else {
      				System.out.println("[Debug] :  Icon not created");
      				
      			}
      		
			} catch (IOException e2) {
				System.out.println("[Debug] :  launch program error");
				e2.printStackTrace();
			}
        }
      });
      System.out.println("[Debug] :  Drag And Drop Icon active");
      SwingUtilities.updateComponentTreeUI(main);
	}
	public void Icon3 () {
		
		 try {
             UIManager.setLookAndFeel(
                     UIManager.getSystemLookAndFeelClassName());
         } catch (Exception e) {
             e.printStackTrace();
         }
		
		ImageIcon icon1 = new ImageIcon("icon3.png");
        JButton buttonicon1 = new JButton(icon1);
        buttonicon1.setBounds(0, 190, 60, 60);
        buttonicon1.setBorder(null);
        buttonicon1.setOpaque(false);
        buttonicon1.setContentAreaFilled(false);
        buttonicon1.setBorderPainted(false);
        
        main.add(buttonicon1);
        buttonicon1.addActionListener(new ActionListener()
        {
          @SuppressWarnings("unused")
		public void actionPerformed(ActionEvent e)
          {
        	 
        	  File iconinfo = new File("icon3.txt");
        	  try {
        		 if(iconinfo.exists() && !iconinfo.isDirectory()) { 
        			String filepath = "icon3.txt";
        			String iconfile = new String(Files.readAllBytes(Paths.get(filepath)));
     				Process process = new ProcessBuilder(iconfile).start();
     				System.out.println("[Debug] :  launch program");
        			
        			}else {
        				System.out.println("[Debug] :  Icon not created");
        				
        			}
        		
			} catch (IOException e2) {
				System.out.println("[Debug] :  launch program error");
				e2.printStackTrace();
			}
          }
        });
        System.out.println("[Debug] :  Drag And Drop Icon active");
        SwingUtilities.updateComponentTreeUI(main);
	}
	public void Icon4 () {
		
		 try {
             UIManager.setLookAndFeel(
                     UIManager.getSystemLookAndFeelClassName());
         } catch (Exception e) {
             e.printStackTrace();
         }
		
		ImageIcon icon1 = new ImageIcon("icon4.png");
        JButton buttonicon1 = new JButton(icon1);
        buttonicon1.setBounds(0, 250, 60, 60);
        buttonicon1.setBorder(null);
        buttonicon1.setOpaque(false);
        buttonicon1.setContentAreaFilled(false);
        buttonicon1.setBorderPainted(false);
        
        main.add(buttonicon1);
        buttonicon1.addActionListener(new ActionListener()
        {
          @SuppressWarnings("unused")
		public void actionPerformed(ActionEvent e)
          {
        	 
        	  File iconinfo = new File("icon4.txt");
        	  try {
        		 if(iconinfo.exists() && !iconinfo.isDirectory()) { 
        			String filepath = "icon4.txt";
        			String iconfile = new String(Files.readAllBytes(Paths.get(filepath)));
     				Process process = new ProcessBuilder(iconfile).start();
     				System.out.println("[Debug] :  launch program");
        			
        			}else {
        				System.out.println("[Debug] :  Icon not created");
        				
        			}
        		
			} catch (IOException e2) {
				System.out.println("[Debug] :  launch program error");
				e2.printStackTrace();
			}
          }
        });
        System.out.println("[Debug] :  Drag And Drop Icon active");
        SwingUtilities.updateComponentTreeUI(main);
	}
	
	public void Icon5 () {
		
		 try {
             UIManager.setLookAndFeel(
                     UIManager.getSystemLookAndFeelClassName());
         } catch (Exception e) {
             e.printStackTrace();
         }
		
		ImageIcon icon1 = new ImageIcon("icon5.png");
        JButton buttonicon1 = new JButton(icon1);
        buttonicon1.setBounds(0, 310, 60, 60);
        buttonicon1.setBorder(null);
        buttonicon1.setOpaque(false);
        buttonicon1.setContentAreaFilled(false);
        buttonicon1.setBorderPainted(false);
        
        main.add(buttonicon1);
        buttonicon1.addActionListener(new ActionListener()
        {
          @SuppressWarnings("unused")
		public void actionPerformed(ActionEvent e)
          {
        	 
        	  File iconinfo = new File("icon5.txt");
        	  try {
        		 if(iconinfo.exists() && !iconinfo.isDirectory()) { 
        			String filepath = "icon15.txt";
        			String iconfile = new String(Files.readAllBytes(Paths.get(filepath)));
     				Process process = new ProcessBuilder(iconfile).start();
     				System.out.println("[Debug] :  launch program");
        			
        			}else {
        				System.out.println("[Debug] :  Icon not created");
        				
        			}
        		
			} catch (IOException e2) {
				System.out.println("[Debug] :  launch program error");
				e2.printStackTrace();
			}
          }
        });
        System.out.println("[Debug] :  Drag And Drop Icon active");
        SwingUtilities.updateComponentTreeUI(main);
	}
	
	public void Icon6 () {
		
		 try {
             UIManager.setLookAndFeel(
                     UIManager.getSystemLookAndFeelClassName());
         } catch (Exception e) {
             e.printStackTrace();
         }
		
		ImageIcon icon1 = new ImageIcon("icon6.png");
        JButton buttonicon1 = new JButton(icon1);
        buttonicon1.setBounds(0, 370, 60, 60);
        buttonicon1.setBorder(null);
        buttonicon1.setOpaque(false);
        buttonicon1.setContentAreaFilled(false);
        buttonicon1.setBorderPainted(false);
        
        main.add(buttonicon1);
        buttonicon1.addActionListener(new ActionListener()
        {
          @SuppressWarnings("unused")
		public void actionPerformed(ActionEvent e)
          {
        	 
        	  File iconinfo = new File("icon6.txt");
        	  try {
        		 if(iconinfo.exists() && !iconinfo.isDirectory()) { 
        			String filepath = "icon6.txt";
        			String iconfile = new String(Files.readAllBytes(Paths.get(filepath)));
     				Process process = new ProcessBuilder(iconfile).start();
     				System.out.println("[Debug] :  launch program");
        			
        			}else {
        				System.out.println("[Debug] :  Icon not created");
        				
        			}
        		
			} catch (IOException e2) {
				System.out.println("[Debug] :  launch program error");
				e2.printStackTrace();
			}
          }
        });
        System.out.println("[Debug] :  Drag And Drop Icon active");
        SwingUtilities.updateComponentTreeUI(main);
	}

	public void Icon7 () {
		
		 try {
             UIManager.setLookAndFeel(
                     UIManager.getSystemLookAndFeelClassName());
         } catch (Exception e) {
             e.printStackTrace();
         }
		
		ImageIcon icon1 = new ImageIcon("icon7.png");
        JButton buttonicon1 = new JButton(icon1);
        buttonicon1.setBounds(0, 430, 60, 60);
        buttonicon1.setBorder(null);
        buttonicon1.setOpaque(false);
        buttonicon1.setContentAreaFilled(false);
        buttonicon1.setBorderPainted(false);
        
        main.add(buttonicon1);
        buttonicon1.addActionListener(new ActionListener()
        {
          @SuppressWarnings("unused")
		public void actionPerformed(ActionEvent e)
          {
        	 
        	  File iconinfo = new File("icon7.txt");
        	  try {
        		 if(iconinfo.exists() && !iconinfo.isDirectory()) { 
        			String filepath = "icon7.txt";
        			String iconfile = new String(Files.readAllBytes(Paths.get(filepath)));
     				Process process = new ProcessBuilder(iconfile).start();
     				System.out.println("[Debug] :  launch program");
        			
        			}else {
        				System.out.println("[Debug] :  Icon not created");
        				
        			}
        		
			} catch (IOException e2) {
				System.out.println("[Debug] :  launch program error");
				e2.printStackTrace();
			}
          }
        });
        System.out.println("[Debug] :  Drag And Drop Icon active");
        SwingUtilities.updateComponentTreeUI(main);
	}
	
	public void Icon8 () {
		
		 try {
             UIManager.setLookAndFeel(
                     UIManager.getSystemLookAndFeelClassName());
         } catch (Exception e) {
             e.printStackTrace();
         }
		
		ImageIcon icon1 = new ImageIcon("icon8.png");
        JButton buttonicon1 = new JButton(icon1);
        buttonicon1.setBounds(0, 490, 60, 60);
        buttonicon1.setBorder(null);
        buttonicon1.setOpaque(false);
        buttonicon1.setContentAreaFilled(false);
        buttonicon1.setBorderPainted(false);
        
        main.add(buttonicon1);
        buttonicon1.addActionListener(new ActionListener()
        {
          @SuppressWarnings("unused")
		public void actionPerformed(ActionEvent e)
          {
        	 
        	  File iconinfo = new File("icon8.txt");
        	  try {
        		 if(iconinfo.exists() && !iconinfo.isDirectory()) { 
        			String filepath = "icon8.txt";
        			String iconfile = new String(Files.readAllBytes(Paths.get(filepath)));
     				Process process = new ProcessBuilder(iconfile).start();
     				System.out.println("[Debug] :  launch program");
        			
        			}else {
        				System.out.println("[Debug] :  Icon not created");
        				
        			}
        		
			} catch (IOException e2) {
				System.out.println("[Debug] :  launch program error");
				e2.printStackTrace();
			}
          }
        });
        System.out.println("[Debug] :  Drag And Drop Icon active");
        SwingUtilities.updateComponentTreeUI(main);
	}
	public void Icon9 () {
		
		 try {
             UIManager.setLookAndFeel(
                     UIManager.getSystemLookAndFeelClassName());
         } catch (Exception e) {
             e.printStackTrace();
         }
		
		ImageIcon icon1 = new ImageIcon("icon9.png");
        JButton buttonicon1 = new JButton(icon1);
        buttonicon1.setBounds(0, 550, 60, 60);
        buttonicon1.setBorder(null);
        buttonicon1.setOpaque(false);
        buttonicon1.setContentAreaFilled(false);
        buttonicon1.setBorderPainted(false);
        
        main.add(buttonicon1);
        buttonicon1.addActionListener(new ActionListener()
        {
          @SuppressWarnings("unused")
		public void actionPerformed(ActionEvent e)
          {
        	 
        	  File iconinfo = new File("icon9.txt");
        	  try {
        		 if(iconinfo.exists() && !iconinfo.isDirectory()) { 
        			String filepath = "icon9.txt";
        			String iconfile = new String(Files.readAllBytes(Paths.get(filepath)));
     				Process process = new ProcessBuilder(iconfile).start();
     				System.out.println("[Debug] :  launch program");
        			
        			}else {
        				System.out.println("[Debug] :  Icon not created");
        				
        			}
        		
			} catch (IOException e2) {
				System.out.println("[Debug] :  launch program error");
				e2.printStackTrace();
			}
          }
        });
        System.out.println("[Debug] :  Drag And Drop Icon active");
        SwingUtilities.updateComponentTreeUI(main);
	}
	public void Icon10 () {
		
		 try {
             UIManager.setLookAndFeel(
                     UIManager.getSystemLookAndFeelClassName());
         } catch (Exception e) {
             e.printStackTrace();
         }
		
		ImageIcon icon1 = new ImageIcon("icon10.png");
        JButton buttonicon1 = new JButton(icon1);
        buttonicon1.setBounds(0, 610, 60, 60);
        buttonicon1.setBorder(null);
        buttonicon1.setOpaque(false);
        buttonicon1.setContentAreaFilled(false);
        buttonicon1.setBorderPainted(false);
        
        main.add(buttonicon1);
        buttonicon1.addActionListener(new ActionListener()
        {
          @SuppressWarnings("unused")
		public void actionPerformed(ActionEvent e)
          {
        	 
        	  File iconinfo = new File("icon10.txt");
        	  try {
        		 if(iconinfo.exists() && !iconinfo.isDirectory()) { 
        			String filepath = "icon10.txt";
        			String iconfile = new String(Files.readAllBytes(Paths.get(filepath)));
     				Process process = new ProcessBuilder(iconfile).start();
     				System.out.println("[Debug] :  launch program");
        			
        			}else {
        				System.out.println("[Debug] :  Icon not created");
        				
        			}
        		
			} catch (IOException e2) {
				System.out.println("[Debug] :  launch program error");
				e2.printStackTrace();
			}
          }
        });
        System.out.println("[Debug] :  Drag And Drop Icon active");
        SwingUtilities.updateComponentTreeUI(main);
	}
	public void Icon11 () {
		
		 try {
             UIManager.setLookAndFeel(
                     UIManager.getSystemLookAndFeelClassName());
         } catch (Exception e) {
             e.printStackTrace();
         }
		
		ImageIcon icon1 = new ImageIcon("icon11.png");
        JButton buttonicon1 = new JButton(icon1);
        buttonicon1.setBounds(0, 670, 60, 60);
        buttonicon1.setBorder(null);
        buttonicon1.setOpaque(false);
        buttonicon1.setContentAreaFilled(false);
        buttonicon1.setBorderPainted(false);
        
        main.add(buttonicon1);
        buttonicon1.addActionListener(new ActionListener()
        {
          @SuppressWarnings("unused")
		public void actionPerformed(ActionEvent e)
          {
        	 
        	  File iconinfo = new File("icon11.txt");
        	  try {
        		 if(iconinfo.exists() && !iconinfo.isDirectory()) { 
        			String filepath = "icon11.txt";
        			String iconfile = new String(Files.readAllBytes(Paths.get(filepath)));
     				Process process = new ProcessBuilder(iconfile).start();
     				System.out.println("[Debug] :  launch program");
        			
        			}else {
        				System.out.println("[Debug] :  Icon not created");
        				
        			}
        		
			} catch (IOException e2) {
				System.out.println("[Debug] :  launch program error");
				e2.printStackTrace();
			}
          }
        });
        System.out.println("[Debug] :  Drag And Drop Icon active");
        SwingUtilities.updateComponentTreeUI(main);
	}
	public void Icon12 () {
		
		 try {
             UIManager.setLookAndFeel(
                     UIManager.getSystemLookAndFeelClassName());
         } catch (Exception e) {
             e.printStackTrace();
         }
		
		ImageIcon icon1 = new ImageIcon("icon12.png");
        JButton buttonicon1 = new JButton(icon1);
        buttonicon1.setBounds(0, 730, 60, 60);
        buttonicon1.setBorder(null);
        buttonicon1.setOpaque(false);
        buttonicon1.setContentAreaFilled(false);
        buttonicon1.setBorderPainted(false);
        
        main.add(buttonicon1);
        buttonicon1.addActionListener(new ActionListener()
        {
          @SuppressWarnings("unused")
		public void actionPerformed(ActionEvent e)
          {
        	 
        	  File iconinfo = new File("icon12.txt");
        	  try {
        		 if(iconinfo.exists() && !iconinfo.isDirectory()) { 
        			String filepath = "icon12.txt";
        			String iconfile = new String(Files.readAllBytes(Paths.get(filepath)));
     				Process process = new ProcessBuilder(iconfile).start();
     				System.out.println("[Debug] :  launch program");
        			
        			}else {
        				System.out.println("[Debug] :  Icon not created");
        				
        			}
        		
			} catch (IOException e2) {
				System.out.println("[Debug] :  launch program error");
				e2.printStackTrace();
			}
          }
        });
        System.out.println("[Debug] :  Drag And Drop Icon active");
        SwingUtilities.updateComponentTreeUI(main);
	}
	public void Icon13 () {
		
		 try {
             UIManager.setLookAndFeel(
                     UIManager.getSystemLookAndFeelClassName());
         } catch (Exception e) {
             e.printStackTrace();
         }
		
		ImageIcon icon1 = new ImageIcon("icon13.png");
        JButton buttonicon1 = new JButton(icon1);
        buttonicon1.setBounds(0, 790, 60, 60);
        buttonicon1.setBorder(null);
        buttonicon1.setOpaque(false);
        buttonicon1.setContentAreaFilled(false);
        buttonicon1.setBorderPainted(false);
        
        main.add(buttonicon1);
        buttonicon1.addActionListener(new ActionListener()
        {
          @SuppressWarnings("unused")
		public void actionPerformed(ActionEvent e)
          {
        	 
        	  File iconinfo = new File("icon2.txt");
        	  try {
        		 if(iconinfo.exists() && !iconinfo.isDirectory()) { 
        			String filepath = "icon2.txt";
        			String iconfile = new String(Files.readAllBytes(Paths.get(filepath)));
     				Process process = new ProcessBuilder(iconfile).start();
     				System.out.println("[Debug] :  launch program");
        			
        			}else {
        				System.out.println("[Debug] :  Icon not created");
        				
        			}
        		
			} catch (IOException e2) {
				System.out.println("[Debug] :  launch program error");
				e2.printStackTrace();
			}
          }
        });
        System.out.println("[Debug] :  Drag And Drop Icon active");
        SwingUtilities.updateComponentTreeUI(main);
	}
	public void Icon14 () {
		
		 try {
             UIManager.setLookAndFeel(
                     UIManager.getSystemLookAndFeelClassName());
         } catch (Exception e) {
             e.printStackTrace();
         }
		
		ImageIcon icon1 = new ImageIcon("icon14.png");
        JButton buttonicon1 = new JButton(icon1);
        buttonicon1.setBounds(0, 850, 60, 60);
        buttonicon1.setBorder(null);
        buttonicon1.setOpaque(false);
        buttonicon1.setContentAreaFilled(false);
        buttonicon1.setBorderPainted(false);
        
        main.add(buttonicon1);
        buttonicon1.addActionListener(new ActionListener()
        {
          @SuppressWarnings("unused")
		public void actionPerformed(ActionEvent e)
          {
        	 
        	  File iconinfo = new File("icon14.txt");
        	  try {
        		 if(iconinfo.exists() && !iconinfo.isDirectory()) { 
        			String filepath = "icon14.txt";
        			String iconfile = new String(Files.readAllBytes(Paths.get(filepath)));
     				Process process = new ProcessBuilder(iconfile).start();
     				System.out.println("[Debug] :  launch program");
        			
        			}else {
        				System.out.println("[Debug] :  Icon not created");
        				
        			}
        		
			} catch (IOException e2) {
				System.out.println("[Debug] :  launch program error");
				e2.printStackTrace();
			}
          }
        });
        System.out.println("[Debug] :  Drag And Drop Icon active");
        SwingUtilities.updateComponentTreeUI(main);
	}
	public void Icon15 () {
		
		 try {
             UIManager.setLookAndFeel(
                     UIManager.getSystemLookAndFeelClassName());
         } catch (Exception e) {
             e.printStackTrace();
         }
		
		ImageIcon icon1 = new ImageIcon("icon15.png");
        JButton buttonicon1 = new JButton(icon1);
        buttonicon1.setBounds(0, 910, 60, 60);
        buttonicon1.setBorder(null);
        buttonicon1.setOpaque(false);
        buttonicon1.setContentAreaFilled(false);
        buttonicon1.setBorderPainted(false);
        
        main.add(buttonicon1);
        buttonicon1.addActionListener(new ActionListener()
        {
          @SuppressWarnings("unused")
		public void actionPerformed(ActionEvent e)
          {
        	 
        	  File iconinfo = new File("icon15.txt");
        	  try {
        		 if(iconinfo.exists() && !iconinfo.isDirectory()) { 
        			String filepath = "icon15.txt";
        			String iconfile = new String(Files.readAllBytes(Paths.get(filepath)));
     				Process process = new ProcessBuilder(iconfile).start();
     				System.out.println("[Debug] :  launch program");
        			
        			}else {
        				System.out.println("[Debug] :  Icon not created");
        				
        			}
        		
			} catch (IOException e2) {
				System.out.println("[Debug] :  launch program error");
				e2.printStackTrace();
			}
          }
        });
        System.out.println("[Debug] :  Drag And Drop Icon active");
        SwingUtilities.updateComponentTreeUI(main);
	}
	public void Icon16 () {
		
		 try {
             UIManager.setLookAndFeel(
                     UIManager.getSystemLookAndFeelClassName());
         } catch (Exception e) {
             e.printStackTrace();
         }
		
		ImageIcon icon1 = new ImageIcon("icon16.png");
        JButton buttonicon1 = new JButton(icon1);
        buttonicon1.setBounds(0, 970, 60, 60);
        buttonicon1.setBorder(null);
        buttonicon1.setOpaque(false);
        buttonicon1.setContentAreaFilled(false);
        buttonicon1.setBorderPainted(false);
        
        main.add(buttonicon1);
        buttonicon1.addActionListener(new ActionListener()
        {
          @SuppressWarnings("unused")
		public void actionPerformed(ActionEvent e)
          {
        	 
        	  File iconinfo = new File("icon16.txt");
        	  try {
        		 if(iconinfo.exists() && !iconinfo.isDirectory()) { 
        			String filepath = "icon16.txt";
        			String iconfile = new String(Files.readAllBytes(Paths.get(filepath)));
     				Process process = new ProcessBuilder(iconfile).start();
     				System.out.println("[Debug] :  launch program");
        			
        			}else {
        				System.out.println("[Debug] :  Icon not created");
        				
        			}
        		
			} catch (IOException e2) {
				System.out.println("[Debug] :  launch program error");
				e2.printStackTrace();
			}
          }
        });
        System.out.println("[Debug] :  Drag And Drop Icon active");
        SwingUtilities.updateComponentTreeUI(main);
	}
	

}
