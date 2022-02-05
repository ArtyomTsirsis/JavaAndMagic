package hero;

import armor.Armor;
import weapon.Bow;

public class Archer extends Hero {

    private final static HeroClass heroClass = HeroClass.Archer;
    private Bow weapon;

    public Archer(String name, Integer health, Integer strength, Integer level, Integer dexterity, Armor armor, Bow weapon) {
        super(name, health, strength, level, dexterity, armor);
        this.weapon = weapon;
    }

}
