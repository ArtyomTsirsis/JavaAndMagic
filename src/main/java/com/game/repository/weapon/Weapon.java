package com.game.repository.weapon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="weapon")
public class Weapon {

    @Id
    private Integer weaponID;
    @Column
    private String owner;
    @Column
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

    public void increaseLevel() {
        level++;
    }

    public void decreaseDurability() {
        durability--;
    }

}
