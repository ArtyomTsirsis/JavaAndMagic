package hero;

import armor.Armor;
import armor.Shield;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import weapon.Sword;
import weapon.Weapon;

@RequiredArgsConstructor
@Data
@ToString
public class Knight implements Hero {

    private final static HeroClass heroClass = HeroClass.KNIGHT;
    @NonNull
    private String name;
    private Integer health = 400;
    private Integer strength = 20;
    private Integer level = 1;
    private Integer dexterity = 20;
    private Armor armor = new Shield();
    private Weapon weapon = new Sword();

}
