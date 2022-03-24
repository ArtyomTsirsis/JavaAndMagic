package com.game.repository.weapon;

import com.game.repository.hero.HeroClass;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Sword implements Weapon {

    private Integer id;
    WeaponType weaponType = WeaponType.BOW;
    HeroClass[] whoCanUse = {HeroClass.KNIGHT};
    Integer durability = 100;
    Integer physicalDamage = 70;
    Integer magicalDamage = 0;
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
