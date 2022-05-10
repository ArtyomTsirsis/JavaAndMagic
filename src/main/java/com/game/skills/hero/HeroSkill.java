package com.game.skills.hero;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.game.dto.hero.HeroDTO;
import com.game.repository.enemy.Enemy;

public interface HeroSkill {

    @JsonCreator
    public static HeroSkill create(@JsonProperty("name") String name) {
        return switch (name) {
            case "FastAttack" -> new ConcreteHeroSkillFastAttack();
            case "PowerAttack" -> new ConcreteHeroSkillPowerAttack();
            case "FireDamage" -> new ConcreteHeroSkillFireDamage();
            case "Shoot" -> new ConcreteHeroSkillShoot();
            case "StealthAttack" -> new ConcreteHeroSkillStealthAttack();
            case "Healing" -> new ConcreteHeroSkillHealing();
            default -> new ConcreteHeroSkillAttackWOWeapon();
        };
    }

    String execute(HeroDTO hero, Enemy enemy);
    String getName();
    String getOutput();
    int getCriticalHitChance();
    int getMissChance();

}