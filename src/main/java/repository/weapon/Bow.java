package repository.weapon;

import repository.hero.HeroClass;
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

}