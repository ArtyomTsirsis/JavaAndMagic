package enemy;

public class Orc extends Enemy {

    private final static EnemyClass enemyClass = EnemyClass.Orc;


    public Orc(EnemyClass enemyClass, Integer health, Integer dexterity, Integer physicalDamage, Integer magicalDamage, Integer physicalDefense, Integer magicalDefense) {
        super(enemyClass, health, dexterity, physicalDamage, magicalDamage, physicalDefense, magicalDefense);
    }

}
