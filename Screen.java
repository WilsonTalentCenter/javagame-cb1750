import javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by dbaker on 1/7/2022.
 */
public abstract class Screen implements ScreenInterface {

    /**
     * called when the screen is changed (focus on this screen is lost)
     * You should remove all of the JComponents from the panel here.
     * also anything else when focus is lost
     */
    public void unload(JPanel panel){

    }

    /**
     * called when the screen is made active
     * you should add all of the JComponents here.
     * also anything else that needs to be done when focus is gained
     */
    public void load(JPanel panel){
        panel.repaint();
    }

    /**
     * called whenever the screen is removed from the screen manager
     */
    public void remove(){

    }

    public void update(){

    }

    public void draw(Graphics g){

    }

    public void keyPressed(KeyEvent e){

    }
    public void keyReleased(KeyEvent e){

    }

}
