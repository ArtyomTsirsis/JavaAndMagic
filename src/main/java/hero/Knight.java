package hero;

import armor.Armor;
import weapon.Sword;

public class Knight extends Hero {

    private final static HeroClass heroClass = HeroClass.Knight;
    private Sword weapon;

    public Knight(String name, Integer health, Integer strength, Integer level, Integer dexterity, Armor armor, Sword weapon) {
        super(name, health, strength, level, dexterity, armor);
        this.weapon = weapon;
    }

}
