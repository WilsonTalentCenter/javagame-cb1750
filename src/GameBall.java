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
    private Rectangle hitBox;
    private BufferedImage sprite;
    static int xSpeed = 0;
    static int ySpeed = 0;
    static int p1Score = 0;
    static int p2Score = 0;

    public GameBall(){
        hitBox = new Rectangle(1000,500,50,50);
        try {
            sprite = ImageIO.read(new File("src/resources/ball2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void update(InputManager inputManager, Player player, Player2 player2, GameBall ball){
        Random rd = new Random();
        //region movement
        if (inputManager.space.isPressed()){ //Moves ball only when a player presses space
               if(rd.nextBoolean())
                   xSpeed = 4;
               else
                   xSpeed = -4;

        }

        if(Collision.player1HaveCollided(player,ball)==1){ //1 means to collided on the top half of the paddle
            xSpeed = 8;
            ySpeed = -2;
        }
        else if(Collision.player2HaveCollided(player2,ball)==1){
            xSpeed = -8;
            ySpeed = -2;
        }
        else if(Collision.player1HaveCollided(player,ball)==2){ //2 means to collided on the top half of the paddle
            xSpeed = 8;
            ySpeed = -1;
        }
        else if(Collision.player2HaveCollided(player2,ball)==2){
            xSpeed = -8;
            ySpeed = 1;
        }
        else if(Collision.player1HaveCollided(player,ball)==3){ //3 means to collided on the top half of the paddle
            xSpeed = 8;
            ySpeed = 2;
        }
        else if(Collision.player2HaveCollided(player2,ball)==3){
            xSpeed = -8;
            ySpeed = 2;
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

        if(hitBox.x < 0){ //When P2 scores
            hitBox.x = 1000;
            hitBox.y = 500;
            ySpeed = 0;
            xSpeed = 0;
            p2Score++;
        }
        else if(hitBox.x > 2000){ //When P1 scores
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
    public Rectangle getHitBox(){
        return hitBox;
    }

    public void draw(Graphics g){
        //draw sprite example
        g.drawImage(sprite, hitBox.x,hitBox.y,hitBox.width,hitBox.height,null);

    }

}
