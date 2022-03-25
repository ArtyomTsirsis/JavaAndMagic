package com.game.repository.hero;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Wizard implements Hero {

    private final static HeroClass HERO_CLASS = HeroClass.WIZARD;
    @NonNull
    private String name;
    private Integer health = 200;
    private Integer strength = 15;
    private Integer level = 1;
    private Integer dexterity = 8;
    private Integer armorID = -1;
    private Integer weaponID = -1;
    private String skills = "AttackWOWeapon, FireDamage, Healing";

    @Override
    public HeroClass getHeroClass() {
        return HERO_CLASS;
    }

    @Override
    public void setHealth(Integer health) {
        this.health = health;
    }

    @Override
    public void increaseLevel() {
        level++;
    }

}
