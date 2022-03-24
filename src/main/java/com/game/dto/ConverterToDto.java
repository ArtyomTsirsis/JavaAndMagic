package com.game.dto;

import com.game.repository.hero.Hero;
import com.game.skills.hero.ConcreteHeroSkillAttackWOWeapon;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConverterToDto {

//    public HeroDTO convertToDto(Hero hero) {
//        return new HeroDTO(hero.getHeroClass(), hero.getName(), hero.getHealth(), hero.getStrength(),
//                hero.getLevel(), hero.getDexterity(), hero.getArmor(), hero.getWeapon(), hero.getSkills());
//    }

    public HeroDTO convertToDto(Hero hero) {
        return new HeroDTO(hero.getHeroClass(), hero.getName(), hero.getHealth(), hero.getStrength(),
                hero.getLevel(), hero.getDexterity(), hero.getArmor(), hero.getWeapon(), List.of(new ConcreteHeroSkillAttackWOWeapon()));
    }

}
