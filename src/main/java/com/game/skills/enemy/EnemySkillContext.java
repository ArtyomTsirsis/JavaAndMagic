package com.game.skills.enemy;

import com.game.repository.stuff.enemy.Enemy;
import com.game.repository.hero.Hero;

import java.util.Random;

public class EnemySkillContext {

    private static final Random RANDOM = new Random();

    public String useSkill(Hero hero, Enemy enemy) {
        EnemySkill enemySkill = enemy.getSkills().get(RANDOM.nextInt(enemy.getSkills().size()));
        return enemySkill.execute(hero, enemy);
    }

}