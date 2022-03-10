package com.game.repository.enemy;

import lombok.Data;
import com.game.skills.enemy.ConcreteEnemySkillFastAttack;
import com.game.skills.enemy.ConcreteEnemySkillPowerAttack;
import com.game.skills.enemy.EnemySkill;

import java.util.List;

@Data
public class Orc implements Enemy {

    private final static EnemyClass ENEMY_CLASS = EnemyClass.ORC;
    private Integer health = 500;
    private Integer dexterity = 5;
    private Integer physicalDamage = 150;
    private Integer magicalDamage = 0;
    private Integer physicalDefense = 40;
    private Integer magicalDefense = 0;
    private List<EnemySkill> skills = List.of(new ConcreteEnemySkillFastAttack(), new ConcreteEnemySkillPowerAttack());

    public EnemyClass getEnemyClass() {
        return ENEMY_CLASS;
    }

    @Override
    public void setHealth(Integer health) {
        this.health = health;
    }

}
