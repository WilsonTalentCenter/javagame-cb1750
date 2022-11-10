import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;


/**
 * Created by cb1750 on 11/9/2022.
 */
public class Collision {
    private Rectangle hitBox;
    private BufferedImage sprite;

    public Collision( Player player, Player player2, GameBall ball){


        }

    public static int player1HaveCollided(Player player, GameBall ball){
        if (player.getHitbox().intersects(ball.getHitbox())){
            if (player.getHitbox().getY() >= 200 ){
                return 1;  //Returns 1 if ball hits top of rectangle
            }
            else if (player.getHitbox().getY() >= 400  ){
                return 2; //Returns 2 if ball hits middle of rectangle
            }
            else{
                return 3;  //Returns 3 if ball hits bottom of rectangle
            }
        }
        else{
            return 0;
        }

    }
    public static int player2HaveCollided( Player2 player2, GameBall ball){
        if (player2.getHitbox().intersects(ball.getHitbox())){
            if (player2.getHitbox().getY() >= 200 ){
                return 1;  //Returns 1 if ball hits top of rectangle
            }
            else if (player2.getHitbox().getY() >= 400  ){
                return 2; //Returns 2 if ball hits middle of rectangle
            }
            else{
                return 3;  //Returns 3 if ball hits bottom of rectangle
            }
        }
        else {
            return 0;
        }

    }


}
