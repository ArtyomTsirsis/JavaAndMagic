package com.game.repository.weapon;

import com.game.repository.hero.HeroClass;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Bow implements Weapon {

    private Integer id;
    WeaponType weaponType = WeaponType.BOW;
    HeroClass[] whoCanUse = {HeroClass.ARCHER};
    Integer durability = 100;
    Integer physicalDamage = 30;
    Integer magicalDamage = 0;
    Integer level = 1;
    Integer criticalHitChance = 5;

    @Override
    public void increaseLevel() {
        level++;
    }

    @Override
    public void decreaseDurability() {
        this.durability--;
    }

}
