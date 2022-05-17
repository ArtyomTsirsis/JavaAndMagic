package com.game.dto.hero;

import com.game.dto.armor.ArmorDTO;
import com.game.dto.weapon.WeaponDTO;
import com.game.repository.hero.HeroClass;
import com.game.skills.hero.HeroSkill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HeroDTO {

    @NotBlank
    @Size(min = 3, max = 20)
    private String name;
    private HeroClass heroClass;
    @Range(min = 0)
    private Integer health;
    private Integer strength;
    @Range(min = 1, max = 100)
    private Integer level;
    private Integer dexterity;
    @NotNull
    private ArmorDTO armor;
    @NotNull
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
