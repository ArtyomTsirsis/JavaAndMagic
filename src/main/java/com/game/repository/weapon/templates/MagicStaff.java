package com.game.repository.weapon.templates;

import com.game.repository.weapon.Weapon;
import com.game.repository.weapon.WeaponType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class MagicStaff extends Weapon {

    private Integer weaponID;
    private String owner;
    private WeaponType weaponType = WeaponType.MAGIC_STAFF;
    private Integer durability = 30;
    private Integer physicalDamage = 0;
    private Integer magicalDamage = 50;
    private Integer level = 1;
    private Integer criticalHitChance = 1;

    @Override
    public void increaseLevel() {
        level++;
    }

    @Override
    public void decreaseDurability() {
        durability--;
    }

}
