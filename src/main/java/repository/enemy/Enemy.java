package repository.enemy;

import skills.enemy.EnemySkill;

import java.util.List;

public interface Enemy {

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

}
