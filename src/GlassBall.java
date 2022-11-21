import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by cb1750 on 11/21/2022.
 */
public class GlassBall {
    private Rectangle hitBox;
    private BufferedImage sprite;
    private static int xSpeed;
    private static int ySpeed;
    public static int xPos;
    public static int yPos;
    public GlassBall(){

            hitBox = new Rectangle(0,0,50,50);
            if(GameBall.getYSpeed() == Math.abs(GameBall.getYSpeed()))
                ySpeed = (Math.abs(GameBall.getYSpeed())+10);
            else
                ySpeed = -(Math.abs(GameBall.getYSpeed())+10);
            xSpeed = -(Math.abs(GameBall.getXSpeed())+10);
        }

        public void update(Player player, GameBall ball){
        if(Collision.player1HaveCollided(player,ball)) {
            hitBox.x = GameBall.getHitBox().x;
            hitBox.y = GameBall.getHitBox().y;

            xSpeed = -(Math.abs(xSpeed) + 10);
            if (ySpeed == Math.abs(ySpeed))
                ySpeed = (Math.abs(ySpeed) + 10);
            else
                ySpeed = -(Math.abs(ySpeed) + 10);


        }
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int height =(int) screenSize.getHeight();

            if(hitBox.y < 0){
                ySpeed = 18;
            }
            //These make sure the ball doesn't leave the screen
            //It just bounces back
            if(hitBox.y + hitBox.height > height){
                ySpeed = -18;
            }
        if(hitBox.x > 2000 || hitBox.x < 0){
            xPos = hitBox.x;
            yPos = hitBox.y;
        }


        }


    }

