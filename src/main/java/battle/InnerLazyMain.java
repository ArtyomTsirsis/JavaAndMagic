package battle;

import repository.enemy.Orc;
import repository.hero.Knight;

public class InnerLazyMain {

    public static void main(String[] args) {

        Battle battle = new Battle(new Knight("Rex"), new Orc());
        battle.fightSimulator();
    }
}
