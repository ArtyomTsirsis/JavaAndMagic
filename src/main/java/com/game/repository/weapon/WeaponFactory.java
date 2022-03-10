package com.game.repository.weapon;

public class WeaponFactory {

    public static Weapon createWeapon(WeaponType weaponType) {
        Weapon toReturn;
        switch (weaponType) {
            case AXE:
                toReturn = new Axe();
                break;
            case BOW:
                toReturn = new Bow();
                break;
            case LANCE:
                toReturn = new Lance();
                break;
            case MAGIC_STAFF:
                toReturn = new MagicStaff();
                break;
            case SWORD:
                toReturn = new Sword();
                break;
            default:
                toReturn = null;
        }
        return toReturn;
    }

}
