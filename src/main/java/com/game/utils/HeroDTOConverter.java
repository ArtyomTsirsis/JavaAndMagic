package com.game.utils;

import com.game.dto.hero.HeroDTO;
import com.game.reposervices.armor.FindArmorByIDService;
import com.game.reposervices.weapon.FindWeaponByIDService;
import com.game.repository.hero.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HeroDTOConverter {

    @Autowired
    private StringToSkillsCrypter converter;
    @Autowired
    private FindWeaponByIDService findWeaponByIDService;
    @Autowired
    private FindArmorByIDService findArmorByIDService;

    public HeroDTO convertToDto(Hero hero) {
        try {
            return new HeroDTO(hero.getHeroClass(), hero.getName(), hero.getHealth(), hero.getStrength(),
                    hero.getLevel(), hero.getDexterity(), findArmorByIDService.findByID(hero.getArmorID()).getArmor(),
                    findWeaponByIDService.findByID(hero.getWeaponID()).getWeapon(), converter.decrypt(hero.getSkillBook()));
        }
        catch (Exception e) {
            return new HeroDTO(hero.getHeroClass(), hero.getName(), hero.getHealth(), hero.getStrength(),
                    hero.getLevel(), hero.getDexterity(), null, null, converter.decrypt(hero.getSkillBook()));
        }
    }

    public Hero convertFromDto(HeroDTO hero) {
        return new Hero(hero.getName(), hero.getHeroClass(), hero.getHealth(), hero.getStrength(),
                hero.getLevel(), hero.getDexterity(), hero.getArmor().getId(),
                hero.getWeapon().getId(), converter.encrypt(hero.getSkills()));
    }

}
