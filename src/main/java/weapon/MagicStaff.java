package weapon;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MagicStaff implements Weapon {

    WeaponType weaponType = WeaponType.MAGIC_STAFF;
    Integer durability = 30;
    Integer physicalDamage = 0;
    Integer magicalDamage = 50;
    Integer level = 1;

}
