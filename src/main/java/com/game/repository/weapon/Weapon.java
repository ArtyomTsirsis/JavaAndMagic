package com.game.repository.weapon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Weapon {

    private Integer weaponID;
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
        durability--;
    }

}
