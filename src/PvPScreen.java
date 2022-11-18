import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by dbaker on 1/8/2022.
 */
public class PvPScreen extends Screen{
    private Player player;
    private Player2 player2;
    private GameBall ball;
    private InputManager inputManager;
    public PvPScreen() {
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
        ball.pvpUpdate(inputManager,player,player2,ball);
    }

    @Override
    public void draw(Graphics g) {
        player.draw(g);
        player2.draw(g);
        ball.draw(g);

        //draw words example:
        Font currentFont = g.getFont();
        Font newFont = currentFont.deriveFont(currentFont.getSize() * 2.4F);
        g.setFont(newFont);
        g.setColor(Color.white);
        g.drawString("Player 1's score: "+GameBall.p1Score, 350, 50);
        g.drawString("Player 2's score: "+GameBall.p2Score, 1350, 50);
        g.drawString("Press space to start", 850, 50);
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
