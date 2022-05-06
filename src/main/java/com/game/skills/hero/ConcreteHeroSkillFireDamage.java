package com.game.skills.hero;

import com.game.dto.hero.HeroDTO;
import com.game.repository.enemy.Enemy;
import lombok.Data;

@Data
public class ConcreteHeroSkillFireDamage implements HeroSkill {

    private static final HeroCriticalHitOrMissCalculator CRITICAL_HIT_OR_MISS_CALCULATOR_CONTEXT = new HeroCriticalHitOrMissCalculator();
    private final String name = "FireDamage";
    private final String output = "Атака огнем";
    private int criticalHitChance = 0;
    private int missChance = -5;

    @Override
    public String execute(HeroDTO hero, Enemy enemy) {
        int criticalHitOrMissCoefficient = CRITICAL_HIT_OR_MISS_CALCULATOR_CONTEXT.
                getCriticalHitOrMissCoefficient(hero, enemy, this);
        int damage = hero.getStrength() * hero.getLevel() + (hero.getWeapon().getMagicalDamage() *
                hero.getWeapon().getLevel() - enemy.getMagicalDefense()) * criticalHitOrMissCoefficient;
        hero.increaseLevel();
        hero.getWeapon().increaseLevel();
        if (0 >= damage) {
            return "Враг отразил атаку";
        } else if (damage >= enemy.getHealth()) {
            return "Вы нанесли урон " + damage +" ОЗ. Победа!";
        }
        enemy.setHealth(enemy.getHealth() - damage);
        return switch (criticalHitOrMissCoefficient) {
            case 0 -> "Промах!";
            case 2 -> "Критическое попадание! Вы нанесли урон " + damage + " ОЗ.";
            default -> "Вы нанесли урон " + damage + " ОЗ.";
        };
    }

}
