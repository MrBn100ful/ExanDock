package fr.MrBn100ful.ExanDock;
/**
 *  Main of the program.
 *  
 * @author MrBn100ful
 * 
 */




import java.awt.Color;
import java.awt.Component;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.dnd.DropTarget;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.WinDef.HWND;

import fr.MrBn100ful.ExanDock.Blurred.Dwmapi;
import fr.MrBn100ful.ExanDock.DragAndDropIcon;
import fr.MrBn100ful.ExanDock.Frame;
import fr.MrBn100ful.ExanDock.Main;


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
	public JButton hide = new JButton(". . . .");
	

	@SuppressWarnings("unused")
	private DragAndDropIcon DragAndDropIcon;


	@SuppressWarnings({ "resource", "unused" })
	public Main(Component c) throws IOException {
		
		String[] lists = AutoUpdate.AutoUpdate();
		
		String[] lists2 = SetupFiles.setup();
		
		File config = new File("/exandock/config/config.txt");
		
		File color = new File("/exandock/config/color.txt");
		
		
		if(!config.exists() && !config.isDirectory()) { 
			
			FileWriter iconinfowriter = new FileWriter(config);
			
			String configplace = "right";
			iconinfowriter.write(configplace);
			iconinfowriter.flush();
			iconinfowriter.close();
			
		}
		
		if(!color.exists() && !color.isDirectory()) { 
			
			FileWriter iconinfowriter = new FileWriter(color);
			
			String configplace = "gray";
			iconinfowriter.write(configplace);
			iconinfowriter.flush();
			iconinfowriter.close();
			
		}
		
		String configpath = "/exandock/config/config.txt";
		
		String configfile = new String(Files.readAllBytes(Paths.get(configpath)));
		
		String colorpath = "/exandock/config/color.txt";
		
		String colorfile = new String(Files.readAllBytes(Paths.get(colorpath)));

		File file = new File("/exandock/config/debug.txt");
		FileOutputStream fos = new FileOutputStream(file);
		PrintStream ps = new PrintStream(fos);
		//System.setOut(ps);
		

		
		File iconinfo = new File("/exandock/icons/iconinfo.txt");
		System.out.println("[Debug] :  Program launched");
		if(iconinfo.exists() && !iconinfo.isDirectory()) { 
			FileReader iconinforead = new FileReader("/exandock/icons/iconinfo.txt");
			int iconinfonumber = iconinforead.read();
			System.out.println("[Debug] :  " + (iconinfonumber - 1) + " icon(s) created");
		}
		

		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();
		
		main.setTitle("exandock");
		
		main.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		dropicon = new JLabel();
		
		if (configfile.equals("right")){
			
			style.setLocation((width - 60), (height / 2) - 340);
			main.setLocation((width - 60), (height / 2) - 340);
			main.setSize(60, 680 );
			style.setSize(2, 680);
			dropicon.setBounds(0, 0, 60, height);
			
		}else if (configfile.equals("left")){
			
			style.setLocation(58, (height / 2) - 340);
			main.setLocation(0, (height / 2) - 340);
			main.setSize(60, 680 );
			style.setSize(2, 680);
			dropicon.setBounds(0, 0, 60, height);
			
		}else if (configfile.equals("up")){
			
			style.setLocation( ((width / 2) - 340) , 0) ;
			main.setLocation( ((width / 2) - 340) , 0) ;
			main.setSize( 680,60 );
			style.setSize(680, 2 );
			dropicon.setBounds(0, 0, height , 60 );
			
		}else if (configfile.equals("down")){
			
			style.setLocation( ((width / 2) - 340) , height - 60) ;
			main.setLocation( ((width / 2) - 340) , height - 60) ;
			main.setSize( 680,60 );
			style.setSize(680, 2 );
			dropicon.setBounds(0, 0, height , 60 );
			
			
		}
		
		style.setType(javax.swing.JFrame.Type.UTILITY);
		main.setType(javax.swing.JFrame.Type.UTILITY);
		
		
		main.setUndecorated(true);
		main.setAlwaysOnTop(true);
		main.setResizable(false);
		main.setContentPane(frame = new Frame());
		
		
		
		
		if (colorfile.equals("gray")){
		
			main.setBackground(new Color(91, 91, 91, 200));
			hide.setForeground(Color.WHITE);
		}else if (colorfile.equals("red")) {
		
			main.setBackground(new Color(246, 44, 44, 200));
			hide.setForeground(Color.WHITE);
			
		}else if (colorfile.equals("green")) {
			
			main.setBackground(new Color(22, 205, 52, 200));
			hide.setForeground(Color.WHITE);
		
		}else if (colorfile.equals("blue")) {
			
			main.setBackground(new Color(26, 138, 212, 200));
			hide.setForeground(Color.WHITE);
		
		}else if (colorfile.equals("white")) {
			
			main.setBackground(new Color(255, 255, 255, 200));
		
		}else if (colorfile.equals("yellow")) {
			
			main.setBackground(new Color(255, 230, 0, 200));
			hide.setForeground(Color.WHITE);
		
		}else if (colorfile.equals("pink")) {
			
			main.setBackground(new Color(235, 35, 195, 200));
			hide.setForeground(Color.WHITE);
		
		}else if (colorfile.equals("purple")) {
			
			main.setBackground(new Color(95, 35, 235, 200));
			hide.setForeground(Color.WHITE);
		
		}else if (colorfile.equals("orange")) {
			
			main.setBackground(new Color(235, 148, 35, 200));
			hide.setForeground(Color.WHITE);
		
		}

		
		main.add(dropicon);
		DragAndDropIcon DropIcon = new DragAndDropIcon();
		new DropTarget(dropicon, DropIcon);
		style.setTitle("exandock");
		
		style.setUndecorated(true);
		style.setAlwaysOnTop(true);
		style.setResizable(false);
		style.setBackground(new Color(243, 243, 243, 185));
		style.setVisible(true);
		main.setVisible(true);
		String sysProps = System.getProperty("os.name");
		
		if (sysProps.equals("Windows 7")){
			
			HWND hwnd = new HWND(Native.getWindowPointer(main));
			Dwmapi.DWM_BLURBEHIND pBlurBehind = new Dwmapi.DWM_BLURBEHIND();
			pBlurBehind.dwFlags = Dwmapi.DWM_BB_ENABLE;
			pBlurBehind.fEnable = true;
			pBlurBehind.fTransitionOnMaximized = false;
			Dwmapi.INSTANCE.DwmEnableBlurBehindWindow(hwnd, pBlurBehind);
		}

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
		
		hide.setBounds(0, 665, 60, 15);
		
		
		if (configfile.equals("up")){
			
			hide.setBounds(665 , 0, 15, 60);
			
		}else if (configfile.equals("down")){
			
			hide.setBounds(665 , 0, 15, 60);

		}
		
		
		hide.setContentAreaFilled(false);
		hide.setBorderPainted(false);
		hide.setFocusPainted(false);
		
		hide.setBorderPainted(false);
		hide.setFocusPainted(false);
		hide.setOpaque(false);
		main.add(hide);
		
		hide.addActionListener(new ActionListener() { 
			 
			public void actionPerformed(ActionEvent e) { 
				main.setVisible(false);
				style.setVisible(false);
				JFrame stophide = new JFrame();
				
				stophide.setSize(15, 30);
				stophide.setResizable(false);
				stophide.getContentPane().setLayout(null);
				stophide.setUndecorated(true);
				stophide.setType(javax.swing.JFrame.Type.UTILITY);
				JButton stophideicon = new JButton("<");

				if (configfile.equals("right")){
					stophide.setLocation((width - 15), (height / 2));
				}else if (configfile.equals("left")){
					stophide.setLocation(0, (height / 2) );					
				}else if (configfile.equals("up")){
					stophide.setLocation( ((width / 2)) , 0) ;
				}else if (configfile.equals("down")){
					stophide.setLocation( ((width / 2) ) , height - 25) ;
				}
				
				if (colorfile.equals("gray")){
					
					stophide.setBackground(new Color(91, 91, 91, 200));
					stophideicon.setForeground(Color.WHITE);
				
				}else if (colorfile.equals("red")) {
				
					stophide.setBackground(new Color(246, 44, 44, 200));
					stophideicon.setForeground(Color.WHITE);
					
				}else if (colorfile.equals("green")) {
					
					stophide.setBackground(new Color(22, 205, 52, 200));
					stophideicon.setForeground(Color.WHITE);
				
				}else if (colorfile.equals("blue")) {
					
					stophide.setBackground(new Color(26, 138, 212, 200));
					stophideicon.setForeground(Color.WHITE);
				
				}else if (colorfile.equals("white")) {
					
					stophide.setBackground(new Color(255, 255, 255, 200));
				
				}else if (colorfile.equals("yellow")) {
					
					stophide.setBackground(new Color(255, 230, 0, 200));
					stophideicon.setForeground(Color.WHITE);
				
				}else if (colorfile.equals("pink")) {
					
					stophide.setBackground(new Color(235, 35, 195, 200));
					stophideicon.setForeground(Color.WHITE);
				
				}else if (colorfile.equals("purple")) {
					
					stophide.setBackground(new Color(95, 35, 235, 200));
					stophideicon.setForeground(Color.WHITE);
				
				}else if (colorfile.equals("orange")) {
					
					stophide.setBackground(new Color(235, 148, 35, 200));
					stophideicon.setForeground(Color.WHITE);
				
				}
				stophideicon.setBounds(0, 0, 15, 30);
				stophideicon.setOpaque(false);
				stophideicon.setContentAreaFilled(false);
				stophideicon.setBorderPainted(false);
				stophideicon.setFocusPainted(false);
				stophide.add(stophideicon);
				
				stophide.setVisible(true);
				
				stophideicon.addActionListener(new ActionListener() { 
					 
					public void actionPerformed(ActionEvent e) { 
						style.setVisible(true);
						main.setVisible(true);
						
						stophide.setVisible(false);
					  }
				});
				
			  }
		});
		
	}


	public static void main(String[] args) throws IOException {
		instance = new Main(null);
		
	}
	
	public void Icon1 () {
		
		 try {
           UIManager.setLookAndFeel(
                   UIManager.getSystemLookAndFeelClassName());
       } catch (Exception e) {
           e.printStackTrace();
       }
		
		
		ImageIcon icon1 = new ImageIcon("/exandock/icons/icon1/icon.png");
      JButton buttonicon1 = new JButton(icon1);
      buttonicon1.setBounds(0, 70, 60, 60);

      	String configpath = "/exandock/config/config.txt";
		
      	String configfile = null;
		try {
		configfile = new String(Files.readAllBytes(Paths.get(configpath)));
		} catch (IOException e1) {
		e1.printStackTrace();
		}
		
		if (configfile.equals("up")){
			  buttonicon1.setBounds(70, 0, 60, 60);
		}else if (configfile.equals("down")){
			  buttonicon1.setBounds(70, 0, 60, 60);
		}
      
      buttonicon1.setBorder(null);
      buttonicon1.setOpaque(false);
      buttonicon1.setContentAreaFilled(false);
      buttonicon1.setBorderPainted(false);
      buttonicon1.setFocusPainted(false);
      main.add(buttonicon1);
      buttonicon1.addActionListener(new ActionListener()
      {
        @SuppressWarnings("unused")
		public void actionPerformed(ActionEvent e)
        {
      	 
      	  File iconinfo = new File("/exandock/icons/icon1/icon.txt");
      	  try {
      		 if(iconinfo.exists() && !iconinfo.isDirectory()) { 
      			String filepath = "/exandock/icons/icon1/icon.txt";
      			String iconfile = new String(Files.readAllBytes(Paths.get(filepath)));
   				Process process = new ProcessBuilder(iconfile).start();
   				System.out.println("[Debug] :  Launch program");
      			
      			}else {
      				System.out.println("[Debug] :  Icon is not created");
      				
      			}
      		
			} catch (IOException e2) {
				System.out.println("[Debug] :  Launch error");
				e2.printStackTrace();
			}
        }
      });
      System.out.println("[Debug] :  Drag and drop icon activated");
      SwingUtilities.updateComponentTreeUI(main);
	}
	public void Icon2 () {
		
		 try {
         UIManager.setLookAndFeel(
                 UIManager.getSystemLookAndFeelClassName());
     } catch (Exception e) {
         e.printStackTrace();
     }
		
		
		ImageIcon icon1 = new ImageIcon("/exandock/icons/icon2/icon.png");
    JButton buttonicon1 = new JButton(icon1);
    buttonicon1.setBounds(0, 130, 60, 60);
    
  	String configpath = "/exandock/config/config.txt";
	
  	String configfile = null;
	try {
	configfile = new String(Files.readAllBytes(Paths.get(configpath)));
	} catch (IOException e1) {
	e1.printStackTrace();
	}
	
	if (configfile.equals("up")){
		  buttonicon1.setBounds(130, 0, 60, 60);
	}else if (configfile.equals("down")){
		  buttonicon1.setBounds(130, 0, 60, 60);
	}
	
    buttonicon1.setBorder(null);
    buttonicon1.setOpaque(false);
    buttonicon1.setContentAreaFilled(false);
    buttonicon1.setBorderPainted(false);
    buttonicon1.setFocusPainted(false);
    
    main.add(buttonicon1);
    buttonicon1.addActionListener(new ActionListener()
    {
      @SuppressWarnings("unused")
		public void actionPerformed(ActionEvent e)
      {
    	 
    	  File iconinfo = new File("/exandock/icons/icon2/icon.txt");
    	  try {
    		 if(iconinfo.exists() && !iconinfo.isDirectory()) { 
    			String filepath = "/exandock/icons/icon2/icon.txt";
    			String iconfile = new String(Files.readAllBytes(Paths.get(filepath)));
 				Process process = new ProcessBuilder(iconfile).start();
 				System.out.println("[Debug] :  Launch program");
    			
    			}else {
    				System.out.println("[Debug] :  Icon is not created");
    				
    			}
    		
			} catch (IOException e2) {
				System.out.println("[Debug] :  Launch error");
				e2.printStackTrace();
			}
      }
    });
    System.out.println("[Debug] :  Drag and drop icon activated");
    SwingUtilities.updateComponentTreeUI(main);
	}
	public void Icon3 () {
		
		 try {
           UIManager.setLookAndFeel(
                   UIManager.getSystemLookAndFeelClassName());
       } catch (Exception e) {
           e.printStackTrace();
       }
		
		ImageIcon icon1 = new ImageIcon("/exandock/icons/icon3/icon.png");
      JButton buttonicon1 = new JButton(icon1);
      buttonicon1.setBounds(0, 190, 60, 60);
      
    	String configpath = "/exandock/config/config.txt";
    	
      	String configfile = null;
    	try {
    	configfile = new String(Files.readAllBytes(Paths.get(configpath)));
    	} catch (IOException e1) {
    	e1.printStackTrace();
    	}
    	
    	if (configfile.equals("up")){
    		  buttonicon1.setBounds(190, 0, 60, 60);
    	}else if (configfile.equals("down")){
    		  buttonicon1.setBounds(190, 0, 60, 60);
    	}
      
      buttonicon1.setBorder(null);
      buttonicon1.setOpaque(false);
      buttonicon1.setContentAreaFilled(false);
      buttonicon1.setBorderPainted(false);
      buttonicon1.setFocusPainted(false);
      
      main.add(buttonicon1);
      buttonicon1.addActionListener(new ActionListener()
      {
        @SuppressWarnings("unused")
		public void actionPerformed(ActionEvent e)
        {
      	 
      	  File iconinfo = new File("/exandock/icons/icon3/icon.txt");
      	  try {
      		 if(iconinfo.exists() && !iconinfo.isDirectory()) { 
      			String filepath = "/exandock/icons/icon3/icon.txt";
      			String iconfile = new String(Files.readAllBytes(Paths.get(filepath)));
   				Process process = new ProcessBuilder(iconfile).start();
   				System.out.println("[Debug] :  Launch program");
      			
      			}else {
      				System.out.println("[Debug] :  Icon is not created");
      				
      			}
      		
			} catch (IOException e2) {
				System.out.println("[Debug] :  Launch error");
				e2.printStackTrace();
			}
        }
      });
      System.out.println("[Debug] :  Drag and drop icon activated");
      SwingUtilities.updateComponentTreeUI(main);
	}
	public void Icon4 () {
		
		 try {
           UIManager.setLookAndFeel(
                   UIManager.getSystemLookAndFeelClassName());
       } catch (Exception e) {
           e.printStackTrace();
       }
		
		ImageIcon icon1 = new ImageIcon("/exandock/icons/icon4/icon.png");
      JButton buttonicon1 = new JButton(icon1);
      buttonicon1.setBounds(0, 250, 60, 60);
    	String configpath = "/exandock/config/config.txt";
    	
      	String configfile = null;
    	try {
    	configfile = new String(Files.readAllBytes(Paths.get(configpath)));
    	} catch (IOException e1) {
    	e1.printStackTrace();
    	}
    	
    	if (configfile.equals("up")){
    		  buttonicon1.setBounds(250, 0, 60, 60);
    	}else if (configfile.equals("down")){
    		  buttonicon1.setBounds(250, 0, 60, 60);
    	}
      buttonicon1.setBorder(null);
      buttonicon1.setOpaque(false);
      buttonicon1.setContentAreaFilled(false);
      buttonicon1.setBorderPainted(false);
      buttonicon1.setFocusPainted(false);
      main.add(buttonicon1);
      buttonicon1.addActionListener(new ActionListener()
      {
        @SuppressWarnings("unused")
		public void actionPerformed(ActionEvent e)
        {
      	 
      	  File iconinfo = new File("/exandock/icons/icon4/icon.txt");
      	  try {
      		 if(iconinfo.exists() && !iconinfo.isDirectory()) { 
      			String filepath = "/exandock/icons/icon4/icon.txt";
      			String iconfile = new String(Files.readAllBytes(Paths.get(filepath)));
   				Process process = new ProcessBuilder(iconfile).start();
   				System.out.println("[Debug] :  Launch program");
      			
      			}else {
      				System.out.println("[Debug] :  Icon is not created");
      				
      			}
      		
			} catch (IOException e2) {
				System.out.println("[Debug] :  Launch error");
				e2.printStackTrace();
			}
        }
      });
      System.out.println("[Debug] :  Drag and drop icon activated");
      SwingUtilities.updateComponentTreeUI(main);
	}
	
	public void Icon5 () {
		
		 try {
           UIManager.setLookAndFeel(
                   UIManager.getSystemLookAndFeelClassName());
       } catch (Exception e) {
           e.printStackTrace();
       }
		
		ImageIcon icon1 = new ImageIcon("/exandock/icons/icon5/icon.png");
      JButton buttonicon1 = new JButton(icon1);
      buttonicon1.setBounds(0, 310, 60, 60);
    	String configpath = "/exandock/config/config.txt";
    	
      	String configfile = null;
    	try {
    	configfile = new String(Files.readAllBytes(Paths.get(configpath)));
    	} catch (IOException e1) {
    	e1.printStackTrace();
    	}
    	
    	if (configfile.equals("up")){
    		  buttonicon1.setBounds(310, 0, 60, 60);
    	}else if (configfile.equals("down")){
    		  buttonicon1.setBounds(310, 0, 60, 60);
    	}
      buttonicon1.setBorder(null);
      buttonicon1.setOpaque(false);
      buttonicon1.setContentAreaFilled(false);
      buttonicon1.setBorderPainted(false);
      buttonicon1.setFocusPainted(false);
      main.add(buttonicon1);
      buttonicon1.addActionListener(new ActionListener()
      {
        @SuppressWarnings("unused")
		public void actionPerformed(ActionEvent e)
        {
      	 
      	  File iconinfo = new File("/exandock/icons/icon5/icon.txt");
      	  try {
      		 if(iconinfo.exists() && !iconinfo.isDirectory()) { 
      			String filepath = "/exandock/icons/icon5/icon.txt";
      			String iconfile = new String(Files.readAllBytes(Paths.get(filepath)));
   				Process process = new ProcessBuilder(iconfile).start();
   				System.out.println("[Debug] :  Launch program");
      			
      			}else {
      				System.out.println("[Debug] :  Icon is not created");
      				
      			}
      		
			} catch (IOException e2) {
				System.out.println("[Debug] :  Launch error");
				e2.printStackTrace();
			}
        }
      });
      System.out.println("[Debug] :  Drag and drop icon activated");
      SwingUtilities.updateComponentTreeUI(main);
	}
	
	public void Icon6 () {
		
		 try {
           UIManager.setLookAndFeel(
                   UIManager.getSystemLookAndFeelClassName());
       } catch (Exception e) {
           e.printStackTrace();
       }
		
		ImageIcon icon1 = new ImageIcon("/exandock/icons/icon6/icon.png");
      JButton buttonicon1 = new JButton(icon1);
      buttonicon1.setBounds(0, 370, 60, 60);
    	String configpath = "/exandock/config/config.txt";
    	
      	String configfile = null;
    	try {
    	configfile = new String(Files.readAllBytes(Paths.get(configpath)));
    	} catch (IOException e1) {
    	e1.printStackTrace();
    	}
    	
    	if (configfile.equals("up")){
    		  buttonicon1.setBounds(370, 0, 60, 60);
    	}else if (configfile.equals("down")){
    		  buttonicon1.setBounds(370, 0, 60, 60);
    	}
      buttonicon1.setBorder(null);
      buttonicon1.setOpaque(false);
      buttonicon1.setContentAreaFilled(false);
      buttonicon1.setBorderPainted(false);
      buttonicon1.setFocusPainted(false);
      main.add(buttonicon1);
      buttonicon1.addActionListener(new ActionListener()
      {
        @SuppressWarnings("unused")
		public void actionPerformed(ActionEvent e)
        {
      	 
      	  File iconinfo = new File("/exandock/icons/icon6/icon.txt");
      	  try {
      		 if(iconinfo.exists() && !iconinfo.isDirectory()) { 
      			String filepath = "/exandock/icons/icon6/icon.txt";
      			String iconfile = new String(Files.readAllBytes(Paths.get(filepath)));
   				Process process = new ProcessBuilder(iconfile).start();
   				System.out.println("[Debug] :  Launch program");
      			
      			}else {
      				System.out.println("[Debug] :  Icon is not created");
      				
      			}
      		
			} catch (IOException e2) {
				System.out.println("[Debug] :  Launch error");
				e2.printStackTrace();
			}
        }
      });
      System.out.println("[Debug] :  Drag and drop icon activated");
      SwingUtilities.updateComponentTreeUI(main);
	}

	public void Icon7 () {
		
		 try {
           UIManager.setLookAndFeel(
                   UIManager.getSystemLookAndFeelClassName());
       } catch (Exception e) {
           e.printStackTrace();
       }
		
		ImageIcon icon1 = new ImageIcon("/exandock/icons/icon7/icon.png");
      JButton buttonicon1 = new JButton(icon1);
      buttonicon1.setBounds(0, 430, 60, 60);
      
    	String configpath = "/exandock/config/config.txt";
    	
      	String configfile = null;
    	try {
    	configfile = new String(Files.readAllBytes(Paths.get(configpath)));
    	} catch (IOException e1) {
    	e1.printStackTrace();
    	}
    	
    	if (configfile.equals("up")){
    		  buttonicon1.setBounds(430, 0, 60, 60);
    	}else if (configfile.equals("down")){
    		  buttonicon1.setBounds(430, 0, 60, 60);
    	}
      buttonicon1.setBorder(null);
      buttonicon1.setOpaque(false);
      buttonicon1.setContentAreaFilled(false);
      buttonicon1.setBorderPainted(false);
      buttonicon1.setFocusPainted(false);
      main.add(buttonicon1);
      buttonicon1.addActionListener(new ActionListener()
      {
        @SuppressWarnings("unused")
		public void actionPerformed(ActionEvent e)
        {
      	 
      	  File iconinfo = new File("/exandock/icons/icon7/icon.txt");
      	  try {
      		 if(iconinfo.exists() && !iconinfo.isDirectory()) { 
      			String filepath = "/exandock/icons/icon7/icon.txt";
      			String iconfile = new String(Files.readAllBytes(Paths.get(filepath)));
   				Process process = new ProcessBuilder(iconfile).start();
   				System.out.println("[Debug] :  Launch program");
      			
      			}else {
      				System.out.println("[Debug] :  Icon is not created");
      				
      			}
      		
			} catch (IOException e2) {
				System.out.println("[Debug] :  Launch error");
				e2.printStackTrace();
			}
        }
      });
      System.out.println("[Debug] :  Drag and drop icon activated");
      SwingUtilities.updateComponentTreeUI(main);
	}
	
	public void Icon8 () {
		
		 try {
           UIManager.setLookAndFeel(
                   UIManager.getSystemLookAndFeelClassName());
       } catch (Exception e) {
           e.printStackTrace();
       }
		
		ImageIcon icon1 = new ImageIcon("/exandock/icons/icon8/icon.png");
      JButton buttonicon1 = new JButton(icon1);
      buttonicon1.setBounds(0, 490, 60, 60);
    	String configpath = "/exandock/config/config.txt";
    	
      	String configfile = null;
    	try {
    	configfile = new String(Files.readAllBytes(Paths.get(configpath)));
    	} catch (IOException e1) {
    	e1.printStackTrace();
    	}
    	
    	if (configfile.equals("up")){
    		  buttonicon1.setBounds(490, 0, 60, 60);
    	}else if (configfile.equals("down")){
    		  buttonicon1.setBounds(490, 0, 60, 60);
    	}
      buttonicon1.setBorder(null);
      buttonicon1.setOpaque(false);
      buttonicon1.setContentAreaFilled(false);
      buttonicon1.setBorderPainted(false);
      buttonicon1.setFocusPainted(false);
      main.add(buttonicon1);
      buttonicon1.addActionListener(new ActionListener()
      {
        @SuppressWarnings("unused")
		public void actionPerformed(ActionEvent e)
        {
      	 
      	  File iconinfo = new File("/exandock/icons/icon8/icon.txt");
      	  try {
      		 if(iconinfo.exists() && !iconinfo.isDirectory()) { 
      			String filepath = "/exandock/icons/icon8/icon.txt";
      			String iconfile = new String(Files.readAllBytes(Paths.get(filepath)));
   				Process process = new ProcessBuilder(iconfile).start();
   				System.out.println("[Debug] :  Launch program");
      			
      			}else {
      				System.out.println("[Debug] :  Icon is not created");
      				
      			}
      		
			} catch (IOException e2) {
				System.out.println("[Debug] :  Launch error");
				e2.printStackTrace();
			}
        }
      });
      System.out.println("[Debug] :  Drag and drop icon activated");
      SwingUtilities.updateComponentTreeUI(main);
	}
	public void Icon9 () {
		
		 try {
           UIManager.setLookAndFeel(
                   UIManager.getSystemLookAndFeelClassName());
       } catch (Exception e) {
           e.printStackTrace();
       }
		
		ImageIcon icon1 = new ImageIcon("/exandock/icons/icon9/icon.png");
      JButton buttonicon1 = new JButton(icon1);
      buttonicon1.setBounds(0, 550, 60, 60);
    	String configpath = "/exandock/config/config.txt";
    	
      	String configfile = null;
    	try {
    	configfile = new String(Files.readAllBytes(Paths.get(configpath)));
    	} catch (IOException e1) {
    	e1.printStackTrace();
    	}
    	
    	if (configfile.equals("up")){
    		  buttonicon1.setBounds(550, 0, 60, 60);
    	}else if (configfile.equals("down")){
    		  buttonicon1.setBounds(550, 0, 60, 60);
    	}
      buttonicon1.setBorder(null);
      buttonicon1.setOpaque(false);
      buttonicon1.setContentAreaFilled(false);
      buttonicon1.setBorderPainted(false);
      buttonicon1.setFocusPainted(false);
      main.add(buttonicon1);
      buttonicon1.addActionListener(new ActionListener()
      {
        @SuppressWarnings("unused")
		public void actionPerformed(ActionEvent e)
        {
      	 
      	  File iconinfo = new File("/exandock/icons/icon9/icon.txt");
      	  try {
      		 if(iconinfo.exists() && !iconinfo.isDirectory()) { 
      			String filepath = "/exandock/icons/icon9/icon.txt";
      			String iconfile = new String(Files.readAllBytes(Paths.get(filepath)));
   				Process process = new ProcessBuilder(iconfile).start();
   				System.out.println("[Debug] :  Launch program");
      			
      			}else {
      				System.out.println("[Debug] :  Icon is not created");
      				
      			}
      		
			} catch (IOException e2) {
				System.out.println("[Debug] :  Launch error");
				e2.printStackTrace();
			}
        }
      });
      System.out.println("[Debug] :  Drag and drop icon activated");
      SwingUtilities.updateComponentTreeUI(main);
	}
	public void Icon10 () {
		
		 try {
           UIManager.setLookAndFeel(
                   UIManager.getSystemLookAndFeelClassName());
       } catch (Exception e) {
           e.printStackTrace();
       }
		
		ImageIcon icon1 = new ImageIcon("/exandock/icons/icon10/icon.png");
      JButton buttonicon1 = new JButton(icon1);
      buttonicon1.setBounds(0, 610, 60, 60);
    	String configpath = "/exandock/config/config.txt";
    	
      	String configfile = null;
    	try {
    	configfile = new String(Files.readAllBytes(Paths.get(configpath)));
    	} catch (IOException e1) {
    	e1.printStackTrace();
    	}
    	
    	if (configfile.equals("up")){
    		  buttonicon1.setBounds(610, 0, 60, 60);
    	}else if (configfile.equals("down")){
    		  buttonicon1.setBounds(610, 0, 60, 60);
    	}
      buttonicon1.setBorder(null);
      buttonicon1.setOpaque(false);
      buttonicon1.setContentAreaFilled(false);
      buttonicon1.setBorderPainted(false);
      buttonicon1.setFocusPainted(false);
      main.add(buttonicon1);
      buttonicon1.addActionListener(new ActionListener()
      {
        @SuppressWarnings("unused")
		public void actionPerformed(ActionEvent e)
        {
      	 
      	  File iconinfo = new File("/exandock/icons/icon10/icon.txt");
      	  try {
      		 if(iconinfo.exists() && !iconinfo.isDirectory()) { 
      			String filepath = "/exandock/icons/icon10/icon.txt";
      			String iconfile = new String(Files.readAllBytes(Paths.get(filepath)));
   				Process process = new ProcessBuilder(iconfile).start();
   				System.out.println("[Debug] :  Launch program");
      			
      			}else {
      				System.out.println("[Debug] :  Icon is not created");
      				
      			}
      		
			} catch (IOException e2) {
				System.out.println("[Debug] :  Launch error");
				e2.printStackTrace();
			}
        }
      });
      System.out.println("[Debug] :  Drag and drop icon activated");
      SwingUtilities.updateComponentTreeUI(main);
	}

}
