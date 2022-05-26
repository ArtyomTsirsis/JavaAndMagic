package com.game.repository.enemy;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.game.skills.enemy.EnemySkill;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface Enemy {

    @JsonCreator
    public static Enemy create(@JsonProperty("enemyClass") EnemyClass enemyClass,
                               @JsonProperty("health") Integer health) {
        Enemy enemy = switch (enemyClass) {
            case ORC -> new Orc();
            case SPIDER -> new Spider();
            default -> new Skeleton();
        };
        enemy.setHealth(health);
        return enemy;
    }

    void setSkills(List<EnemySkill> skills);

    EnemyClass getEnemyClass();
    Integer getHealth();
    void setHealth(Integer health);
    Integer getDexterity();
    Integer getPhysicalDamage();
    Integer getMagicalDamage();
    Integer getPhysicalDefense();
    Integer getMagicalDefense();
    List<EnemySkill> getSkills();
    String toString();

    default boolean isAlive(Enemy enemy) {
        return 0 < enemy.getHealth();
    }

}
