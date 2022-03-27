package com.game.repository.hero;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hero {

    private HeroClass HERO_CLASS;
    private String name;
    private Integer health;
    private Integer strength;
    private Integer level;
    private Integer dexterity;
    private Integer armorID;
    private Integer weaponID;
    private String skills;

    public HeroClass getHeroClass() {
        return HERO_CLASS;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public void increaseLevel() {
        level++;
    }

    public boolean isAlive() {
        return 0 < this.health;
    }

}