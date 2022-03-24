package com.game.utils;

import com.game.dto.HeroDTO;
import com.game.repository.hero.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConverterToDto {

    @Autowired
    private StringToSkillsCrypter converter;

    public HeroDTO convertToDto(Hero hero) {
        return new HeroDTO(hero.getHeroClass(), hero.getName(), hero.getHealth(), hero.getStrength(),
                hero.getLevel(), hero.getDexterity(), hero.getArmor(), hero.getWeapon(), converter.decrypt(hero.getSkills()));
    }

}
