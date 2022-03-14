package com.game.dto;

import com.game.repository.armor.Armor;
import com.game.repository.hero.HeroClass;
import com.game.repository.weapon.Weapon;
import com.game.skills.hero.HeroSkill;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class HeroDTO {

    private final HeroClass heroClass;
    private String name;
    private Integer health;
    private Integer strength;
    private Integer level;
    private Integer dexterity;
    private Armor armor;
    private Weapon weapon;
    private List<HeroSkill> skills;

}
