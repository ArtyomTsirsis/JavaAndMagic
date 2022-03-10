package com.game.repository.weapon;

import com.game.repository.hero.HeroClass;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Lance implements Weapon {

    WeaponType weaponType = WeaponType.LANCE;
    HeroClass[] whoCanUse = {HeroClass.THIEF};
    Integer durability = 100;
    Integer physicalDamage = 20;
    Integer magicalDamage = 20;
    Integer level = 1;
    Integer criticalHitChance = 8;

    @Override
    public void increaseLevel() {
        level++;
    }

}
