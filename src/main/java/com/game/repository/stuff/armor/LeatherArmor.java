package com.game.repository.stuff.armor;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class LeatherArmor implements Armor {

    private ArmorClass armorClass = ArmorClass.LEATHER_ARMOR;
    private Integer durability = 20;
    private Integer physicalDefense = 30;
    private Integer magicalDefense = 0;

}
