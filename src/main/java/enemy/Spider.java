package enemy;

import lombok.Data;

@Data
public class Spider implements Enemy {

    private final static EnemyClass ENEMY_CLASS = EnemyClass.SPIDER;
    private Integer health = 70;
    private Integer dexterity = 35;
    private Integer physicalDamage = 20;
    private Integer magicalDamage = 30;
    private Integer physicalDefense = 10;
    private Integer magicalDefense = 0;

    public EnemyClass getEnemyClass() {
        return ENEMY_CLASS;
    }

    @Override
    public void setHealth(Integer health) {
        this.health = health;
    }

}
