package com.game.repository.weapon;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Lance implements Weapon {

    private Integer id;
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
        this.durability--;
    }

}
