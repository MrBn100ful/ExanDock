package fr.MrBn100ful.ExanLauncher;

/**
 *  Drag and drop class
 *  
 * @author MrBn100ful
 * 
 */

import java.awt.Image;
import java.awt.datatransfer.DataFlavor;

/**
 *  Drag and Drop event.
 *  
 * @author MrBn100ful
 * 
 */

import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileSystemView;

import net.coobird.thumbnailator.Thumbnails;

@SuppressWarnings("serial")
public class DragAndDropIcon extends JPanel implements DropTargetListener {
	
	int iconnumber = 1;
	Shutdown shutdown = new Shutdown();
	@SuppressWarnings({ "unchecked", "resource", "static-access" })
	@Override
	public void drop(DropTargetDropEvent event) {
		
		
		
		System.out.println("[Debug] :  Drag and drop activated");
        try {
           event.acceptDrop(DnDConstants.ACTION_COPY);
            List<File> droppedFiles = (List<File>)
                event.getTransferable().getTransferData(DataFlavor.javaFileListFlavor);
            
            
            
    		
            for (File file : droppedFiles) {
            	System.out.println(file);
        		try {

        			File iconinfo = new File("/icons/iconinfo.txt");
        			
					if(iconinfo.exists() && !iconinfo.isDirectory()) { 
						FileReader iconinforead = new FileReader("/icons/iconinfo.txt");
						int iconinfonumber = iconinforead.read();
						if (!(iconinfonumber > 10)){
	        				String iconpath = file.getPath();
	        				if (iconpath.endsWith(".exe")){
	        					
	        					
	        					
	        					File icon = new File("/icons/icon"+ iconinfonumber+"/icon.txt");
	                			FileWriter iconpathwriter = new FileWriter(icon);
	                			
	                			iconpathwriter.write(iconpath);
	                			iconpathwriter.flush();
	                			iconpathwriter.close();

	                			
	                			
	                			
	                			Icon ico = FileSystemView.getFileSystemView().getSystemIcon(file);

	                			Image image = ((ImageIcon) ico).getImage();
	                			
	                			BufferedImage bi = (BufferedImage)image;
	                			
	                			File f = new File("/icons/icon"+ iconinfonumber + "/icon.png");
	                			
	                			ImageIO.write(bi, "png", f);
	                			Thumbnails.of("/icons/icon"+iconinfonumber + "/icon.png").size(30, 30).toFile("/icons/icon"+iconinfonumber + "/icon.png");
	                			
	                			iconinfonumber = iconinfonumber + 1;
	                			
	                			FileWriter iconinfowriter = new FileWriter(iconinfo);
	    	        			iconinfowriter.write(iconinfonumber);
	    	        			iconinfowriter.flush();
	    	        			iconinfowriter.close();
	                			
	                			
	                			System.out.println("[Debug] :  .txt created");
	                			System.out.println("[Debug] :  Images created");
	                			shutdown.restartApplication(null);
	                			SwingUtilities.updateComponentTreeUI(this);
	        					
	        				}else {
	        					System.out.println("[Debug] : The file is not .exe");
	        					
	        				}
	        				
	        			}
					}else {
						
						FileWriter iconinfowriter = new FileWriter(iconinfo);
	        			iconinfowriter.write(iconnumber);
	        			iconinfowriter.flush();
	        			iconinfowriter.close();
	        			int iconinfonumber = 1;
						if (!(iconnumber > 10)){
	        				String iconpath = file.getPath();
	        				if (iconpath.endsWith(".exe")){
	        					
	        					
	        					
	        					File icon = new File("/icons/icon"+ iconinfonumber+"/icon.txt");
	                			FileWriter iconpathwriter = new FileWriter(icon);
	                			
	                			iconpathwriter.write(iconpath);
	                			iconpathwriter.flush();
	                			iconpathwriter.close();

	                			
	                			
	                			
	                			Icon ico = FileSystemView.getFileSystemView().getSystemIcon(file);

	                			Image image = ((ImageIcon) ico).getImage();
	                			
	                			BufferedImage bi = (BufferedImage)image;
	                			
	                			File f = new File("/icons/icon"+ iconinfonumber + "/icon.png");
	                			
	                			ImageIO.write(bi, "png", f);
	                			Thumbnails.of("/icons/icon"+ iconnumber + "/icon.png").size(30, 30).toFile("/icons/icon"+iconinfonumber + "/icon.png");
	                			
	                			iconinfonumber = iconinfonumber + 1;
	                			System.out.println(iconinfonumber);
	                			
	    	        			iconinfowriter.write(iconinfonumber);
	    	        			iconinfowriter.flush();
	    	        			iconinfowriter.close();
	                			
	                			
	                			System.out.println("[Debug] :  .txt created");
	                			System.out.println("[Debug] :  Images created");
	                			SwingUtilities.updateComponentTreeUI(this);
	                			shutdown.restartApplication(null);
	        				}else {
	        					System.out.println("[Debug] :  The file is not .exe");
	        					
	        				}
	        				
	        			}
					
        			}
        			
        			
        		} catch (IOException e) {
        			e.printStackTrace();
        			System.out.println("[Debug] :  File error");
        		}

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		

	}

	@Override
	public void dragEnter(DropTargetDragEvent event) {
	}

	@Override
	public void dragExit(DropTargetEvent event) {
	}

	@Override
	public void dragOver(DropTargetDragEvent event) {
	}

	@Override
	public void dropActionChanged(DropTargetDragEvent event) {
	}



}
