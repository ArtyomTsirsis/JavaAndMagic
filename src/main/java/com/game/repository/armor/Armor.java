package com.game.repository.armor;

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
@Table(name="armor")
public class Armor {

    @Id
    private Integer armorID;
    @Column
    private String owner;
    @Column
    private ArmorClass armorClass;
    @Column
    private Integer durability;
    @Column
    private Integer physicalDefense;
    @Column
    private Integer magicalDefense;

    public void decreaseDurability() {
        this.durability--;
    }

}
