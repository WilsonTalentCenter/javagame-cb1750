import java.awt.*;

/**
 * Created by cb1750 on 11/9/2022.
 */
public class Collision {



    public Collision( Player player, Player player2, GameBall ball){
    }





    //These return true if there is a collision between the ball and a player
    public static int player1HasCollided(Player player){
         if(player.getHitBox().intersects(GameBall.getHitBox())){
             if((player.getHitBox().y + 100) - GameBall.getHitBox().y > 16){ // If ball hits top half of paddle
                 return 0;
             }
             if((player.getHitBox().y + 100) - GameBall.getHitBox().y < -16 ){ //If ball hits bottom half of paddle
                 return 1;
             }
             else
                 return 2; //If ball hits middle of paddle

         }
         else
             return 3;
    }
    public static int player2HasCollided(Player2 player2){
        if(player2.getHitBox().intersects(GameBall.getHitBox())){
            if((player2.getHitBox().y + 100) - GameBall.getHitBox().y > 16){ // If ball hits top half of paddle
                return 0;
            }
            if((player2.getHitBox().y + 100) - GameBall.getHitBox().y < -16 ){ // If ball hits bottom half of paddle
                return 1;
            }
            else
                return 2; //If ball hits middle of paddle

        }
        else
            return 3;


    }
    public static int aiHasCollided(AI ai){
        if(ai.getHitBox().intersects(GameBall.getHitBox())){
            if((ai.getHitBox().y + 100) - GameBall.getHitBox().y > 16){ // If ball hits top half of paddle
                return 0;
            }
            if((ai.getHitBox().y + 100) - GameBall.getHitBox().y < -17 ){ //If ball hits bottom half of paddle
                return 1;
            }
            else
                return 2; //If ball hits middle of paddle

        }
        else
            return 3;




    }


}
