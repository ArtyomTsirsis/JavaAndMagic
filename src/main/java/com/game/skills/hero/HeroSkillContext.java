package com.game.skills.hero;

import com.game.repository.enemy.Enemy;
import com.game.repository.hero.Hero;

public class HeroSkillContext {

    private HeroSkill heroSkill;

    public void setSkill(String heroSkill) {
        this.heroSkill = HeroSkillFactory.createSkill(heroSkill);
    }

//    public void setSkill(HeroSkill heroSkill) {
//        this.heroSkill = heroSkill;
//    }

    public String useSkill(Hero hero, Enemy enemy) {
        return heroSkill.execute(hero, enemy);
    }

}