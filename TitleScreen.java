import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.LinkedList;

/**
 * Created by dbaker on 1/6/2022.
 */
public class TitleScreen extends MenuScreen{



    public TitleScreen(){
        JButton startBtn = new JButton("start");
        JButton optionsBtn = new JButton("options");
        JButton exitBtn = new JButton("exit");

        //add action listeners to button
        startBtn.addActionListener(new ButtonHandler("playScreen"));
        optionsBtn.addActionListener(new ButtonHandler("optionsScreen"));
        exitBtn.addActionListener(new ButtonHandler("exit"));

        //add buttons to list of buttons for the screen
        buttons.add(startBtn);
        buttons.add(optionsBtn);
        buttons.add(exitBtn);

    }

    @Override
    /**
     * buttons are handled by base class
     */
    public void load(JPanel panel) {
        super.load(panel);

    }

    @Override
    /**
     * buttons are handled by base class
     */
    public void unload(JPanel panel) {
        super.unload(panel);

    }

    @Override
    public void remove() {
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
    }






}
