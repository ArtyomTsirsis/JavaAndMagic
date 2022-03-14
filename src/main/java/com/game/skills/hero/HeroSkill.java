package com.game.skills.hero;

import com.game.repository.enemy.Enemy;
import com.game.repository.hero.Hero;

public interface HeroSkill {

    String execute(Hero hero, Enemy enemy);
    String getName();
    int getCriticalHitChance();
    int getMissChance();

}