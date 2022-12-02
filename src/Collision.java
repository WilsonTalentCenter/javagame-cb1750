import java.awt.*;

/**
 * Created by cb1750 on 11/9/2022.
 */
public class Collision {



    public Collision( Player player, Player player2, GameBall ball){
    }





    //These return true if there is a collision between the ball and a player
    public static int player1HaveCollided(Player player, GameBall ball){
         if(player.getHitBox().intersects(GameBall.getHitBox())){
             if(player.getHitBox().y - GameBall.getHitBox().y > 25){ //If ball hits top half of paddle
                 return 0;
             }
             else if(player.getHitBox().y - GameBall.getHitBox().y < -125 ){ // If ball hits bottom half of paddle
                 return 1;
             }
             else
                 return 2; //If ball hits middle of paddle

         }
         else
             return 3;
    }
    public static boolean player2HaveCollided( Player2 player2, GameBall ball){
        return player2.getHitBox().intersects(ball.getHitBox());


    }
    public static boolean aiHaveCollided( AI ai, GameBall ball){
        return ai.getHitBox().intersects(ball.getHitBox());




    }


}
