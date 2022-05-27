package com.game.skills.enemy;

import com.game.dto.hero.HeroDTO;
import com.game.domain.enemy.Enemy;

import java.util.Random;

public class EnemySkillContext {

    private static final Random RANDOM = new Random();

    public String useSkill(HeroDTO hero, Enemy enemy) {
        EnemySkill enemySkill = enemy.getSkills().get(RANDOM.nextInt(enemy.getSkills().size()));
        return enemySkill.execute(hero, enemy);
    }

}