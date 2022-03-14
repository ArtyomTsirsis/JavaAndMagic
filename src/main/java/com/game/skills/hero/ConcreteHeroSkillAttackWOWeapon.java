package com.game.skills.hero;

import com.game.repository.stuff.enemy.Enemy;
import lombok.Data;
import com.game.repository.hero.Hero;

@Data
public class ConcreteHeroSkillAttackWOWeapon implements HeroSkill {

    private static final HeroCriticalHitOrMissCalculator CRITICAL_HIT_OR_MISS_CALCULATOR_CONTEXT = new HeroCriticalHitOrMissCalculator();
    private final String name = "Аттака без оружия";
    private int criticalHitChance = 0;
    private int missChance = 0;

    @Override
    public String execute(Hero hero, Enemy enemy) {
        int criticalHitOrMissCoefficient = CRITICAL_HIT_OR_MISS_CALCULATOR_CONTEXT
                .getCriticalHitOrMissCoefficient(hero, enemy, this);
        int damage = hero.getStrength() * hero.getLevel() * criticalHitOrMissCoefficient;
        hero.increaseLevel();
        hero.getWeapon().increaseLevel();
        if (0 >= damage) {
            return "Враг отразил атаку";
        } else if (damage >= enemy.getHealth()) {
            return "Вы нанесли урон " + damage +" ОЗ. Победа!";
        }
        enemy.setHealth(enemy.getHealth() - damage);
        switch (criticalHitOrMissCoefficient) {
            case 0:
                return "Промах!";
            case 2:
                return "Критическое попадание! Вы нанесли урон " + damage + " ОЗ.";
        }
        return "Вы нанесли урон " + damage + " ОЗ.";
    }

}
