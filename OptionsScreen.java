import javax.swing.*;
import java.awt.*;

/**
 * Created by dbaker on 1/8/2022.
 */
public class OptionsScreen extends MenuScreen {
    public OptionsScreen() {
        JButton backBtn = new JButton("back");

        //add action listeners to button

        backBtn.addActionListener(new ButtonHandler("titleScreen"));

        //add buttons to list of buttons for the screen
        buttons.add(backBtn);
    }

    @Override
    public void unload(JPanel panel) {
        super.unload(panel);
    }

    @Override
    public void load(JPanel panel) {
        super.load(panel);
    }

    @Override
    public void remove() {

    }

    @Override
    public void update() {
        super.update();
    }


}
