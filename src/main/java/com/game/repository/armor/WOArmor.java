package com.game.repository.armor;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class WOArmor implements Armor {

    private Integer id = -1;
    private String owner;
    private ArmorClass armorClass = ArmorClass.WITHOUT_ARMOR;
    private Integer durability = 1;
    private Integer physicalDefense = 0;
    private Integer magicalDefense = 0;

    @Override
    public void decreaseDurability() {}

}
