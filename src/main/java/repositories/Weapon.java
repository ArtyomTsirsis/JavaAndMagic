package repositories;

import enums.WeaponClass;

public class Weapon {

    private WeaponClass weaponClass;
    private Integer durability;
    private Integer physicalDamage;
    private Integer magicalDamage;
    private Integer level;

    public Weapon(WeaponClass weaponClass, Integer durability, Integer physicalDamage, Integer magicalDamage, Integer level) {
        this.weaponClass = weaponClass;
        this.durability = durability;
        this.physicalDamage = physicalDamage;
        this.magicalDamage = magicalDamage;
        this.level = level;
    }

    public WeaponClass getWeaponClass() {
        return weaponClass;
    }

    public void setWeaponClass(WeaponClass weaponClass) {
        this.weaponClass = weaponClass;
    }

    public Integer getDurability() {
        return durability;
    }

    public void setDurability(Integer durability) {
        this.durability = durability;
    }

    public Integer getPhysicalDamage() {
        return physicalDamage;
    }

    public void setPhysicalDamage(Integer physicalDamage) {
        this.physicalDamage = physicalDamage;
    }

    public Integer getMagicalDamage() {
        return magicalDamage;
    }

    public void setMagicalDamage(Integer magicalDamage) {
        this.magicalDamage = magicalDamage;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

}
