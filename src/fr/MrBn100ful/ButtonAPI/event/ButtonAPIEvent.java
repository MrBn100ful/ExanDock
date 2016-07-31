
package fr.MrBn100ful.ButtonAPI.event;
/**
 *  
 * @author MrBn100ful
 * 
 */

public class ButtonAPIEvent {


    public static final int BUTTON_CLICKED_EVENT = 0;


    private Object source;


    private int type;


    public ButtonAPIEvent(Object source, int type) {
        this.source = source;
    }


    public Object getSource() {
        return this.source;
    }

    public int getType() {
        return this.type;
    }

}
