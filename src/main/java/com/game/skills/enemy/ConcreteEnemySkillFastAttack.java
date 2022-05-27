package com.game.skills.enemy;

import com.game.dto.hero.HeroDTO;
import com.game.domain.enemy.Enemy;
import lombok.Data;

@Data
public class ConcreteEnemySkillFastAttack implements EnemySkill {

    private static final EnemyCriticalHitOrMissCalculator CRITICAL_HIT_OR_MISS_CALCULATOR_CONTEXT = new EnemyCriticalHitOrMissCalculator();
    private final String name = "FastAttack";
    private int criticalHitChance = 0;
    private int missChance = 0;

    @Override
    public String execute(HeroDTO hero, Enemy enemy) {
        int criticalHitOrMissCoefficient = CRITICAL_HIT_OR_MISS_CALCULATOR_CONTEXT
                .getCriticalHitOrMissCoefficient(hero, enemy, this);
        int damage = ((enemy.getPhysicalDamage() - hero.getArmor().getPhysicalDefense()) +
                (enemy.getMagicalDamage() - hero.getArmor().getMagicalDefense())) * criticalHitOrMissCoefficient;
        hero.increaseLevel();
        if (0 >= damage) {
            return "Вы отразили атаку";
        } else if (damage >= enemy.getHealth()) {
            hero.setHealth(0);
            return "Вы получили урон " + damage +" ОЗ. Поражение!";
        }
        hero.setHealth(hero.getHealth() - damage);
        return switch (criticalHitOrMissCoefficient) {
            case 0 -> "Промах!";
            case 2 -> "Критическое попадание! Вы получили урон " + damage + " ОЗ.";
            default -> "Вы получили урон " + damage + " ОЗ.";
        };
    }

}
