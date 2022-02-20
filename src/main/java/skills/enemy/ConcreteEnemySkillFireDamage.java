package skills.enemy;

import repository.enemy.Enemy;
import repository.hero.Hero;

public class ConcreteEnemySkillFireDamage implements EnemySkill {

    @Override
    public String execute(Hero hero, Enemy enemy) {

        return "Враг наносит урон огнем - Х";
    }

}
