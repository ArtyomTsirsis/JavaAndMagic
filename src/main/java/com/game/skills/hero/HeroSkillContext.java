package com.game.skills.hero;

import com.game.repository.stuff.enemy.Enemy;
import com.game.repository.hero.Hero;

public class HeroSkillContext {

    private HeroSkill heroSkill;

    public void setSkill(HeroSkill heroSkill) {
        this.heroSkill = heroSkill;
    }

    public String useSkill(Hero hero, Enemy enemy) {
        return heroSkill.execute(hero, enemy);
    }

}