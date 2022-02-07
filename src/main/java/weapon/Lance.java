package weapon;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Lance implements Weapon {

    WeaponType weaponType = WeaponType.LANCE;
    Integer durability = 100;
    Integer physicalDamage = 20;
    Integer magicalDamage = 20;
    Integer level = 1;

}
