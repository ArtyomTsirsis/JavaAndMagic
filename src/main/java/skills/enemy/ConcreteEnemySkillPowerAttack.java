package skills.enemy;

import repository.enemy.Enemy;
import repository.hero.Hero;

public class ConcreteEnemySkillPowerAttack implements EnemySkill {

    @Override
    public String execute(Hero hero, Enemy enemy) {

        return "Враг нанес вам урон Х ОЗ мощной атакой";
    }

}
