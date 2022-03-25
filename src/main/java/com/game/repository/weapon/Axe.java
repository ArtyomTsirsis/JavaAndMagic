package com.game.repository.weapon;

import com.game.repository.hero.HeroClass;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Axe implements Weapon {

    private Integer id;
    private WeaponType weaponType = WeaponType.AXE;
    private HeroClass[] whoCanUse = {HeroClass.KNIGHT};
    private Integer durability = 50;
    private Integer physicalDamage = 100;
    private Integer magicalDamage = 0;
    private Integer level = 1;
    private Integer criticalHitChance = 2;

    @Override
    public void increaseLevel() {
        level++;
    }

    @Override
    public void decreaseDurability() {
        this.durability--;
    }

}
