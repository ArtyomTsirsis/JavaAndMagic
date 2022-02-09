package weapon;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Bow implements Weapon {

    WeaponType weaponType = WeaponType.BOW;
    Integer durability = 100;
    Integer physicalDamage = 30;
    Integer magicalDamage = 0;
    Integer level = 1;

}
