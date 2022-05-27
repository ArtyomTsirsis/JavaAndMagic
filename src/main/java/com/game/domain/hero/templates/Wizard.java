package com.game.domain.hero.templates;

import com.game.domain.hero.Hero;
import com.game.domain.hero.HeroClass;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

@EqualsAndHashCode(callSuper = true)
@Data
public class Wizard extends Hero {

    private HeroClass heroClass = HeroClass.WIZARD;
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
