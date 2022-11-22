import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by cb1750 on 11/18/2022.
 */
public class PvAScreen extends Screen {
    private  Player player;
    private AI ai;
    private GameBall ball;
    private GlassBall glassBall;
    private InputManager inputManager;

    public PvAScreen(){
        player = new Player();
        ai = new AI();
        ball = new GameBall();
        glassBall = new GlassBall();
        inputManager = new InputManager();
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
        ball.pvaUpdate(inputManager,ai,player,ball);
        glassBall.update(player,ball);
        ai.update(ai, ball);


    }
    @Override
    public void draw(Graphics g) {
        player.draw(g);
        ai.draw(g);
        ball.draw(g);
       // glassBall.draw(g);

        //draw words example:
        Font currentFont = g.getFont();
        Font newFont = currentFont.deriveFont(currentFont.getSize() * 2.4F);
        g.setFont(newFont);
        g.setColor(Color.white);
        g.drawString("Player 1's score: "+GameBall.p1Score, 350, 50);
        g.drawString("AI's score: "+GameBall.p2Score, 1350, 50);
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
