import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by cb1750 on 11/9/2022.
 */
public class GameBall {
    private Rectangle hitBox;
    private BufferedImage sprite;
    static int xSpeed = 4;
    static int ySpeed = 0;

    public GameBall(){
        hitBox = new Rectangle(1000,500,50,50);
        try {
            sprite = ImageIO.read(new File("src/resources/ball2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void update(InputManager inputManager, Player player, Player2 player2, GameBall ball){
        //region movement


        if(Collision.player1HaveCollided(player,ball)==1){
            xSpeed = 8;
            ySpeed = -2;
        }
        else if(Collision.player2HaveCollided(player2,ball)==1){
            xSpeed = -8;
            ySpeed = -2;
        }
        else if(Collision.player1HaveCollided(player,ball)==2){
            xSpeed = 8;
            ySpeed = -1;
        }
        else if(Collision.player2HaveCollided(player2,ball)==2){
            xSpeed = -8;
            ySpeed = 1;
        }
        else if(Collision.player1HaveCollided(player,ball)==3){
            xSpeed = 8;
            ySpeed = 2;
        }
        else if(Collision.player2HaveCollided(player2,ball)==3){
            xSpeed = -8;
            ySpeed = 2;
        }





        hitBox.x += xSpeed;

        hitBox.y += ySpeed;

        //endregion
        //region collision

        //endregion

    }
    public Rectangle getHitbox(){
        return hitBox;
    }

    public void draw(Graphics g){
        //draw sprite example
        g.drawImage(sprite, hitBox.x,hitBox.y,hitBox.width,hitBox.height,null);

    }
}
