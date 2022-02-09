package enemy;

import lombok.Data;

@Data
public class Skeleton implements Enemy {

    private final static EnemyClass ENEMY_CLASS = EnemyClass.SKELETON;
    private Integer health = 150;
    private Integer dexterity = 15;
    private Integer physicalDamage = 50;
    private Integer magicalDamage = 20;
    private Integer physicalDefense = 20;
    private Integer magicalDefense = 0;


    public EnemyClass getEnemyClass() {
        return ENEMY_CLASS;
    }

    @Override
    public void setHealth(Integer health) {
        this.health = health;
    }

}
