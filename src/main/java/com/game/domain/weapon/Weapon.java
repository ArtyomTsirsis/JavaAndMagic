package com.game.domain.weapon;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="weapon")
@Table(name="weapon")
public class Weapon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer weaponID;
    @Column
    private String owner;
    @Column(name = "weapon_type", columnDefinition = "ENUM('WITHOUT_WEAPON', 'AXE', 'BOW', 'LANCE', 'MAGIC_STAFF', 'SWORD')")
    @Enumerated(EnumType.STRING)
    private WeaponType weaponType;
    @Column
    private Integer durability;
    @Column(name = "physical_damage")
    private Integer physicalDamage;
    @Column(name = "magical_damage")
    private Integer magicalDamage;
    @Column
    private Integer level;
    @Column(name = "critical_hit_chance")
    private Integer criticalHitChance;

    public Weapon(Weapon weapon) {
        this.weaponID = weapon.getWeaponID();
        this.owner = weapon.getOwner();
        this.weaponType = weapon.getWeaponType();
        this.durability = weapon.getDurability();
        this.physicalDamage = weapon.getPhysicalDamage();
        this.magicalDamage = weapon.getMagicalDamage();
        this.level = weapon.getLevel();
        this.criticalHitChance = weapon.getCriticalHitChance();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Weapon weapon)) return false;
        return Objects.equals(getWeaponID(), weapon.getWeaponID()) && Objects.equals(getOwner(), weapon.getOwner()) && getWeaponType() == weapon.getWeaponType() && Objects.equals(getDurability(), weapon.getDurability()) && Objects.equals(getPhysicalDamage(), weapon.getPhysicalDamage()) && Objects.equals(getMagicalDamage(), weapon.getMagicalDamage()) && Objects.equals(getLevel(), weapon.getLevel()) && Objects.equals(getCriticalHitChance(), weapon.getCriticalHitChance());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWeaponID(), getOwner(), getWeaponType(), getDurability(), getPhysicalDamage(), getMagicalDamage(), getLevel(), getCriticalHitChance());
    }

}
