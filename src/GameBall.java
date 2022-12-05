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
     static boolean bounce = false;
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
        hitBox.x += xSpeed;

        hitBox.y += ySpeed;

        Random rd = new Random();
        //region movement
        if (inputManager.space.isPressed()){ //Moves ball only when a player presses space
            if(rd.nextBoolean())
                xSpeed = 6;
            else
                xSpeed = -6;

        }
        //If there is a collision this makes the ball faster and makes it move toward the other player
        if(Collision.player1HasCollided(player)==0){
            xSpeed = (Math.abs(xSpeed)+1);
            ySpeed = -(Math.abs(ySpeed)+1);

        }
        else if(Collision.player1HasCollided(player)==1){
            xSpeed = (Math.abs(xSpeed)+1);
            ySpeed = Math.abs(ySpeed)+1;

        }
        else if(Collision.player1HasCollided(player)==2){
            xSpeed = (Math.abs(xSpeed)+1);
            ySpeed = 0;
        }
        if(Collision.aiHasCollided(ai)==0){
            xSpeed = -(Math.abs(xSpeed)+1);
            ySpeed = -(Math.abs(ySpeed)+1);

        }
        else if(Collision.aiHasCollided(ai)==1){
            xSpeed = -(Math.abs(xSpeed)+1);
            ySpeed = Math.abs(ySpeed)+1;

        }
        else if(Collision.aiHasCollided(ai)==2){
            xSpeed = -(Math.abs(xSpeed)+1);
            ySpeed = 0;
        }



        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height =(int) screenSize.getHeight();

        if(hitBox.y < 0){
            bounce = true;
            ySpeed *=-1;
        }
        else{
            bounce = false;
        }
        //These make sure the ball doesn't leave the screen
        //It just bounces back
        if(hitBox.y + hitBox.height > height){
            bounce = true;
            ySpeed *= -1;
        }
        else{
            bounce = false;
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







        //endregion
        //region collision

        //endregion
    }
    public void pvpUpdate(InputManager inputManager, Player player, Player2 player2, GameBall ball){
        Random rd = new Random();
        //region movement
        if (inputManager.space.isPressed()){ //Moves ball only when a player presses space
               if(rd.nextBoolean())
                   xSpeed = 6;
               else
                   xSpeed = -6;

        }
        //If there is a collision this makes the ball faster and makes it move toward the other player
        if(Collision.player1HasCollided(player)==0){
            xSpeed = (Math.abs(xSpeed)+1);
            ySpeed = -(Math.abs(ySpeed)+1);

        }
        else if(Collision.player1HasCollided(player)==1){
            xSpeed = (Math.abs(xSpeed)+1);
            ySpeed = Math.abs(ySpeed)+1;

        }
        else if(Collision.player1HasCollided(player)==2){
            xSpeed = (Math.abs(xSpeed)+1);
            ySpeed = 0;
        }
        if(Collision.player2HasCollided(player2)==0){
            xSpeed = -(Math.abs(xSpeed)+1);
            ySpeed = -(Math.abs(ySpeed)+1);

        }
        else if(Collision.player2HasCollided(player2)==1){
            xSpeed = -(Math.abs(xSpeed)+1);
            ySpeed = Math.abs(ySpeed)+1;

        }
        else if(Collision.player2HasCollided(player2)==2){
            xSpeed = -(Math.abs(xSpeed)+1);
            ySpeed = 0;
        }

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height =(int) screenSize.getHeight();

        if(hitBox.y < 0){
            ySpeed *= -1;
        }
        //These make sure the ball doesn't leave the screen
        //It just bounces back
        if(hitBox.y + hitBox.height > height){
            ySpeed *= -1;
        }

        if(hitBox.x < 0){ //When P2 scores, resets the ball and adds to score
            hitBox.x = 1000;
            hitBox.y = 500;
            GlassBall.getHitBox().x = 950;
            GlassBall.getHitBox().y = 450;
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
