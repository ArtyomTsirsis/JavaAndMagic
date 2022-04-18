package com.game.repository.hero.templates;

import com.game.repository.hero.Hero;
import com.game.repository.hero.HeroClass;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

@EqualsAndHashCode(callSuper = true)
@Data
public class Archer extends Hero {

    private HeroClass heroClass = HeroClass.ARCHER;
    @NonNull
    private String name;
    private Integer health = 150;
    private Integer strength = 10;
    private Integer level = 1;
    private Integer dexterity = 12;
    private Integer armorID;
    private Integer weaponID;
    private String skillBook = "AttackWOWeapon, Shoot, Healing";

}