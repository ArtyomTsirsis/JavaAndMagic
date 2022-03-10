package com.game.skills.hero;

import com.game.repository.enemy.Enemy;
import com.game.repository.hero.Hero;

import java.util.Random;

public class HeroCriticalHitOrMissCalculator {

    private static final Random RANDOM = new Random();

    public int getCriticalHitOrMissCoefficient(Hero hero, Enemy enemy, HeroSkill skill) {
        if (RANDOM.nextInt(100) < hero.getWeapon().getCriticalHitChance() + skill.getCriticalHitChance() ) {
            return 2;
        } else if (RANDOM.nextInt(100) > (hero.getDexterity() - enemy.getDexterity() + 80 - skill.getMissChance())) {
            return 0;
        } else {
            return 1;
        }
    }

}
