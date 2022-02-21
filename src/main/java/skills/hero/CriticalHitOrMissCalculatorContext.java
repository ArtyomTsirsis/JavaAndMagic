package skills.hero;

import repository.enemy.Enemy;
import repository.hero.Hero;

import java.util.Random;

public class CriticalHitOrMissCalculatorContext {

    private static final Random r = new Random();

    public int getCriticalHitOrMissCoefficient(Hero hero, Enemy enemy) {
        if (r.nextInt(100) <= hero.getWeapon().getCriticalHitChance() ) {
            return 2;
        } else if (r.nextInt(100) > (hero.getDexterity() - enemy.getDexterity() + 80)) {
            return 0;
        } else {
            return 1;
        }
    }

}
