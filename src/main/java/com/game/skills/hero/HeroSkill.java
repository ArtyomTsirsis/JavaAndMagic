package com.game.skills.hero;

import com.game.dto.hero.HeroDTO;
import com.game.repository.enemy.Enemy;

public interface HeroSkill {

    String execute(HeroDTO hero, Enemy enemy);
    String getName();
    int getCriticalHitChance();
    int getMissChance();

}