import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
/**
 * Created by cb1750 on 11/9/2022.
 */
public class GameBall {
    private static Rectangle hitBox;
    private BufferedImage sprite;
    private static int xSpeed;
     private static int ySpeed;
    static int p1Score = 0;
    static int p2Score = 0;

    public GameBall(){
        hitBox = new Rectangle(950,500,50,50);

        try {
            sprite = ImageIO.read(new File("src/resources/ball2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void pvaUpdate(InputManager inputManager, AI ai, Player player, GameBall ball){

        Random rd = new Random();
        //region movement
        if (inputManager.space.isPressed()){ //Moves ball only when a player presses space
            if(rd.nextBoolean())
                xSpeed = 4;
            else
                xSpeed = -4;

        }
        //If there is a collision this makes the ball faster and makes it move toward the other player
        if(Collision.player1HaveCollided(player,ball)){
            xSpeed = (Math.abs(xSpeed)+1);
            if(ySpeed == Math.abs(ySpeed))
                ySpeed = (Math.abs(ySpeed)+1);
            else
                ySpeed = -(Math.abs(ySpeed)+1);

        }if(Collision.aiHaveCollided(ai,ball)){
            xSpeed = -(Math.abs(xSpeed)+1);
            if(ySpeed == Math.abs(ySpeed))
                ySpeed = (Math.abs(ySpeed)+1);
            else
                ySpeed = -(Math.abs(ySpeed)+1);
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

        if(hitBox.x < 0){ //When P2 scores, resets the ball and adds to score
            hitBox.x = 1000;
            hitBox.y = 500;
            ySpeed = 0;
            xSpeed = 0;
            p2Score++;
        }
        else if(hitBox.x > 2000){ //When P1 scores, resets the ball and adds to score
            hitBox.x = 1000;
            hitBox.y = 500;
            ySpeed = 0;
            xSpeed = 0;
            p1Score++;
        }




        hitBox.x += xSpeed;

        hitBox.y += ySpeed;



        //endregion
        //region collision

        //endregion
    }
    public void pvpUpdate(InputManager inputManager, Player player, Player2 player2, GameBall ball){
        Random rd = new Random();
        //region movement
        if (inputManager.space.isPressed()){ //Moves ball only when a player presses space
               if(rd.nextBoolean())
                   xSpeed = 4;
               else
                   xSpeed = -4;

        }
        //If there is a collision this makes the ball faster and makes it move toward the other player
        if(Collision.player1HaveCollided(player,ball)){
            xSpeed = (Math.abs(xSpeed)+1);
            if(ySpeed == Math.abs(ySpeed))
            ySpeed = (Math.abs(ySpeed)+1);
            else
                ySpeed = -(Math.abs(ySpeed)+1);

        }
        else if(Collision.player2HaveCollided(player2,ball)){
            xSpeed = -(Math.abs(xSpeed)+1);
            if(ySpeed == Math.abs(ySpeed))
                ySpeed = (Math.abs(ySpeed)+1);
            else
                ySpeed = -(Math.abs(ySpeed)+1);
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

        if(hitBox.x < 0){ //When P2 scores, resets the ball and adds to score
            hitBox.x = 1000;
            hitBox.y = 500;
            ySpeed = 0;
            xSpeed = 0;
            p2Score++;
        }
        else if(hitBox.x > 2000){ //When P1 scores, resets the ball and adds to score
            hitBox.x = 1000;
            hitBox.y = 500;
            ySpeed = 0;
            xSpeed = 0;
            p1Score++;
        }




        hitBox.x += xSpeed;

        hitBox.y += ySpeed;



        //endregion
        //region collision

        //endregion

    }

    public static Rectangle getHitBox(){
        return hitBox;
    }
    public static int getXSpeed(){return xSpeed;}
    public static int getYSpeed(){return ySpeed;}

    public void draw(Graphics g){
        //draw sprite example
        g.drawImage(sprite, hitBox.x,hitBox.y,hitBox.width,hitBox.height,null);

    }

}
