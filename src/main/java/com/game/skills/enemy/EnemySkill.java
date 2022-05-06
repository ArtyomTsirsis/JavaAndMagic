package com.game.skills.enemy;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.game.dto.hero.HeroDTO;
import com.game.repository.enemy.Enemy;

public interface EnemySkill {

    @JsonCreator
    public static EnemySkill create(@JsonProperty("name") String name) {
        return switch (name) {
            case "FireDamage" -> new ConcreteEnemySkillFireDamage();
            case "PowerAttack" -> new ConcreteEnemySkillPowerAttack();
            default -> new ConcreteEnemySkillFastAttack();
        };
    }

    String execute(HeroDTO hero, Enemy enemy);
    String getName();
    int getCriticalHitChance();
    int getMissChance();

}

