import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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

            hitBox = new Rectangle(950,500,50,50);
        try {
            sprite = ImageIO.read(new File("src/resources/red.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        }

        public void update(Player player, GameBall ball){
        if(Collision.player1HaveCollided(player,ball)) {
            hitBox.x = GameBall.getHitBox().x;
            hitBox.y = GameBall.getHitBox().y;

            xSpeed = GameBall.getXSpeed()*-1;
            ySpeed = GameBall.getYSpeed();


        }
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int height =(int) screenSize.getHeight();

            if(hitBox.y < 0){
                ySpeed = 8;
            }
            //These make sure the ball doesn't leave the screen
            //It just bounces back
            if(hitBox.y + hitBox.height > height){
                ySpeed = -8;
            }
        if(hitBox.x > 2000 || hitBox.x < 0){
            xPos = hitBox.x;
            yPos = hitBox.y;
        }
            hitBox.x += xSpeed;

            hitBox.y += ySpeed;



        }
    public void draw(Graphics g){
        //draw sprite example
        g.drawImage(sprite, hitBox.x,hitBox.y,hitBox.width,hitBox.height,null);

    }


    }

