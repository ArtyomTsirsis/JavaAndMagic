package skills.enemy;

import repository.enemy.Enemy;
import repository.hero.Hero;

public class ConcreteEnemySkillAttack implements EnemySkill {

    @Override
    public String execute(Hero hero, Enemy enemy) {

        return "Враг наносит вам урон Х";
    }

}
