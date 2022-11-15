import java.awt.*;


/**
 * Created by cb1750 on 11/9/2022.
 */
public class Collision {
    private static Rectangle upperHitBox;
    private static Rectangle lowerHitBox;


    public Collision( Player player, Player player2, GameBall ball){
        upperHitBox = new Rectangle(0,0,2500,100);
        lowerHitBox = new Rectangle(0,1000,2500,-100);

    }






    public static int player1HaveCollided(Player player, GameBall ball){
        if (player.getHitBox().intersects(ball.getHitBox())){
            if (player.getHitBox().getY() <= 200 ){
                return 1;  //Returns 1 if ball hits top of rectangle
            }
            else if (player.getHitBox().getY() <= 400  ){
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
        if (player2.getHitbox().intersects(ball.getHitBox())){
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
