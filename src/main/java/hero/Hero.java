package hero;

import armor.Armor;

//@AllArgsConstructor
public class
Hero {

    private String name;
//    private HeroClass heroClass;
    private Integer health;
    private Integer strength;
    private Integer level;
    private Integer dexterity;
    private Armor armor;

    public Hero(String name, Integer health, Integer strength, Integer level, Integer dexterity, Armor armor) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.level = level;
        this.dexterity = dexterity;
        this.armor = armor;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", strength=" + strength +
                ", level=" + level +
                ", dexterity=" + dexterity +
                ", armor=" + armor +
                '}';
    }

}