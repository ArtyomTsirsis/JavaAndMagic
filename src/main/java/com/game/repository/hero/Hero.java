package com.game.repository.hero;

import com.game.repository.stuff.armor.Armor;
import com.game.repository.stuff.weapon.Weapon;
import com.game.skills.hero.HeroSkill;

import java.util.List;

public interface Hero {

    HeroClass getHeroClass();
    String getName();
    Integer getHealth();
    void setHealth(Integer health);
    Integer getStrength();
    Integer getLevel();
    void increaseLevel();
    Integer getDexterity();
    Armor getArmor();
    Weapon getWeapon();
    List<HeroSkill> getSkills();
    String toString();

    default boolean isAlive(Hero hero) {
        return 0 < hero.getHealth();
    }

}