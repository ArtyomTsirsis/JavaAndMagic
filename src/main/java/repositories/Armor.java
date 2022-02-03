package repositories;

import enums.ArmorClass;

public class Armor {

    private ArmorClass armorClass;
    private Integer durability;
    private Integer physicalDefense;
    private Integer magicalDefense;

    public Armor(ArmorClass armorClass, Integer durability, Integer physicalDefense, Integer magicalDefense) {
        this.armorClass = armorClass;
        this.durability = durability;
        this.physicalDefense = physicalDefense;
        this.magicalDefense = magicalDefense;
    }

    public ArmorClass getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(ArmorClass armorClass) {
        this.armorClass = armorClass;
    }

    public Integer getDurability() {
        return durability;
    }

    public void setDurability(Integer durability) {
        this.durability = durability;
    }

    public Integer getPhysicalDefense() {
        return physicalDefense;
    }

    public void setPhysicalDefense(Integer physicalDefense) {
        this.physicalDefense = physicalDefense;
    }

    public Integer getMagicalDefense() {
        return magicalDefense;
    }

    public void setMagicalDefense(Integer magicalDefense) {
        this.magicalDefense = magicalDefense;
    }

}
