package weapon;

import hero.HeroClass;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Axe implements Weapon {

    WeaponType weaponType = WeaponType.AXE;
    HeroClass whoCanUse = HeroClass.KNIGHT;
    Integer durability = 50;
    Integer physicalDamage = 100;
    Integer magicalDamage = 0;
    Integer level = 1;

}
