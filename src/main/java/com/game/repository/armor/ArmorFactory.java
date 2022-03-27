package com.game.repository.armor;

public class ArmorFactory {

    public static Armor createArmor(ArmorClass armorClass) {
        return switch (armorClass) {
            case WITHOUT_ARMOR -> new WOArmor();
            case ARMOR_SUIT -> new ArmorSuit();
            case LEATHER_ARMOR -> new LeatherArmor();
            case MAGICAL_SHIELD -> new MagicalShield();
            case SHIELD -> new Shield();
        };
    }

}
