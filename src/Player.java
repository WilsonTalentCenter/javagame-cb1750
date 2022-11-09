import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by dbaker on 1/8/2022.
 */
public class Player {
    private Rectangle hitBox;
    private BufferedImage sprite;



    public Player(){
        hitBox = new Rectangle(100,600,25,400);
        try {
            sprite = ImageIO.read(new File("src/resources/player.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public Player(int x,int y,int width,int height){
        hitBox = new Rectangle(x,y,width,height);
        try {
            sprite = ImageIO.read(new File("src/resources/player.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void update(InputManager inputManager){
        //region movement
        int ySpeed = 0;
        if(inputManager.p1down.isPressed()){
            ySpeed =4;
        }else if(inputManager.p1up.isPressed()){
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
