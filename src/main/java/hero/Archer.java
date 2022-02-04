package hero;

import armor.Armor;
import weapon.LongRangeWeapon;

public class Archer extends Hero {

    private final static HeroClass heroClass = HeroClass.Archer;
    private LongRangeWeapon weapon;

    public Archer(String name, Integer health, Integer strength, Integer level, Integer dexterity, Armor armor, LongRangeWeapon weapon) {
        super(name, health, strength, level, dexterity, armor);
        this.weapon = weapon;
    }

}
