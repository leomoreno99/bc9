package lmoreno.fighters;

public class Winner {
    public static String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {
        int health1 = fighter1.health;
        int health2 = fighter2.health;
        String winner;

        boolean turn = true;

        if(firstAttacker == fighter1.name){
            turn = false;
        }

        while (health1 > 0 && health2 > 0){
            if(turn){
                health1 -= fighter2.damagePerAttack;
                turn = false;
            } else {
                health2 -= fighter1.damagePerAttack;
                turn = true;
            }
        }

        if(health1 <= 0)
            winner = fighter2.name;
        else
            winner = fighter1.name;

        return winner;
    }
}