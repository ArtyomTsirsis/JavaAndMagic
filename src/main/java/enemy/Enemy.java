package enemy;

public interface Enemy {

    EnemyClass getEnemyClass();
    Integer getHealth();
    void setHealth(Integer health);
    Integer getDexterity();
    Integer getPhysicalDamage();
    Integer getMagicalDamage();
    Integer getPhysicalDefense();
    Integer getMagicalDefense();

}
