package hero;

import armor.Armor;
import weapon.PhysicalWeapon;

public class Knight extends Hero {

    private final static HeroClass heroClass = HeroClass.Knight;
    private PhysicalWeapon weapon;

    public Knight(String name, Integer health, Integer strength, Integer level, Integer dexterity, Armor armor, PhysicalWeapon weapon) {
        super(name, health, strength, level, dexterity, armor);
        this.weapon = weapon;
    }

}
