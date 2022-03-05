package skills.enemy;

import repository.enemy.Enemy;
import repository.hero.Hero;

public interface EnemySkill {

    String execute(Hero hero, Enemy enemy);
    String getName();
    int getCriticalHitChance();
    int getMissChance();

}

