package enemy;

public class Skeleton extends Enemy {

    private final static EnemyClass enemyClass = EnemyClass.Skeleton;

    public Skeleton(EnemyClass enemyClass, Integer health, Integer dexterity, Integer physicalDamage, Integer magicalDamage, Integer physicalDefense, Integer magicalDefense) {
        super(enemyClass, health, dexterity, physicalDamage, magicalDamage, physicalDefense, magicalDefense);
    }

}
