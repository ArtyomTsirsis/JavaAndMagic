package skills;

import enemy.Enemy;
import hero.Hero;

public interface Strategy {

    Pair execute(Hero hero, Enemy enemy);

}
