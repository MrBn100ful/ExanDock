
package fr.MrBn100ful.ButtonAPI.colored;
/**
 *  
 * @author MrBn100ful
 * 
 */
import static  fr.MrBn100ful.ButtonAPI.ButtonAPI.*;

import java.awt.Color;
import java.awt.Graphics;

import fr.MrBn100ful.ButtonAPI.abstractcomponents.AbstractButton;

@SuppressWarnings("serial")
public class SColoredButton extends AbstractButton {

    private Color color;

    private Color colorHover;

    private Color colorDisabled;

    public SColoredButton(Color color) {
        this(color, null, null);
    }

    public SColoredButton(Color color, Color colorHover) {
        this(color, colorHover, null);
    }

    public SColoredButton(Color color, Color colorHover, Color colorDisabled) {
        if(color == null)
            throw new IllegalArgumentException("Color == null");
        this.color = color;

        if(colorHover == null)
            this.colorHover = color.brighter();
        else
            this.colorHover = colorHover;

        if(colorDisabled == null)
            this.colorDisabled = color.darker();
        else
            this.colorDisabled = colorDisabled;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Color color;
        if(!this.isEnabled())
            color = colorDisabled;
        else if (super.isHover())
            color = colorHover;
        else
            color = this.color;

        fillFullsizedRect(g, this, color);

        if(getText() != null) {
            activateAntialias(g);

            if (getTextColor() != null)
                g.setColor(getTextColor());

            drawCenteredString(g, getText(), this.getBounds());
        }
    }

    public void setColor(Color color) {
        if(color == null)
            throw new IllegalArgumentException("Color == null");
        this.color = color;

        repaint();
    }


    public Color getColor() {
        return color;
    }

  
    public void setColorHover(Color colorHover) {

        if(colorHover == null)
            throw new IllegalArgumentException("colorHover == null");
        this.colorHover = colorHover;

        repaint();
    }

 
    public Color getColorHover() {
        return colorHover;
    }


    public void setColorDisabled(Color colorDisabled) {
        if(colorDisabled == null)
            throw new IllegalArgumentException("colorDisabled == null");
        this.colorDisabled = colorDisabled;

        repaint();
    }

  
    public Color getColorDisabled() {
        return colorDisabled;
    }
}
