package repositories;

import enums.HeroClass;

public class Hero {

    private HeroClass heroClass;
    private Integer health;
    private Integer strength;
    private Integer level;
    private Integer dexterity;
    private Weapon weapon;
    private Armor armor;

    public Hero(HeroClass heroClass, Integer health, Integer strength, Integer level, Integer dexterity, Weapon weapon, Armor armor) {
        this.heroClass = heroClass;
        this.health = health;
        this.strength = strength;
        this.level = level;
        this.dexterity = dexterity;
        this.weapon = weapon;
        this.armor = armor;
    }

    public HeroClass getHeroClass() {
        return heroClass;
    }

    public void setHeroClass(HeroClass heroClass) {
        this.heroClass = heroClass;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getDexterity() {
        return dexterity;
    }

    public void setDexterity(Integer dexterity) {
        this.dexterity = dexterity;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

}