package com.game.skills.hero;

import com.game.dto.hero.HeroDTO;
import com.game.domain.enemy.Enemy;
import lombok.Data;

@Data
public class ConcreteHeroSkillPowerAttack implements HeroSkill {

    private static final HeroCriticalHitOrMissCalculator CRITICAL_HIT_OR_MISS_CALCULATOR_CONTEXT = new HeroCriticalHitOrMissCalculator();
    private final String name = "PowerAttack";
    private int criticalHitChance = 7;
    private int missChance = 10;

    @Override
    public String execute(HeroDTO hero, Enemy enemy) {
        int criticalHitOrMissCoefficient = CRITICAL_HIT_OR_MISS_CALCULATOR_CONTEXT.
                getCriticalHitOrMissCoefficient(hero, enemy, this);
        int damage = ((hero.getStrength() * hero.getLevel() + (hero.getWeapon().getPhysicalDamage() *
                hero.getWeapon().getLevel() - enemy.getPhysicalDefense()) + (hero.getWeapon().getMagicalDamage() *
                hero.getWeapon().getLevel() - enemy.getMagicalDefense()))) * criticalHitOrMissCoefficient * 2;
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
