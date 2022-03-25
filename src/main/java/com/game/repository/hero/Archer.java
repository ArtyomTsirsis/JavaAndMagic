package com.game.repository.hero;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Archer implements Hero {

    private final static HeroClass HERO_CLASS = HeroClass.ARCHER;
    @NonNull
    private String name;
    private Integer health = 150;
    private Integer strength = 10;
    private Integer level = 1;
    private Integer dexterity = 12;
    private Integer armorID = -1;
    private Integer weaponID = -1;
    private String skills = "AttackWOWeapon, Shoot, Healing";

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