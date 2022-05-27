package com.game.domain.weapon;

import com.game.domain.weapon.templates.*;

public class WeaponFactory {

    public static Weapon createWeapon(WeaponType weaponType) {
        return new Weapon(switch (weaponType) {
            case WITHOUT_WEAPON -> new WOWeapon();
            case AXE -> new Axe();
            case BOW -> new Bow();
            case LANCE -> new Lance();
            case MAGIC_STAFF -> new MagicStaff();
            case SWORD -> new Sword();
        });
    }

}
