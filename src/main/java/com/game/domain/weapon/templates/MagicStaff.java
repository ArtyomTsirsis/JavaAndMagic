package com.game.domain.weapon.templates;

import com.game.domain.weapon.Weapon;
import com.game.domain.weapon.WeaponType;
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
    private Integer magicalDamage = 100;
    private Integer level = 1;
    private Integer criticalHitChance = 1;

}
