import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by dbaker on 1/8/2022.
 */
public class Player2 {
    private Rectangle hitBox;
    private BufferedImage sprite;



    public Player2(){
        hitBox = new Rectangle(1800,600,25,200);
        try {
            sprite = ImageIO.read(new File("src/resources/white.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void update(InputManager inputManager){
        //region movement
        int ySpeed = 0;
        if(inputManager.p2down.isPressed()){
            ySpeed =4;
        }else if(inputManager.p2up.isPressed()){
            ySpeed =-4;
        }
        int xSpeed = 0;
        /*if(inputManager.left.isPressed()){
            xSpeed =-4;
        }else if(inputManager.right.isPressed()){
            xSpeed = 4;
        }
        hitBox.x += xSpeed;
        */
        hitBox.y += ySpeed;

        //endregion
        //region collision

        //endregion

    }
    public void draw(Graphics g){
        //draw sprite example
        g.drawImage(sprite, hitBox.x,hitBox.y,hitBox.width,hitBox.height,null);

    }
    public Rectangle getHitbox(){
        return hitBox;
    }
}
