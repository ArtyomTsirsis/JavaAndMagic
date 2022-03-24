package com.game.repository.weapon;

import com.game.repository.hero.HeroClass;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class WOWeapon implements Weapon {

    private Integer id = -1;
    WeaponType weaponType = WeaponType.WITHOUT_WEAPON;
    HeroClass[] whoCanUse = {HeroClass.ALL};
    Integer durability = 1;
    Integer physicalDamage = 0;
    Integer magicalDamage = 0;
    Integer level = 1;
    Integer criticalHitChance = 0;

    @Override
    public void increaseLevel() {}

    @Override
    public void decreaseDurability() {}

}
