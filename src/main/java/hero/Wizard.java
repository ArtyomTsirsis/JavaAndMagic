package hero;

import armor.Armor;
import weapon.MagicalWeapon;

public class Wizard extends Hero {

    private final static HeroClass heroClass = HeroClass.Wizard;
    private MagicalWeapon weapon;

    public Wizard(String name, Integer health, Integer strength, Integer level, Integer dexterity, Armor armor, MagicalWeapon weapon) {
        super(name, health, strength, level, dexterity, armor);
        this.weapon = weapon;
    }

}
