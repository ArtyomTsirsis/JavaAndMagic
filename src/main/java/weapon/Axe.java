package weapon;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Axe implements Weapon {

    WeaponType weaponType = WeaponType.AXE;
    Integer durability = 50;
    Integer physicalDamage = 100;
    Integer magicalDamage = 0;
    Integer level = 1;

}
