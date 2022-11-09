import java.awt.event.KeyEvent;
import java.security.Key;

/**
 * Created by dbaker on 1/8/2022.
 */
public class InputManager {
    public KeyInputState p1up;
    public KeyInputState p1down;
    public KeyInputState p2up;
    public KeyInputState p2down;
    public KeyInputState left;
    public KeyInputState right;

    public InputManager(){
        p1up = new KeyInputState();
        p1down = new KeyInputState();
        p2up = new KeyInputState();
        p2down = new KeyInputState();
        left = new KeyInputState();
        right = new KeyInputState();
    }

    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_W){
            p1up.pressed();
        }
        if(e.getKeyCode() == KeyEvent.VK_UP){
            p2up.pressed();
        }
        if(e.getKeyCode() == KeyEvent.VK_A){
            left.pressed();
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            left.pressed();
        }
        if(e.getKeyCode() == KeyEvent.VK_S){
            p1down.pressed();
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            p2down.pressed();
        }
        if(e.getKeyCode() == KeyEvent.VK_D){
            right.pressed();
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            right.pressed();
        }
    }


    public void keyReleased(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_W){
            p1up.released();
        }
        if(e.getKeyCode() == KeyEvent.VK_UP){
            p2up.released();
        }
        if(e.getKeyCode() == KeyEvent.VK_A){
            left.released();
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            left.released();
        }
        if(e.getKeyCode() == KeyEvent.VK_S){
            p1down.released();
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            p2down.released();
        }
        if(e.getKeyCode() == KeyEvent.VK_D){
            right.released();
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            right.released();
        }
    }
    public void update(){
        p1up.update();
        p1down.update();
        p2up.update();
        p2down.update();
        left.update();
        right.update();

    }
}
