package com.game.skills.enemy;

import com.game.dto.hero.HeroDTO;
import com.game.domain.enemy.Enemy;

import java.util.Random;

public class EnemyCriticalHitOrMissCalculator {

    private static final Random RANDOM = new Random();

    public int getCriticalHitOrMissCoefficient(HeroDTO hero, Enemy enemy, EnemySkill skill) {
        if (RANDOM.nextInt(100) < skill.getCriticalHitChance() ) {
            return 2;
        } else if (RANDOM.nextInt(100) > (enemy.getDexterity() - hero.getDexterity() + 80 - skill.getMissChance())) {
            return 0;
        } else {
            return 1;
        }
    }

}
