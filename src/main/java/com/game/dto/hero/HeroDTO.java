package com.game.dto.hero;

import com.game.dto.armor.ArmorDTO;
import com.game.dto.weapon.WeaponDTO;
import com.game.repository.hero.HeroClass;
import com.game.skills.hero.HeroSkill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HeroDTO {

    private HeroClass heroClass;
    private String name;
    private Integer health;
    private Integer strength;
    private Integer level;
    private Integer dexterity;
    private ArmorDTO armor;
    private WeaponDTO weapon;
    private List<HeroSkill> skills;

    public boolean isAlive() {
        return 0 < this.health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public void increaseLevel() {
        level++;
    }

}
