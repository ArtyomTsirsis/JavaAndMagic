package com.game.skills.hero;

import com.game.dto.hero.HeroDTO;
import com.game.domain.enemy.Enemy;
import lombok.Data;

@Data
public class ConcreteHeroSkillAttackWOWeapon implements HeroSkill {

    private static final HeroCriticalHitOrMissCalculator CRITICAL_HIT_OR_MISS_CALCULATOR_CONTEXT = new HeroCriticalHitOrMissCalculator();
    private final String name = "AttackWOWeapon";
    private int criticalHitChance = 0;
    private int missChance = 0;

    @Override
    public String execute(HeroDTO hero, Enemy enemy) {
        int criticalHitOrMissCoefficient = CRITICAL_HIT_OR_MISS_CALCULATOR_CONTEXT
                .getCriticalHitOrMissCoefficient(hero, enemy, this);
        int damage = hero.getStrength() * hero.getLevel() * criticalHitOrMissCoefficient;
        hero.increaseLevel();
        hero.getWeapon().increaseLevel();
        if (0 >= damage) {
            return "Enemy has blocked your Attack";
        } else if (damage >= enemy.getHealth()) {
            enemy.setHealth(0);
            return "You've damaged " + damage +" HP. WIN!";
        }
        enemy.setHealth(enemy.getHealth() - damage);
        return switch (criticalHitOrMissCoefficient) {
            case 0 -> "MISS!";
            case 2 -> "Critical Attack. You've damaged " + damage + " HP.";
            default -> "You've damaged " + damage + " HP.";
        };
    }

}
