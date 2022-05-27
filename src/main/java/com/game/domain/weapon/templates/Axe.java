package com.game.domain.weapon.templates;

import com.game.domain.weapon.Weapon;
import com.game.domain.weapon.WeaponType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Axe extends Weapon {

    private Integer weaponID;
    private String owner;
    private WeaponType weaponType = WeaponType.AXE;
    private Integer durability = 50;
    private Integer physicalDamage = 150;
    private Integer magicalDamage = 0;
    private Integer level = 1;
    private Integer criticalHitChance = 2;

}
