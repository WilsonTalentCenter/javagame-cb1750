import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by cb1750 on 11/18/2022.
 */
public class AI {
    private Rectangle hitBox;
    private BufferedImage sprite;

    public AI(){
        hitBox = new Rectangle(1800,450,25,200);
        try {
            sprite = ImageIO.read(new File("src/resources/red.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void update(){

    }
    public void draw(Graphics g){
        //draw sprite example
        g.drawImage(sprite, hitBox.x,hitBox.y,hitBox.width,hitBox.height,null);

    }
}
