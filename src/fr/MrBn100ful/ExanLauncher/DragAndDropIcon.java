package fr.MrBn100ful.ExanLauncher;


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
import java.io.File;
import java.util.List;

import javax.swing.JPanel;

import fr.MrBn100ful.ButtonAPI.ButtonAPI;
import fr.MrBn100ful.ButtonAPI.event.ButtonAPIEvent;
import fr.MrBn100ful.ButtonAPI.event.ButtonAPIEventListener;
import fr.MrBn100ful.ButtonAPI.textured.STexturedButton;

@SuppressWarnings("serial")
public class DragAndDropIcon extends JPanel implements DropTargetListener, ButtonAPIEventListener  {
	
	private STexturedButton app1 = new STexturedButton(ButtonAPI.getResource("app.png"));
	private STexturedButton app2 = new STexturedButton(ButtonAPI.getResource("app.png"));
	private STexturedButton app3 = new STexturedButton(ButtonAPI.getResource("app.png"));
	private STexturedButton app4 = new STexturedButton(ButtonAPI.getResource("app.png"));
	private STexturedButton app5 = new STexturedButton(ButtonAPI.getResource("app.png"));
	
	@SuppressWarnings("unchecked")
	@Override
	public void drop(DropTargetDropEvent event) {
		System.out.println("Debug drag and drop");
        try {
           event.acceptDrop(DnDConstants.ACTION_COPY);
            List<File> droppedFiles = (List<File>)
                event.getTransferable().getTransferData(DataFlavor.javaFileListFlavor);
            
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
    		
            for (File file : droppedFiles) {
            	System.out.println(file);
            	
            	
        		
        		
            	
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

	@Override
	public void onEvent(ButtonAPIEvent event) {
		// TODO Auto-generated method stub
		
	}

}
