package com.game.domain.armor;

import com.game.domain.armor.Armor;
import com.game.domain.armor.ArmorClass;
import com.game.domain.armor.ArmorFactory;
import com.game.domain.armor.templates.Shield;
import com.game.domain.armor.templates.WOArmor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArmorFactoryTest {

    /*
     * scenario1
     * input: ArmorClass.WITHOUT_ARMOR
     * expected output: new Armor(new WOArmor())
     */
    @Test
    void scenario1() {
        Armor actual = ArmorFactory.createArmor(ArmorClass.WITHOUT_ARMOR);
        Armor expected = new Armor(new WOArmor());
        assertEquals(expected, actual);
    }

    /*
     * scenario2
     * input: ArmorClass.SHIELD
     * expected output: new Armor(new Shield())
     */
    @Test
    void scenario2() {
        Armor actual = ArmorFactory.createArmor(ArmorClass.SHIELD);
        Armor expected = new Armor(new Shield());
        assertEquals(expected, actual);
    }

}