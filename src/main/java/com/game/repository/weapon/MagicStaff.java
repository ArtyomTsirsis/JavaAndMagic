package com.game.repository.weapon;

import com.game.repository.hero.HeroClass;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MagicStaff implements Weapon {

    private Integer id;
    WeaponType weaponType = WeaponType.MAGIC_STAFF;
    HeroClass[] whoCanUse = {HeroClass.WIZARD};
    Integer durability = 30;
    Integer physicalDamage = 0;
    Integer magicalDamage = 50;
    Integer level = 1;
    Integer criticalHitChance = 1;

    @Override
    public void increaseLevel() {
        level++;
    }

    @Override
    public void decreaseDurability() {
        this.durability--;
    }

}