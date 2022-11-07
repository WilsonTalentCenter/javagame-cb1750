import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by dbaker on 1/6/2022.
 */
public class ButtonHandler implements ActionListener{
        String newScreenName;
        public ButtonHandler(String newScreenName){
        this.newScreenName = newScreenName;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Game.game.screenManager.changeScreen(newScreenName);
    }
}
