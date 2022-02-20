package skills.enemy;

import repository.enemy.Enemy;
import repository.hero.Hero;

public class ConcreteEnemySkillBlock implements EnemySkill {

    @Override
    public String execute(Hero hero, Enemy enemy) {

        return "Эта хрен будет чем-то другим";
    }

}
