package com.game.repository.weapon;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Sword implements Weapon {

    private Integer id;
    private String owner;
    private WeaponType weaponType = WeaponType.BOW;
    private Integer durability = 100;
    private Integer physicalDamage = 70;
    private Integer magicalDamage = 0;
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

    public void setOwner(String owner) {
        this.owner = owner;
    }

}
