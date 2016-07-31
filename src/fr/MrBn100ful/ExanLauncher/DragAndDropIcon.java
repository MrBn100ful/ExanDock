package fr.MrBn100ful.ExanLauncher;

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

public class DragAndDropIcon implements DropTargetListener {

	@Override
	public void drop(DropTargetDropEvent event) {

		event.acceptDrop(DnDConstants.ACTION_LINK);

		event.dropComplete(true);

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
