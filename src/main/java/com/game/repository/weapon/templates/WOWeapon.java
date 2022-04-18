package com.game.repository.weapon.templates;

import com.game.repository.weapon.Weapon;
import com.game.repository.weapon.WeaponType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class WOWeapon extends Weapon {

    private Integer weaponID;
    private String owner;
    private WeaponType weaponType = WeaponType.WITHOUT_WEAPON;
    private Integer durability = Integer.MAX_VALUE;
    private Integer physicalDamage = 0;
    private Integer magicalDamage = 0;
    private Integer level = 1;
    private Integer criticalHitChance = 0;

}
