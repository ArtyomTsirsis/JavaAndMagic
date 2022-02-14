package repository.armor;

public interface Armor {

    ArmorClass getArmorClass();
    Integer getDurability();
    void setDurability(Integer durability);
    Integer getPhysicalDefense();
    void setPhysicalDefense(Integer Defense);
    Integer getMagicalDefense();
    void setMagicalDefense(Integer defense);
    String toString();

}
