package com.game.repository.weapon;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "weapon")
@Table(name = "weapon")
public class Weapon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer weaponID;
    @Column
    private String owner;
    @Column(columnDefinition = "ENUM('WITHOUT_WEAPON', 'AXE', 'BOW', 'LANCE', 'MAGIC_STAFF', 'SWORD')")
    @Enumerated(EnumType.STRING)
    private WeaponType weaponType;
    @Column
    private Integer durability;
    @Column
    private Integer physicalDamage;
    @Column
    private Integer magicalDamage;
    @Column
    private Integer level;
    @Column
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
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Weapon weapon = (Weapon) o;
        return weaponID != null && Objects.equals(weaponID, weapon.weaponID);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
