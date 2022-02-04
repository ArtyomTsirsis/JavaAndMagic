package hero;

import armor.Armor;
import weapon.LightWeapon;

public class Thief extends Hero {

    private final static HeroClass heroClass = HeroClass.Thief;
    private LightWeapon weapon;

    public Thief(String name, Integer health, Integer strength, Integer level, Integer dexterity, Armor armor, LightWeapon weapon) {
        super(name, health, strength, level, dexterity, armor);
        this.weapon = weapon;

    }

}
