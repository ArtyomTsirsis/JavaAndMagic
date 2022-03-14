package com.game.skills.enemy;

import com.game.repository.stuff.enemy.Enemy;
import com.game.repository.hero.Hero;

public interface EnemySkill {

    String execute(Hero hero, Enemy enemy);
    String getName();
    int getCriticalHitChance();
    int getMissChance();

}

