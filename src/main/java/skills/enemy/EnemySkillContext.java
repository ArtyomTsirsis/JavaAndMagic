package skills.enemy;

import repository.enemy.Enemy;
import repository.hero.Hero;

public class EnemySkillContext {

    private EnemySkill enemySkill;

    public void setStrategy(EnemySkill enemySkill) {
        this.enemySkill = enemySkill;
    }

    public String useSkill(Hero hero, Enemy enemy) {
        return enemySkill.execute(hero, enemy);
    }

}