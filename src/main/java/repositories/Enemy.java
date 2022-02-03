package repositories;

import enums.EnemyClass;

public class Enemy {

    private EnemyClass enemyClass;
    private Integer health;
    private Integer dexterity;
    private Integer physicalDamage;
    private Integer magicalDamage;
    private Integer physicalDefense;
    private Integer magicalDefense;

    public Enemy(EnemyClass enemyClass, Integer health, Integer dexterity, Integer physicalDamage,
                 Integer magicalDamage, Integer physicalDefense, Integer magicalDefense) {
        this.enemyClass = enemyClass;
        this.health = health;
        this.dexterity = dexterity;
        this.physicalDamage = physicalDamage;
        this.magicalDamage = magicalDamage;
        this.physicalDefense = physicalDefense;
        this.magicalDefense = magicalDefense;
    }

    public EnemyClass getEnemyClass() {
        return enemyClass;
    }

    public void setEnemyClass(EnemyClass enemyClass) {
        this.enemyClass = enemyClass;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Integer getDexterity() {
        return dexterity;
    }

    public void setDexterity(Integer dexterity) {
        this.dexterity = dexterity;
    }

    public Integer getPhysicalDamage() {
        return physicalDamage;
    }

    public void setPhysicalDamage(Integer physicalDamage) {
        this.physicalDamage = physicalDamage;
    }

    public Integer getMagicalDamage() {
        return magicalDamage;
    }

    public void setMagicalDamage(Integer magicalDamage) {
        this.magicalDamage = magicalDamage;
    }

    public Integer getPhysicalDefense() {
        return physicalDefense;
    }

    public void setPhysicalDefense(Integer physicalDefense) {
        this.physicalDefense = physicalDefense;
    }

    public Integer getMagicalDefense() {
        return magicalDefense;
    }

    public void setMagicalDefense(Integer magicalDefense) {
        this.magicalDefense = magicalDefense;
    }

}
