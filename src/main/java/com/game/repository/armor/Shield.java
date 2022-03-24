package com.game.repository.armor;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Shield implements Armor {

    private Integer id;
    private ArmorClass armorClass = ArmorClass.SHIELD;
    private Integer durability = 30;
    private Integer physicalDefense = 70;
    private Integer magicalDefense = 0;

    @Override
    public void decreaseDurability() {
        this.durability--;
    }

}
