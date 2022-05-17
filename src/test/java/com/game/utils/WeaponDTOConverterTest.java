package com.game.utils;

import com.game.dto.weapon.WeaponDTO;
import com.game.repository.weapon.Weapon;
import com.game.repository.weapon.WeaponType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WeaponDTOConverterTest {

    private final WeaponDTOConverter converter = new WeaponDTOConverter();

    /*
     * scenario1
     * input: new Weapon(1, "Arthur", WeaponType.SWORD, 100, 200, 30, 5, 5)
     * expected output: new WeaponDTO(1, "Arthur", WeaponType.SWORD, 100, 200, 30, 5, 5)
     */
    @Test
    void scenario1() {
        Weapon input = new Weapon(1, "Arthur", WeaponType.SWORD, 100,
                200, 30, 5, 5);
        WeaponDTO actual = converter.convertToDto(input);
        WeaponDTO expected = new WeaponDTO(1, "Arthur", WeaponType.SWORD, 100,
                200, 30, 5, 5);
        assertEquals(expected, actual);
    }

    /*
     * scenario2
     * input: new Weapon(1, null, null, 100, 200, null, 5, 5)
     * expected output: new WeaponDTO(1, null, null, 100, 200, null, 5, 5)
     */
    @Test
    void scenario2() {
        Weapon input = new Weapon(1, null, null, 100,
                200, null, 5, 5);
        WeaponDTO actual = converter.convertToDto(input);
        WeaponDTO expected = new WeaponDTO(1, null, null, 100,
                200, null, 5, 5);
        assertEquals(expected, actual);
    }

    /*
     * scenario3
     * input: new WeaponDTO(1, "Arthur", WeaponType.SWORD, 100, 200, 30, 5, 5)
     * expected output: new Weapon(1, "Arthur", WeaponType.SWORD, 100, 200, 30, 5, 5)
     */
    @Test
    void scenario3() {
        WeaponDTO input = new WeaponDTO(1, "Arthur", WeaponType.SWORD, 100,
                200, 30, 5, 5);
        Weapon actual = converter.convertFromDto(input);
        Weapon expected = new Weapon(1, "Arthur", WeaponType.SWORD, 100,
                200, 30, 5, 5);
        assertEquals(expected, actual);
    }

    /*
     * scenario4
     * input: new WeaponDTO(1, null, null, 100, 200, null, 5, 5)
     * expected output: new Weapon(1, null, null, 100, 200, null, 5, 5)
     */
    @Test
    void scenario4() {
        WeaponDTO input = new WeaponDTO(1, null, null, 100,
                200, null, 5, 5);
        Weapon actual = converter.convertFromDto(input);
        Weapon expected = new Weapon(1, null, null, 100,
                200, null, 5, 5);
        assertEquals(expected, actual);
    }

}