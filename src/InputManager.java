import java.awt.event.KeyEvent;

/**
 * Created by dbaker on 1/8/2022.
 */
public class InputManager {
    public KeyInputState up;
    public KeyInputState down;
    public KeyInputState left;
    public KeyInputState right;

    public InputManager(){
        up = new KeyInputState();
        down = new KeyInputState();
        left = new KeyInputState();
        right = new KeyInputState();
    }

    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_W){
            up.pressed();
        }
        if(e.getKeyCode() == KeyEvent.VK_UP){
            up.pressed();
        }
        if(e.getKeyCode() == KeyEvent.VK_A){
            left.pressed();
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            left.pressed();
        }
        if(e.getKeyCode() == KeyEvent.VK_S){
            down.pressed();
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            down.pressed();
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
            up.released();
        }
        if(e.getKeyCode() == KeyEvent.VK_UP){
            up.released();
        }
        if(e.getKeyCode() == KeyEvent.VK_A){
            left.released();
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            left.released();
        }
        if(e.getKeyCode() == KeyEvent.VK_S){
            down.released();
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            down.released();
        }
        if(e.getKeyCode() == KeyEvent.VK_D){
            right.released();
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            right.released();
        }
    }
    public void update(){
        up.update();
        left.update();
        right.update();
        down.update();
    }
}
