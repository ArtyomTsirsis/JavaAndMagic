package com.game.utils;

import com.game.dto.armor.ArmorDTO;
import com.game.dto.hero.HeroDTO;
import com.game.dto.weapon.WeaponDTO;
import com.game.domain.armor.Armor;
import com.game.domain.hero.Hero;
import com.game.domain.weapon.Weapon;
import com.game.skills.hero.HeroSkill;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class HeroDTOConverter {

    private final StringToSkillsDecoder decoder;
    private final ArmorDTOConverter armorDTOConverter;
    private final WeaponDTOConverter weaponDTOConverter;

    public HeroDTO convertToDto(Hero hero) {
        ArmorDTO armor = armorDTOConverter.convertToDto(hero.getArmor());
        WeaponDTO weapon = weaponDTOConverter.convertToDto(hero.getWeapon());
        List<HeroSkill> decryptedSkills = decoder.decrypt(hero.getSkillBook());
        return new HeroDTO(hero.getName(), hero.getHeroClass(), hero.getHealth(), hero.getStrength(),
                hero.getLevel(), hero.getDexterity(), armor,
                weapon, decryptedSkills);
    }

    public Hero convertFromDto(HeroDTO hero) {
        Armor armor = armorDTOConverter.convertFromDto(hero.getArmor());
        Weapon weapon = weaponDTOConverter.convertFromDto(hero.getWeapon());
        String encryptedSkills = decoder.encrypt(hero.getSkills());
        return new Hero(hero.getName(), hero.getHeroClass(), hero.getHealth(), hero.getStrength(),
                hero.getLevel(), hero.getDexterity(), armor, weapon, encryptedSkills);
    }

}
