package com.game.repository.hero.templates;

import com.game.repository.hero.Hero;
import com.game.repository.hero.HeroClass;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

@EqualsAndHashCode(callSuper = true)
@Data
public class Knight extends Hero {

    private HeroClass heroClass = HeroClass.KNIGHT;
    @NonNull
    private String name;
    private Integer health = 400;
    private Integer strength = 20;
    private Integer level = 1;
    private Integer dexterity = 10;
    private Integer armorID = -1;
    private Integer weaponID = -1;
    private String skillBook = "FastAttack, PowerAttack, Healing";

    @Override
    public HeroClass getHeroClass() {
        return heroClass;
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
