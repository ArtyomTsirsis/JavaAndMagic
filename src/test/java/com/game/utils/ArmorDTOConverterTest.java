package com.game.utils;

import com.game.dto.armor.ArmorDTO;
import com.game.repository.armor.Armor;
import com.game.repository.armor.ArmorClass;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArmorDTOConverterTest {

    private final ArmorDTOConverter converter = new ArmorDTOConverter();

    /*
    * scenario1
    * input: new Armor(1, "Arthur", ArmorClass.SHIELD, 100, 150, 0)
    * expected output: new ArmorDTO(1, "Arthur", ArmorClass.SHIELD, 100, 150, 0)
     */
    @Test
    void scenario1() {
        Armor input = new Armor(1, "Arthur", ArmorClass.SHIELD, 100, 150,
                0);
        ArmorDTO actual = converter.convertToDto(input);
        ArmorDTO expected = new ArmorDTO(1, "Arthur", ArmorClass.SHIELD, 100, 150,
                0);
        assertEquals(expected, actual);
    }

    /*
     * scenario2
     * input: new Armor(1, "Arthur1234", null, null, 150, 0)
     * expected output: new ArmorDTO(1, "Arthur1234", null, null, 150, 0)
     */
    @Test
    void scenario2() {
        Armor input = new Armor(1, "Arthur1234", null, null, 150, 0);
        ArmorDTO actual = converter.convertToDto(input);
        ArmorDTO expected = new ArmorDTO(1, "Arthur1234", null, null, 150, 0);
        assertEquals(expected, actual);
    }

    /*
     * scenario3
     * input: new ArmorDTO(1, "Arthur", ArmorClass.SHIELD, 100, 150, 0)
     * expected output: new Armor(1, "Arthur", ArmorClass.SHIELD, 100, 150, 0)
     */
    @Test
    void scenario3() {
        ArmorDTO input = new ArmorDTO(1, "Arthur", ArmorClass.SHIELD, 100, 150,
                0);
        Armor actual = converter.convertFromDto(input);
        Armor expected = new Armor(1, "Arthur", ArmorClass.SHIELD, 100, 150,
                0);
        assertEquals(expected, actual);
    }

    /*
     * scenario4
     * input: new ArmorDTO(1, "Arthur1234", null, null, 150, 0)
     * expected output: new Armor(1, "Arthur1234", null, null, 150, 0)
     */
    @Test
    void scenario4() {
        ArmorDTO input = new ArmorDTO(1, "Arthur1234", null, null, 150, 0);
        Armor actual = converter.convertFromDto(input);
        Armor expected = new Armor(1, "Arthur1234", null, null, 150, 0);
        assertEquals(expected, actual);
    }

}