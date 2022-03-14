package com.game.repository.stuff.weapon;

import com.game.repository.hero.HeroClass;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Bow implements Weapon {

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

}
