package com.game.skills.hero;

import com.game.repository.enemy.Enemy;
import com.game.repository.hero.Hero;
import lombok.Data;

@Data
public class ConcreteHeroSkillFastAttack implements HeroSkill {

    private static final HeroCriticalHitOrMissCalculator CRITICAL_HIT_OR_MISS_CALCULATOR_CONTEXT = new HeroCriticalHitOrMissCalculator();
    private final String name = "Быстрая атака";
    private int criticalHitChance = 0;
    private int missChance = 0;


    @Override
    public String execute(Hero hero, Enemy enemy) {
        int criticalHitOrMissCoefficient = CRITICAL_HIT_OR_MISS_CALCULATOR_CONTEXT
                .getCriticalHitOrMissCoefficient(hero, enemy, this);
        int damage = ((hero.getStrength() * hero.getLevel() + (hero.getWeapon().getPhysicalDamage() *
                hero.getWeapon().getLevel() - enemy.getPhysicalDefense()) + (hero.getWeapon().getMagicalDamage() *
                hero.getWeapon().getLevel() - enemy.getMagicalDefense()))) * criticalHitOrMissCoefficient;
        hero.increaseLevel();
        hero.getWeapon().increaseLevel();
        if (0 >= damage) {
            return "Враг отразил атаку";
        } else if (damage >= enemy.getHealth()) {
            enemy.setHealth(0);
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