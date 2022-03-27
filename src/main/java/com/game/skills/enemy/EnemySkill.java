package com.game.skills.enemy;

import com.game.dto.hero.HeroDTO;
import com.game.repository.enemy.Enemy;

public interface EnemySkill {

    String execute(HeroDTO hero, Enemy enemy);
    String getName();
    int getCriticalHitChance();
    int getMissChance();

}

