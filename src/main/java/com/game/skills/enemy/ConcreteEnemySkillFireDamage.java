package com.game.skills.enemy;

import com.game.repository.stuff.enemy.Enemy;
import lombok.Data;
import com.game.repository.hero.Hero;

@Data
public class ConcreteEnemySkillFireDamage implements EnemySkill {

    private static final EnemyCriticalHitOrMissCalculator CRITICAL_HIT_OR_MISS_CALCULATOR_CONTEXT = new EnemyCriticalHitOrMissCalculator();
    private final String name = "Атака огнем";
    private int criticalHitChance = 0;
    private int missChance = -7;

    @Override
    public String execute(Hero hero, Enemy enemy) {
        int criticalHitOrMissCoefficient = CRITICAL_HIT_OR_MISS_CALCULATOR_CONTEXT.
                getCriticalHitOrMissCoefficient(hero, enemy, this);
        int damage = (enemy.getMagicalDamage() - hero.getArmor().getMagicalDefense()) * criticalHitOrMissCoefficient;
        hero.increaseLevel();
        if (0 >= damage) {
            return "Вы отразил атаку";
        } else if (damage >= enemy.getHealth()) {
            return "Вы получили урон " + damage +" ОЗ. Поражение!";
        }
        enemy.setHealth(enemy.getHealth() - damage);
        switch (criticalHitOrMissCoefficient) {
            case 0:
                return "Промах!";
            case 2:
                return "Критическое попадание! Вы получили урон " + damage + " ОЗ.";
        }
        return "Вы получили урон " + damage + " ОЗ.";
    }

}
