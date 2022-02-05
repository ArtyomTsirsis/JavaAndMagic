package enemy;

public class Spider extends Enemy {

    private final static EnemyClass enemyClass = EnemyClass.Spider;


    public Spider(EnemyClass enemyClass, Integer health, Integer dexterity, Integer physicalDamage, Integer magicalDamage, Integer physicalDefense, Integer magicalDefense) {
        super(enemyClass, health, dexterity, physicalDamage, magicalDamage, physicalDefense, magicalDefense);
    }

}
