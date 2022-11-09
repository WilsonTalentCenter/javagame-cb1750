import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;



/**
 * Created by cb1750 on 11/9/2022.
 */
public class Collision {
    private Rectangle hitBox;
    private BufferedImage sprite;

    public Collision( Player player, Player player2, GameBall ball){


        }

    public static boolean player1HaveCollided(Player player, GameBall ball){
        return (player.getHitbox().intersects(ball.getHitbox()));

    }
    public static boolean player2HaveCollided( Player2 player2, GameBall ball){
        return (player2.getHitbox().intersects(ball.getHitbox()));

    }

}
