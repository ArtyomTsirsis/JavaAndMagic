package com.game.dto.weapon;

import com.game.repository.hero.HeroClass;
import com.game.repository.weapon.WeaponType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WeaponDTO {

    private Integer id;
    private WeaponType weaponType;
    private HeroClass[] whoCanUse;
    private Integer durability;
    private Integer physicalDamage;
    private Integer magicalDamage;
    private Integer level;
    private Integer criticalHitChance;

    public void increaseLevel() {
        level++;
    }

    public void decreaseDurability() {
        this.durability--;
    }

    public boolean isBroken() {
        return 1 > durability;
    }

}
