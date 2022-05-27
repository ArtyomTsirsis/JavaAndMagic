package com.game.domain.hero.templates;

import com.game.domain.hero.Hero;
import com.game.domain.hero.HeroClass;
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
    private Integer strength = 25;
    private Integer level = 1;
    private Integer dexterity = 10;
    private Integer armorID;
    private Integer weaponID;
    private String skillBook = "FastAttack, PowerAttack, Healing";

}
