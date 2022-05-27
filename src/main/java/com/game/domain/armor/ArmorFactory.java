package com.game.domain.armor;

import com.game.domain.armor.templates.*;

public class ArmorFactory {

    public static Armor createArmor(ArmorClass armorClass) {
        return new Armor(switch (armorClass) {
            case WITHOUT_ARMOR -> new WOArmor();
            case ARMOR_SUIT -> new ArmorSuit();
            case LEATHER_ARMOR -> new LeatherArmor();
            case MAGICAL_SHIELD -> new MagicalShield();
            case SHIELD -> new Shield();
        });
    }

}
