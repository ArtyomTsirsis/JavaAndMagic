package com.game.repository.armor.templates;

import com.game.repository.armor.Armor;
import com.game.repository.armor.ArmorClass;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ArmorSuit extends Armor {

    private Integer armorID;
    private String owner;
    private ArmorClass armorClass = ArmorClass.ARMOR_SUIT;
    private Integer durability = 100;
    private Integer physicalDefense = 30;
    private Integer magicalDefense = 0;

}
