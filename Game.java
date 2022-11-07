import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by dbaker on 1/6/2022.
 */
public class Game {
    static Game game;
    public ScreenManager screenManager;

    private Game(){
        JFrame frame = new JFrame("Example Game");
        screenManager = new ScreenManager();
        Timer timer = new Timer(17, screenManager);
        screenManager.setBackground(Color.BLACK);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width =(int) screenSize.getWidth();
        int height =(int) screenSize.getHeight();
        frame.add(screenManager);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setResizable(false);
        frame.setFocusable(false);
        screenManager.setFocusable(true);
        screenManager.addKeyListener(screenManager);
        screenManager.requestFocus();
        frame.setVisible(true);
        timer.start();
    }


    public static void main(String[] args) {
        game = new Game();
    }




}
