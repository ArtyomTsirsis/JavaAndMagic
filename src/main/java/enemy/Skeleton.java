package enemy;

import lombok.Data;

@Data
public class Skeleton implements Enemy {

    private final static EnemyClass enemyClass = EnemyClass.SKELETON;
    private Integer health = 150;
    private Integer dexterity = 15;
    private Integer physicalDamage = 50;
    private Integer magicalDamage = 20;
    private Integer physicalDefense = 20;
    private Integer magicalDefense = 0;

}
