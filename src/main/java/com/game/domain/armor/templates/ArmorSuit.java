package com.game.domain.armor.templates;

import com.game.domain.armor.Armor;
import com.game.domain.armor.ArmorClass;
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
