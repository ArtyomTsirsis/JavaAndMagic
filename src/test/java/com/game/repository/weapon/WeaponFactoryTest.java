package com.game.repository.weapon;

import com.game.repository.weapon.templates.Bow;
import com.game.repository.weapon.templates.Sword;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WeaponFactoryTest {

    /*
    * scenario1
    * input: WeaponType.SWORD
    * expected output: new Weapon(new Sword())
     */
    @Test
    void scenario1() {
        Weapon actual = WeaponFactory.createWeapon(WeaponType.SWORD);
        Weapon expected = new Weapon(new Sword());
        assertEquals(expected, actual);
    }

    /*
     * scenario2
     * input: WeaponType.BOW
     * expected output: new Weapon(new Bow())
     */
    @Test
    void scenario2() {
        Weapon actual = WeaponFactory.createWeapon(WeaponType.BOW);
        Weapon expected = new Weapon(new Bow());
        assertEquals(expected, actual);
    }

}