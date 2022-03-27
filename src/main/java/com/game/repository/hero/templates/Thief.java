package com.game.repository.hero.templates;

import com.game.repository.hero.Hero;
import com.game.repository.hero.HeroClass;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

@EqualsAndHashCode(callSuper = true)
@Data
public class Thief extends Hero {

    private final static HeroClass HERO_CLASS = HeroClass.THIEF;
    @NonNull
    private String name;
    private Integer health = 250;
    private Integer strength = 15;
    private Integer level = 1;
    private Integer dexterity = 20;
    private Integer armorID = -1;
    private Integer weaponID = -1;
    private String skills = "FastAttack, StealthAttack, Healing";

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

    @Override
    public boolean isAlive() {
        return 0 < this.health;
    }

}
