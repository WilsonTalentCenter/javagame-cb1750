/**
 * Created by cb1750 on 11/9/2022.
 */
public class Collision {



    public Collision( Player player, Player player2, GameBall ball){
    }





    //These return true if there is a collision between the ball and a player
    public static boolean player1HaveCollided(Player player, GameBall ball){
        return player.getHitBox().intersects(ball.getHitBox());


    }
    public static boolean player2HaveCollided( Player2 player2, GameBall ball){
        return player2.getHitBox().intersects(ball.getHitBox());


    }


}
