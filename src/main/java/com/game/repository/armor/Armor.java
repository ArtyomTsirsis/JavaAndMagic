package com.game.repository.armor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Armor {

    private Integer armorID;
    private String owner;
    private ArmorClass armorClass;
    private Integer durability;
    private Integer physicalDefense;
    private Integer magicalDefense;

    public void decreaseDurability() {
        this.durability--;
    }

}
