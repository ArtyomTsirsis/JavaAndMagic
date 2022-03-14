package com.game.skills.hero;

import com.game.repository.stuff.enemy.Enemy;
import com.game.repository.hero.Hero;
import lombok.Data;

@Data
public class ConcreteHeroSkillHealing implements HeroSkill {

    private static final HeroCriticalHitOrMissCalculator CRITICAL_HIT_OR_MISS_CALCULATOR_CONTEXT = new HeroCriticalHitOrMissCalculator();
    private final String name = "Лечение";
    private int criticalHitChance = 0;
    private int missChance = 0;

    @Override
    public String execute(Hero hero, Enemy enemy) {
        int heal = 10 * hero.getLevel() + 50;
        hero.setHealth(hero.getHealth() + heal);
        return "Вы восстановили " + heal + " ОЗ.";
    }

}
