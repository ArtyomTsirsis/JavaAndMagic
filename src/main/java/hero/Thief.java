package hero;

import armor.Armor;
import armor.LeatherArmor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import weapon.Lance;
import weapon.Weapon;

@RequiredArgsConstructor
@ToString
@Data
public class Thief implements Hero {

    private final static HeroClass heroClass = HeroClass.THIEF;
    @NonNull
    private String name;
    private Integer health = 250;
    private Integer strength = 15;
    private Integer level = 1;
    private Integer dexterity = 30;
    private Armor armor = new LeatherArmor();
    private Weapon weapon = new Lance();

}
