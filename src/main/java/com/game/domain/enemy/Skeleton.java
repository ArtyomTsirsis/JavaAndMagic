package com.game.domain.enemy;

import lombok.Data;
import com.game.skills.enemy.ConcreteEnemySkillFastAttack;
import com.game.skills.enemy.EnemySkill;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class Skeleton implements Enemy {

    private final static EnemyClass ENEMY_CLASS = EnemyClass.SKELETON;
    private Integer health = 150;
    private Integer dexterity = 10;
    private Integer physicalDamage = 50;
    private Integer magicalDamage = 20;
    private Integer physicalDefense = 20;
    private Integer magicalDefense = 0;
    private List<EnemySkill> skills = List.of(new ConcreteEnemySkillFastAttack());

    public EnemyClass getEnemyClass() {
        return ENEMY_CLASS;
    }

    @Override
    public void setHealth(Integer health) {
        this.health = health;
    }

}
