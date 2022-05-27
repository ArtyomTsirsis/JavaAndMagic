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
        if (0 >= damage && criticalHitOrMissCoefficient != 0) {
            return "You've blocked Attack";
        } else if (damage >= enemy.getHealth()) {
            hero.setHealth(0);
            return "You've got damage " + damage +" HP. Defeat!";
        }
        hero.setHealth(hero.getHealth() - damage);
        return switch (criticalHitOrMissCoefficient) {
            case 0 -> "Miss!";
            case 2 -> "Critical Damage! You've got damage " + damage + " HP.";
            default -> "You've got damage " + damage + " HP.";
        };
    }

}
