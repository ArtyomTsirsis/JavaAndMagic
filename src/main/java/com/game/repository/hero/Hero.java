package com.game.repository.hero;

public interface Hero {

    HeroClass getHeroClass();
    String getName();
    Integer getHealth();
    void setHealth(Integer health);
    Integer getStrength();
    Integer getLevel();
    void increaseLevel();
    Integer getDexterity();
    Integer getArmorID();
    Integer getWeaponID();
    String getSkills();
    String toString();

    default boolean isAlive(Hero hero) {
        return 0 < hero.getHealth();
    }

}