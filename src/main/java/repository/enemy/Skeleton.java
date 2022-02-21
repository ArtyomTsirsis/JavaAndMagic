package repository.enemy;

import lombok.Data;
import skills.enemy.ConcreteEnemySkillAttack;
import skills.enemy.EnemySkill;

import java.util.List;

@Data
public class Skeleton implements Enemy {

    private final static EnemyClass ENEMY_CLASS = EnemyClass.SKELETON;
    private Integer health = 150;
    private Integer dexterity = 10;
    private Integer physicalDamage = 50;
    private Integer magicalDamage = 20;
    private Integer physicalDefense = 20;
    private Integer magicalDefense = 0;
    private List<EnemySkill> skills = List.of(new ConcreteEnemySkillAttack());

    public EnemyClass getEnemyClass() {
        return ENEMY_CLASS;
    }

    @Override
    public void setHealth(Integer health) {
        this.health = health;
    }

}
