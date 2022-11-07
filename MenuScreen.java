import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

/**
 * Created by dbaker on 1/8/2022.
 */
public class MenuScreen extends Screen{
    LinkedList<JButton> buttons = new LinkedList<>();
    protected  int BtnHeight = 40;
    protected  int BtnWidth = 200;
    protected  int BtnSpace = 30;

    /**
     * sets the position and size of th buttons
     * the default one below will place all buttons to be centered lower middle
     */
    protected void setButtonBounds(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        for (int i=0; i<buttons.size(); i++){
            JButton button = buttons.get(i);
            int x = (int)(screenSize.getWidth()/2-BtnWidth/2);
            int y = (int)(screenSize.getHeight()/2)+i*(BtnHeight+BtnSpace);
            button.setBounds(x,y,BtnWidth,BtnHeight);
        }
    }

    @Override
    public void load(JPanel panel) {
        setComponentBounds();
        for(JButton button : buttons){
            panel.add(button);
        }
        panel.repaint();
    }

    @Override
    public void unload(JPanel panel) {
        for(JButton button : buttons){
            panel.remove(button);
        }
    }

    @Override
    public void draw(Graphics g) {
        this.setComponentBounds();
    }

    /**
     * this is used to set position of all of the buttons and other components
     * for a menu screen. Override this if you have more than just buttons
     * for your menu.
     */
    protected void setComponentBounds(){
        this.setButtonBounds();
    }
}
