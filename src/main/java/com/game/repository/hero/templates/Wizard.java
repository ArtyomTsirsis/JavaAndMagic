package com.game.repository.hero.templates;

import com.game.repository.hero.Hero;
import com.game.repository.hero.HeroClass;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

@EqualsAndHashCode(callSuper = true)
@Data
public class Wizard extends Hero {

    private final static HeroClass heroClass = HeroClass.WIZARD;
    @NonNull
    private String name;
    private Integer health = 200;
    private Integer strength = 15;
    private Integer level = 1;
    private Integer dexterity = 8;
    private Integer armorID;
    private Integer weaponID;
    private String skillBook = "AttackWOWeapon, FireDamage, Healing";

}
