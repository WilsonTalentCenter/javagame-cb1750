import javafx.scene.input.KeyCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by dbaker on 1/8/2022.
 */
public class PlayScreen extends Screen{
    private Player player;
    private InputManager inputManager;
    public PlayScreen() {
        player = new Player();
        inputManager = new InputManager(); // holds the state for all of the inputs
    }

    @Override
    public void unload(JPanel panel) {

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

        player.update(inputManager);
    }

    @Override
    public void draw(Graphics g) {
        player.draw(g);
        //draw words example:
        g.drawString("My score: ", 10, 20);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        inputManager.keyPressed(e);

    }

    @Override
    public void keyReleased(KeyEvent e) {
        inputManager.keyReleased(e);
    }
}
