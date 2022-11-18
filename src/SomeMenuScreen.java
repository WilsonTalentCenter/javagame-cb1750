import sun.net.dns.ResolverConfiguration;

import javax.swing.*;
import java.awt.*;

/**
 * Created by dbaker on 1/10/2022.
 */
public class SomeMenuScreen extends MenuScreen {



    public SomeMenuScreen(){
        JButton pvpBtn = new JButton("start: player vs player");
        JButton pvaBtn = new JButton("start: player vs AI");
        JButton optionsBtn = new JButton("options");
        JButton exitBtn = new JButton("exit");

        //add action listeners to button
        pvpBtn.addActionListener(new ButtonHandler("pvpScreen"));
        pvaBtn.addActionListener(new ButtonHandler("pvaScreen"));
        optionsBtn.addActionListener(new ButtonHandler("optionsScreen"));
        exitBtn.addActionListener(new ButtonHandler("exit"));

        //add buttons to list of buttons for the screen
        buttons.add(pvpBtn);
        buttons.add(pvaBtn);
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


    protected void setComponentBounds(){
        buttons.get(0).setBounds(200,300,BtnWidth,BtnHeight);

    }



}
