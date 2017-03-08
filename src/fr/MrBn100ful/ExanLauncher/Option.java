package fr.MrBn100ful.ExanLauncher;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;






public class Option {
	
	static JButton delallicon = new JButton("delete all icon");
	
	public static JFrame optionmenu = new JFrame();

	public static int var = 1;
	
	public boolean optionMenuOpen = false;
	public boolean optionMenuCreate = false;
	
	static Shutdown shutdown = new Shutdown();
	
	public static String[] Optionframe(){
			
			optionmenu.setTitle("ExanLauncher Dev Programe Menu");
			optionmenu.setSize(150, 150);

			optionmenu.setResizable(false);
			
			
			optionmenu.setVisible(true);;

			
			
			delallicon.setBounds(30, (30), 90, 90);
			optionmenu.add(delallicon);
			delallicon.addActionListener(new ActionListener() { 
				  @SuppressWarnings("static-access")
				public void actionPerformed(ActionEvent e) { 
						System.out.println("[Debug] :  delicon button press");
						
						while (var < 15) {
							File file = new File("icon" + var + ".txt");
							file.delete();
							
							File file2 = new File("icon" + var + ".png");
							file2.delete();
							
							File file2d = new File("debug.txt");
							file2d.delete();
							
							File filed = new File("iconinfo.txt");
							filed.delete();
							
							
							File files = new File("icon15.txt");
							files.delete();
							
							File file2s = new File("icon15.png");
							file2s.delete();
							
							
							File filee = new File("icon16.txt");
							filee.delete();
							
							File file2e = new File("icon16.png");
							file2e.delete();
							
							FileWriter iconinforead;
							try {
								iconinforead = new FileWriter("iconinfo.txt");
								iconinforead.write("");
								iconinforead.flush();
								iconinforead.close();
							} catch (IOException e1) {
								System.out.println("[Debug] :  reste iconinfo.txt bug");
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

}
