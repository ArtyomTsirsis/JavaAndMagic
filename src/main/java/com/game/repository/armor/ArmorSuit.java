package com.game.repository.armor;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ArmorSuit implements Armor {

    private Integer id;
    private ArmorClass armorClass = ArmorClass.ARMOR_SUIT;
    private Integer durability = 100;
    private Integer physicalDefense = 30;
    private Integer magicalDefense = 0;

    @Override
    public void decreaseDurability() {
        this.durability--;
    }

}
