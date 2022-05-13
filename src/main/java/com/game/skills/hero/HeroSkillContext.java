package com.game.skills.hero;

import com.game.dto.hero.HeroDTO;
import com.game.repository.enemy.Enemy;

public class HeroSkillContext {

    private HeroSkill heroSkill;

    public void setSkill(String heroSkill) {
        this.heroSkill = HeroSkillFactory.createSkill(heroSkill);
    }

    public String useSkill(HeroDTO hero, Enemy enemy) {
        return heroSkill.execute(hero, enemy);
    }

}