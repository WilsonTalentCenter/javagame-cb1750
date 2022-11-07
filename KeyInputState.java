/**
 * Created by dbaker on 1/8/2022.
 */
public class KeyInputState {
    private boolean isPressed;
    private boolean justPressed;
    private boolean justReleased;
    private boolean prevIsPressed;
    public KeyInputState(){
        isPressed = false;
        justPressed = false;
        justReleased = false;
        prevIsPressed = false;
    }

    public boolean isPressed() {
        return isPressed;
    }

    public boolean wasJustPressed() {
        return justPressed;
    }

    public boolean wasJustReleased() {
        return justReleased;
    }

    public void update(){
        justPressed = isPressed && !prevIsPressed;
        justReleased = !isPressed && prevIsPressed;
        prevIsPressed = isPressed;
    }
    public void pressed(){
        isPressed = true;
    }
    public void released(){
        isPressed=false;
    }
}
