package hero;

import armor.Armor;
import weapon.Lance;

public class Wizard extends Hero {

    private final static HeroClass heroClass = HeroClass.Wizard;
    private Lance weapon;

    public Wizard(String name, Integer health, Integer strength, Integer level, Integer dexterity, Armor armor, Lance weapon) {
        super(name, health, strength, level, dexterity, armor);
        this.weapon = weapon;
    }

}
