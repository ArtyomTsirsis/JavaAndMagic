package hero;

import armor.Armor;
import weapon.Axe;

public class Thief extends Hero {

    private final static HeroClass heroClass = HeroClass.Thief;
    private Axe weapon;

    public Thief(String name, Integer health, Integer strength, Integer level, Integer dexterity, Armor armor, Axe weapon) {
        super(name, health, strength, level, dexterity, armor);
        this.weapon = weapon;

    }

}
