package com.game.repository.armor;

public interface Armor {

    int getId();
    ArmorClass getArmorClass();
    Integer getDurability();
    void setDurability(Integer durability);
    void decreaseDurability();
    Integer getPhysicalDefense();
    void setPhysicalDefense(Integer Defense);
    Integer getMagicalDefense();
    void setMagicalDefense(Integer defense);
    String toString();

}