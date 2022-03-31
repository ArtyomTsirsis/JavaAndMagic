package com.game.repository.weapon.templates;

import com.game.repository.weapon.Weapon;
import com.game.repository.weapon.WeaponType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Lance extends Weapon {

    private Integer weaponID;
    private String owner;
    private WeaponType weaponType = WeaponType.LANCE;
    private Integer durability = 100;
    private Integer physicalDamage = 20;
    private Integer magicalDamage = 20;
    private Integer level = 1;
    private Integer criticalHitChance = 8;

    @Override
    public void increaseLevel() {
        level++;
    }

    @Override
    public void decreaseDurability() {
        durability--;
    }

}