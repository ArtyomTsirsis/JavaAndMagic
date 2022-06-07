package com.game.skills.hero;

import com.game.dto.hero.HeroDTO;
import com.game.domain.enemy.Enemy;
import lombok.Data;

@Data
public class ConcreteHeroSkillShoot implements HeroSkill {

    private static final HeroCriticalHitOrMissCalculator CRITICAL_HIT_OR_MISS_CALCULATOR_CONTEXT = new HeroCriticalHitOrMissCalculator();
    private final String name = "Shoot";
    private int criticalHitChance = 10;
    private int missChance = 0;

    @Override
    public String execute(HeroDTO hero, Enemy enemy) {
        int criticalHitOrMissCoefficient = CRITICAL_HIT_OR_MISS_CALCULATOR_CONTEXT.
                getCriticalHitOrMissCoefficient(hero, enemy, this);
        int damage = ((hero.getStrength() * hero.getLevel() + (hero.getWeapon().getPhysicalDamage() *
                hero.getWeapon().getLevel() - enemy.getPhysicalDefense()) + (hero.getWeapon().getMagicalDamage() *
                hero.getWeapon().getLevel() - enemy.getMagicalDefense()))) * criticalHitOrMissCoefficient;
        hero.increaseLevel();
        hero.getWeapon().increaseLevel();
        if (0 >= damage && criticalHitOrMissCoefficient != 0) {
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
