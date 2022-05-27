package com.game.utils;

import com.game.dto.armor.ArmorDTO;
import com.game.dto.hero.HeroDTO;
import com.game.dto.weapon.WeaponDTO;
import com.game.domain.armor.Armor;
import com.game.domain.armor.ArmorClass;
import com.game.domain.hero.Hero;
import com.game.domain.hero.HeroClass;
import com.game.domain.weapon.Weapon;
import com.game.domain.weapon.WeaponType;
import com.game.skills.hero.ConcreteHeroSkillAttackWOWeapon;
import com.game.skills.hero.ConcreteHeroSkillFastAttack;
import com.game.skills.hero.ConcreteHeroSkillHealing;
import com.game.skills.hero.HeroSkill;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class HeroDTOConverterTest {

    @Mock
    private StringToSkillsDecoder decoder;
    @Mock
    private ArmorDTOConverter armorDTOConverter;
    @Mock
    private WeaponDTOConverter weaponDTOConverter;

    @InjectMocks
    private HeroDTOConverter heroDTOConverter;

    /*
    * scenario1
    * input: Hero
    * expected output: HeroDTO
     */
    @Test
    void scenario1() {
        ArmorDTO armorToInput = new ArmorDTO(1, "Arthur", ArmorClass.SHIELD, 100,
                150, 0);
        WeaponDTO weaponToInput = new WeaponDTO(1, "Arthur", WeaponType.SWORD, 100,
                200, 30, 5, 5);
        List<HeroSkill> skillsToInput = List.of(new ConcreteHeroSkillAttackWOWeapon(), new ConcreteHeroSkillFastAttack(),
                new ConcreteHeroSkillHealing());
        when(armorDTOConverter.convertToDto(any())).thenReturn(armorToInput);
        when(weaponDTOConverter.convertToDto(any())).thenReturn(weaponToInput);
        when(decoder.decrypt(any())).thenReturn(skillsToInput);
        Hero input = new Hero("Arthur", HeroClass.KNIGHT, 200, 100,
                5, 20, null, null, null);
        HeroDTO actual = heroDTOConverter.convertToDto(input);
        HeroDTO expected = new HeroDTO("Arthur", HeroClass.KNIGHT, 200, 100,
                5, 20, armorToInput, weaponToInput, skillsToInput);
        assertEquals(expected, actual);
    }

    /*
     * scenario2
     * input: HeroDTO
     * expected output: Hero
     */
    @Test
    void scenario2() {
        Armor armorToInput = new Armor(1, "Arthur", ArmorClass.SHIELD, 100,
                150, 0);
        Weapon weaponToInput = new Weapon(1, "Arthur", WeaponType.SWORD, 100,
                200, 30, 5, 5);
        String skillsToInput = "AttackWOWeapon,FastAttack,Healing";
        when(armorDTOConverter.convertFromDto(any())).thenReturn(armorToInput);
        when(weaponDTOConverter.convertFromDto(any())).thenReturn(weaponToInput);
        when(decoder.encrypt(any())).thenReturn(skillsToInput);
        HeroDTO input = new HeroDTO("Arthur", HeroClass.KNIGHT, 200, 100,
                5, 20, null, null, null);
        Hero actual = heroDTOConverter.convertFromDto(input);
        Hero expected = new Hero("Arthur", HeroClass.KNIGHT, 200, 100,
                5, 20, armorToInput, weaponToInput, skillsToInput);
        assertEquals(expected, actual);
    }

}