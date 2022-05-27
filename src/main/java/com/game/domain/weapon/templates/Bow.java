package com.game.domain.weapon.templates;

import com.game.domain.weapon.Weapon;
import com.game.domain.weapon.WeaponType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Bow extends Weapon {

    private Integer weaponID;
    private String owner;
    private WeaponType weaponType = WeaponType.BOW;
    private Integer durability = 100;
    private Integer physicalDamage = 60;
    private Integer magicalDamage = 0;
    private Integer level = 1;
    private Integer criticalHitChance = 5;

}
