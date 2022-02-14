package weapon;

import hero.HeroClass;

public interface Weapon {

    WeaponType getWeaponType();
    HeroClass[] getWhoCanUse();
    Integer getDurability();
    void setDurability(Integer durability);
    Integer getPhysicalDamage();
    void setPhysicalDamage(Integer damage);
    Integer getMagicalDamage();
    void setMagicalDamage(Integer damage);
    Integer getLevel();
    String toString();

}
