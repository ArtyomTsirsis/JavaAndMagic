package com.game.repository.hero;

import com.game.repository.armor.Armor;
import com.game.repository.weapon.Weapon;

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
    String getSkills();
    String toString();

    default boolean isAlive(Hero hero) {
        return 0 < hero.getHealth();
    }

}