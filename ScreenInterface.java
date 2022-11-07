import javax.swing.*;
import java.awt.*;

/**
 * Created by dbaker on 1/8/2022.
 */
interface ScreenInterface {
    void unload(JPanel panel);
    void load(JPanel panel);
    void remove();
    void update();
    void draw(Graphics g);

}
