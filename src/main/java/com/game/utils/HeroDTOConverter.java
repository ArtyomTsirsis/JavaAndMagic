package com.game.utils;

import com.game.dto.armor.ArmorDTO;
import com.game.dto.hero.HeroDTO;
import com.game.dto.weapon.WeaponDTO;
import com.game.reposervices.armor.FindArmorByIDService;
import com.game.reposervices.weapon.FindWeaponByIDService;
import com.game.repository.hero.Hero;
import com.game.skills.hero.HeroSkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HeroDTOConverter {

    @Autowired
    private StringToSkillsCrypter converter;
    @Autowired
    private FindWeaponByIDService findWeaponByIDService;
    @Autowired
    private FindArmorByIDService findArmorByIDService;

    public HeroDTO convertToDto(Hero hero) {
        ArmorDTO armor = null;
        WeaponDTO weapon = null;
        List<HeroSkill> decryptedSkills = converter.decrypt(hero.getSkillBook());
        try {
            armor = findArmorByIDService.findByID(hero.getArmorID()).getArmor();
            weapon = findWeaponByIDService.findByID(hero.getWeaponID()).getWeapon();
        } catch (Exception ignored) {}
        return new HeroDTO(hero.getHeroClass(), hero.getName(), hero.getHealth(), hero.getStrength(),
                hero.getLevel(), hero.getDexterity(), armor,
                weapon, decryptedSkills);
    }

    public Hero convertFromDto(HeroDTO hero) {
        String encryptedSkills = converter.encrypt(hero.getSkills());
        return new Hero(hero.getName(), hero.getHeroClass(), hero.getHealth(), hero.getStrength(),
                hero.getLevel(), hero.getDexterity(), hero.getArmor().getId(),
                hero.getWeapon().getId(), encryptedSkills);
    }

}
