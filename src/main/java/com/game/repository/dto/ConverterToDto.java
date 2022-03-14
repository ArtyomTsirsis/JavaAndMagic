package com.game.repository.dto;

import com.game.repository.hero.Hero;
import org.springframework.stereotype.Component;

@Component
public class ConverterToDto {

    public HeroDTO convertToDto(Hero hero) {
        return new HeroDTO(hero.getHeroClass(), hero.getName(), hero.getHealth(), hero.getStrength(),
                hero.getLevel(), hero.getDexterity(), hero.getArmor(), hero.getWeapon(), hero.getSkills());
    }

}
