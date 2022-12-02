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
    private int ySpeed = 0;
    public AI(){
        hitBox = new Rectangle(1800,450,25,200);
        try {
            sprite = ImageIO.read(new File("src/resources/red.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void update(){


    if(hitBox.y < GlassBall.getHitBox().y){
        ySpeed = 4;
    }
    else if(hitBox.y > GlassBall.getHitBox().y) {
        ySpeed = -4;
    }







        hitBox.y += ySpeed;




        if(hitBox.y<0){
            hitBox.y=0;
        }
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height =(int) screenSize.getHeight();
        if(hitBox.y + hitBox.height > height){
            hitBox.y = height - hitBox.height;
        }
    }
    public void draw(Graphics g){
        //draw sprite example
        g.drawImage(sprite, hitBox.x,hitBox.y,hitBox.width,hitBox.height,null);

    }
    public Rectangle getHitBox(){
        return hitBox;
    }
}
