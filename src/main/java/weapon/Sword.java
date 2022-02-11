package weapon;

import hero.HeroClass;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Sword implements Weapon {

    WeaponType weaponType = WeaponType.BOW;
    HeroClass whoCanUse = HeroClass.KNIGHT;
    Integer durability = 100;
    Integer physicalDamage = 70;
    Integer magicalDamage = 0;
    Integer level = 1;

}
