package com.game.repository.weapon;

public interface Weapon {

    Integer getId();
    String getOwner();
    void setOwner(String owner);
    WeaponType getWeaponType();
    Integer getDurability();
    void setDurability(Integer durability);
    void decreaseDurability();
    Integer getPhysicalDamage();
    void setPhysicalDamage(Integer damage);
    Integer getMagicalDamage();
    void setMagicalDamage(Integer damage);
    Integer getLevel();
    void increaseLevel();
    Integer getCriticalHitChance();
    String toString();

}
