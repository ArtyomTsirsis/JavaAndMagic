package com.game.repository.weapon.templates;

import com.game.repository.weapon.Weapon;
import com.game.repository.weapon.WeaponType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Bow extends Weapon {

    private Integer weaponID;
    private String owner;
    private WeaponType weaponType = WeaponType.BOW;
    private Integer durability = 100;
    private Integer physicalDamage = 30;
    private Integer magicalDamage = 0;
    private Integer level = 1;
    private Integer criticalHitChance = 5;

    @Override
    public void increaseLevel() {
        level++;
    }

    @Override
    public void decreaseDurability() {
        durability--;
    }

}
