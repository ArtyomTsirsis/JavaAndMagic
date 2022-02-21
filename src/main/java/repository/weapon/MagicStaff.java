package repository.weapon;

import repository.hero.HeroClass;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MagicStaff implements Weapon {

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

}
