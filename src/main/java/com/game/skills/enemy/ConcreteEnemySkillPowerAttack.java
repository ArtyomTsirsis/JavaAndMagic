package com.game.skills.enemy;

import com.game.repository.enemy.Enemy;
import lombok.Data;
import com.game.repository.hero.Hero;

@Data
public class ConcreteEnemySkillPowerAttack implements EnemySkill {

    private static final EnemyCriticalHitOrMissCalculator CRITICAL_HIT_OR_MISS_CALCULATOR_CONTEXT = new EnemyCriticalHitOrMissCalculator();
    private final String name = "Мощная атака";
    private int criticalHitChance = 5;
    private int missChance = 7;

    @Override
    public String execute(Hero hero, Enemy enemy) {
        int criticalHitOrMissCoefficient = CRITICAL_HIT_OR_MISS_CALCULATOR_CONTEXT.
                getCriticalHitOrMissCoefficient(hero, enemy, this);
        int damage = ((enemy.getPhysicalDamage() - hero.getArmor().getPhysicalDefense()) +
                (enemy.getMagicalDamage() - hero.getArmor().getMagicalDefense())) * criticalHitOrMissCoefficient * 2;
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