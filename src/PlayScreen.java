import javafx.scene.input.KeyCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by dbaker on 1/8/2022.
 */
public class PlayScreen extends Screen{
    private Player player;
    private Player2 player2;
    private GameBall ball;
    private InputManager inputManager;
    public PlayScreen() {
        player = new Player();
        player2 = new Player2();
        ball = new GameBall();
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
        inputManager.update();
        player.update(inputManager);
        player2.update(inputManager);
        ball.update(inputManager,player,player2,ball);
    }

    @Override
    public void draw(Graphics g) {
        player.draw(g);
        player2.draw(g);
        ball.draw(g);

        //draw words example:
        g.drawString("Player1 score: "+GameBall.p1Score, 500, 20);
        g.drawString("Player2 score: "+GameBall.p2Score, 1500, 20);
        g.setColor(Color.white);

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
