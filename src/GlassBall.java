import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


/**
 * Created by cb1750 on 11/21/2022.
 */
public class GlassBall {
    private static Rectangle hitBox;
    private BufferedImage sprite;
    private static int xSpeed;
    private static int ySpeed;
    public GlassBall(){

            hitBox = new Rectangle(950,450,50,50);
        try {
            sprite = ImageIO.read(new File("src/resources/red.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        }

        public void update(InputManager inputManager, Player player, GameBall ball){


            if(Collision.player1HaveCollided(player,ball) == 0 ||Collision.player1HaveCollided(player,ball) == 1 ||
                    Collision.player1HaveCollided(player,ball) == 2) {

                hitBox.x = GameBall.getHitBox().x;
                hitBox.y = GameBall.getHitBox().y;


                xSpeed = (Math.abs(GameBall.getXSpeed())*3);
                ySpeed = (GameBall.getYSpeed()*3);
//
            }



            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int height =(int) screenSize.getHeight();

            if(hitBox.y < 0){
                ySpeed *=-1 ;
            }
            //These make sure the ball doesn't leave the screen
            //It just bounces back
            if(hitBox.y + hitBox.height > height){
                ySpeed *= -1;
            }
            if(hitBox.x > 1800 || hitBox.x < 0){
                xSpeed = 0;
                ySpeed = 0;
            }
            if(inputManager.space.isPressed()){
                hitBox.x = 950;
                hitBox.y = 450;
            }



            hitBox.x += xSpeed;

            hitBox.y += ySpeed;



        }
    public void draw(Graphics g){
        //draw sprite example
        g.drawImage(sprite, hitBox.x,hitBox.y,hitBox.width,hitBox.height,null);

    }
    public static Rectangle getHitBox(){
        return hitBox;
    }


    }

