package com.game.repository.weapon;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MagicStaff implements Weapon {

    private Integer id;
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
        this.durability--;
    }

}
