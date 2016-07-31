
package fr.MrBn100ful.ButtonAPI.abstractcomponents;
/**
 *  
 * @author MrBn100ful
 * 
 */


import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JComponent;

import fr.MrBn100ful.ButtonAPI.event.ButtonAPIEvent;
import fr.MrBn100ful.ButtonAPI.event.ButtonAPIEventListener;


@SuppressWarnings("serial")
public abstract class AbstractButton extends JComponent implements MouseListener {


    private String text;

    private Color textColor;


    private ArrayList<ButtonAPIEventListener> eventListeners = new ArrayList<ButtonAPIEventListener>();


    private boolean hover = false;

    public AbstractButton() {
        this.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {

        if(this.isEnabled())
            for(ButtonAPIEventListener eventListener : this.eventListeners)
                eventListener.onEvent(new ButtonAPIEvent(this, ButtonAPIEvent.BUTTON_CLICKED_EVENT));
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        hover = true;

        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        hover = false;

        repaint();
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);

        repaint();
    }

    public void setText(String text) {
        if(text == null)
            throw new IllegalArgumentException("text == null");
        this.text = text;

        repaint();
    }

    public String getText() {
        return text;
    }

    public void setTextColor(Color textColor) {
        if(textColor == null)
            throw new IllegalArgumentException("textColor == null");
        this.textColor = textColor;

        repaint();
    }

    public Color getTextColor() {
        return textColor;
    }

    public void addEventListener(ButtonAPIEventListener eventListener) {
        if(eventListener == null)
            throw new IllegalArgumentException("eventListener == null");

        this.eventListeners.add(eventListener);
    }

    public ArrayList<ButtonAPIEventListener> getEventListeners() {
        return this.eventListeners;
    }


    public boolean isHover() {
        return this.hover;
    }

}
