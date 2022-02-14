package skills;

import enemy.Enemy;
import hero.Hero;

public class ConcreteStrategyFireDamage implements Strategy {

    @Override
    public Pair execute(Hero hero, Enemy enemy) {

        return new Pair(hero, enemy);
    }

}
