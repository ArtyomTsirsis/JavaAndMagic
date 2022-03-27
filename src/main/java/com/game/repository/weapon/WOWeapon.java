package com.game.repository.weapon;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class WOWeapon implements Weapon {

    private Integer id = -1;
    private String owner;
    private WeaponType weaponType = WeaponType.WITHOUT_WEAPON;
    private Integer durability = 1;
    private Integer physicalDamage = 0;
    private Integer magicalDamage = 0;
    private Integer level = 1;
    private Integer criticalHitChance = 0;

    @Override
    public void increaseLevel() {}

    @Override
    public void decreaseDurability() {}

    public void setOwner(String owner) {
        this.owner = owner;
    }

}
