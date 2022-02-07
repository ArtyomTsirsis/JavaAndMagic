package hero;

import armor.Armor;
import armor.LeatherArmor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import weapon.Bow;
import weapon.Weapon;

@RequiredArgsConstructor
@ToString
@Data
public class Archer implements Hero {

    private final static HeroClass heroClass = HeroClass.ARCHER;
    @NonNull
    private String name;
    private Integer health = 150;
    private Integer strength = 10;
    private Integer level = 1;
    private Integer dexterity = 35;
    private Armor armor = new LeatherArmor();
    private Weapon weapon = new Bow();

}