package weapon;

import hero.HeroClass;

public interface Weapon {

    WeaponType getWeaponType();
    HeroClass[] getWhoCanUse();
    Integer getDurability();
    Integer getPhysicalDamage();
    Integer getMagicalDamage();
    Integer getLevel();
    String toString();

}
