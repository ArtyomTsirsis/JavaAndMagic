package hero;

import armor.Armor;
import armor.MagicalShield;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import weapon.MagicStaff;
import weapon.Weapon;

@RequiredArgsConstructor
@ToString
@Data
public class Wizard implements Hero {

    private final static HeroClass heroClass = HeroClass.WIZARD;
    @NonNull
    private String name;
    private Integer health = 200;
    private Integer strength = 15;
    private Integer level = 1;
    private Integer dexterity = 25;
    private Armor armor = new MagicalShield();
    private Weapon weapon = new MagicStaff();

}
