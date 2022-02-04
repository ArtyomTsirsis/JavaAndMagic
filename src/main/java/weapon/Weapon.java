package weapon;

//@AllArgsConstructor
//@ToString
public abstract class Weapon {

    private WeaponType weaponType;
    private Integer durability;
    private Integer physicalDamage;
    private Integer magicalDamage;
    private Integer level;

    public Weapon(WeaponType weaponType, Integer durability, Integer physicalDamage, Integer magicalDamage, Integer level) {
        this.weaponType = weaponType;
        this.durability = durability;
        this.physicalDamage = physicalDamage;
        this.magicalDamage = magicalDamage;
        this.level = level;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "weaponType=" + weaponType +
                ", durability=" + durability +
                ", physicalDamage=" + physicalDamage +
                ", magicalDamage=" + magicalDamage +
                ", level=" + level +
                '}';
    }

}