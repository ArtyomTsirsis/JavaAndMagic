package com.game.repository.weapon;

import com.game.repository.hero.HeroClass;

public interface Weapon {

    Integer getId();
    WeaponType getWeaponType();
    HeroClass[] getWhoCanUse();
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
