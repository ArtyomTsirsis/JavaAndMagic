package battle;

import repository.enemy.Orc;
import repository.hero.Knight;

public class InnerLazyMain {

    public static void main(String[] args) {

        // Локальная визуализаторная, у Паши в одном из UI сбой и я хз почему, просто удалить временно его комент -
        // ( //    Long id; надо переделать на ИД)

        Battle battle = new Battle(new Knight("Rex"), new Orc());
        battle.fightSimulator();
    }
}
