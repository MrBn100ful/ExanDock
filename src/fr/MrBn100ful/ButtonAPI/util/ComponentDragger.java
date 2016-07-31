package fr.MrBn100ful.ButtonAPI.util;
/**
 *  
 * @author MrBn100ful
 * 
 */
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;

public class ComponentDragger extends MouseAdapter {

    private JComponent component;

    public ComponentDragger(JComponent component) {
        this.component = component;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        component.setLocation((int) component.getLocation().getX() + e.getX(),
                (int) component.getLocation().getY() + e.getY());
    }

}
