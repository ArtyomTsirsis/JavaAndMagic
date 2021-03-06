package com.game.dto.weapon;

import com.game.domain.weapon.WeaponType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeaponDTO {

    private Integer id;
    private String owner;
    private WeaponType weaponType;
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
